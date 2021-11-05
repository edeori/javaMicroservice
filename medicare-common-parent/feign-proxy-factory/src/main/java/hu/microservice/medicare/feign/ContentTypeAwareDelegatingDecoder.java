package hu.microservice.medicare.feign;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Set;

import feign.FeignException;
import feign.Response;
import feign.codec.DecodeException;
import feign.codec.Decoder;

public class ContentTypeAwareDelegatingDecoder implements ContentTypeAware, Decoder {

    private final Set<String> contentTypes;
    private final Decoder delegate;

    public ContentTypeAwareDelegatingDecoder(Collection<String> contentTypes, Decoder delegate) {
        this.contentTypes = Set.copyOf(contentTypes);
        this.delegate = delegate;
    }

    public ContentTypeAwareDelegatingDecoder(String contentType, Decoder delegate) {
        this.contentTypes = Set.of(contentType);
        this.delegate = delegate;
    }

    @Override
    public Object decode(Response response, Type type) throws IOException, DecodeException, FeignException {
        return delegate.decode(response, type);
    }

    @Override
    public boolean supportsContentType(String contentType) {
        return contentTypes.contains(contentType);
    }
}
