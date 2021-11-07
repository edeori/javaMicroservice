package hu.microservice.medicare.feign;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import feign.Contract;
import feign.Feign;
import feign.RequestInterceptor;
import feign.codec.Decoder;
import feign.codec.Encoder;

public class FeignProxyFactory {
    private final Encoder encoder;
    private final Decoder decoder;
    private final Contract contract;
    private final Map<Key, Object> proxyCache = new ConcurrentHashMap<>();
    private final Set<RequestInterceptor> defaultInterceptors;

    public FeignProxyFactory(
            Encoder encoder,
            Decoder decoder,
            Contract contract,
            Collection<RequestInterceptor> defaultInterceptors) {
        this.encoder = encoder;
        this.decoder = decoder;
        this.contract = contract;
        this.defaultInterceptors = new HashSet<>(defaultInterceptors);
    }

    @SuppressWarnings("unchecked")
    public <T> T createProxyFor(String url, Class<T> interfaceClass) {
        var proxyKey = new Key(url, interfaceClass, defaultInterceptors);
        return (T) proxyCache.computeIfAbsent(proxyKey, this::createProxyInternal);
    }

    @SuppressWarnings("unchecked")
    public <T> T createProxyFor(String url, Class<T> interfaceClass, RequestInterceptor interceptor) {
        var proxyKey = new Key(url, interfaceClass, Set.of(interceptor));
        return (T) proxyCache.computeIfAbsent(proxyKey, this::createProxyInternal);
    }

    @SuppressWarnings("unchecked")
    public <T> T createProxyFor(String url, Class<T> interfaceClass, Collection<RequestInterceptor> interceptors) {
        var proxyKey = new Key(url, interfaceClass, Set.copyOf(interceptors));
        return (T) proxyCache.computeIfAbsent(proxyKey, this::createProxyInternal);
    }

    @SuppressWarnings("unchecked")
    private <T> T createProxyInternal(Key proxyKey) {
        return Feign.builder()
                .encoder(encoder)
                .decoder(decoder)
                .contract(contract)
                .requestInterceptors(proxyKey.interceptors)
                .target((Class<T>) proxyKey.interfaceClass, proxyKey.url);
    }

    private static class Key {
        private final String url;
        private final Class<?> interfaceClass;
        private final Set<RequestInterceptor> interceptors;

        public Key(String url, Class<?> interfaceClass, Set<RequestInterceptor> interceptors) {
            this.url = url;
            this.interfaceClass = interfaceClass;
            this.interceptors = interceptors;
        }

        @Override
        public int hashCode() {
            return Objects.hash(interceptors, interfaceClass.getName(), url);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Key other = (Key) obj;
            return Objects.equals(interceptors, other.interceptors)
                    && Objects.equals(interfaceClass.getName(), other.interfaceClass.getName())
                    && Objects.equals(url, other.url);
        }

    }
}
