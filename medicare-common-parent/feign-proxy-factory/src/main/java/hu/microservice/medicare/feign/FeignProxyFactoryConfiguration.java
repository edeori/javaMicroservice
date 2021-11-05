package hu.microservice.medicare.feign;

import java.util.Collection;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.CollectionUtils;

import feign.RequestInterceptor;
import feign.form.spring.SpringFormEncoder;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.spring.SpringContract;

@Configuration
public class FeignProxyFactoryConfiguration {

    @Bean
    public FeignProxyFactory proxyFactory(Collection<RequestInterceptor> defaultInterceptors) {
        var jsonEncoder = new ContentTypeAwareDelegatingEncoder(
                Set.of(MediaType.APPLICATION_JSON_VALUE),
                new JacksonEncoder());
        var jsonDecoder = new ContentTypeAwareDelegatingDecoder(
                Set.of(MediaType.APPLICATION_JSON_VALUE),
                new JacksonDecoder());
        var xmlCodec = new XmlCodec();
        var springFormEncoder = new ContentTypeAwareDelegatingEncoder(
                Set.of(MediaType.MULTIPART_FORM_DATA_VALUE),
                new SpringFormEncoder());
        var chainCodec = new ChainCodec(
                Set.of(jsonEncoder, xmlCodec, springFormEncoder),
                Set.of(jsonDecoder, xmlCodec));
        var contract = new SpringContract();
        return new FeignProxyFactory(chainCodec, chainCodec, contract, defaultInterceptors);
    }

    @Bean
    public RequestInterceptor defaultAcceptHeaderRequestInterceptor() {
        return requestTemplate -> {
            Collection<String> acceptHeaderValues = requestTemplate.headers().get(HttpHeaders.ACCEPT);

            if (CollectionUtils.isEmpty(acceptHeaderValues)
                    || acceptHeaderValues.stream().anyMatch(value -> value.contains("*/*"))) {

                requestTemplate.header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
            }
        };
    }

}
