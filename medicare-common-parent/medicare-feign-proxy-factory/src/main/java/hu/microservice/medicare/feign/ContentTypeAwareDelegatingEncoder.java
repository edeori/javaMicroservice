package hu.microservice.medicare.feign;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Set;

import feign.RequestTemplate;
import feign.codec.EncodeException;
import feign.codec.Encoder;

public class ContentTypeAwareDelegatingEncoder implements ContentTypeAware, Encoder {
    private final Set<String> contentTypes;
    private final Encoder delegate;

    public ContentTypeAwareDelegatingEncoder(Collection<String> contentTypes, Encoder delegate) {
        this.contentTypes = Set.copyOf(contentTypes);
        this.delegate = delegate;
    }

    public ContentTypeAwareDelegatingEncoder(String contentType, Encoder delegate) {
        this.contentTypes = Set.of(contentType);
        this.delegate = delegate;
    }

    @Override
    public boolean supportsContentType(String contentType) {
        return contentTypes.contains(contentType);
    }

    @Override
    public void encode(Object object, Type bodyType, RequestTemplate template) throws EncodeException {
        delegate.encode(object, bodyType, template);
    }
}
