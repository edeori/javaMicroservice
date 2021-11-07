package hu.microservice.medicare.feign;

import java.util.Collection;

public interface ContentTypeAware {
    boolean supportsContentType(String contentType);

    default boolean supportsContentType(Collection<String> contentTypes) {
        return contentTypes.stream().anyMatch(this::supportsContentType);
    }
}
