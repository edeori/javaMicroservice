package hu.microservice.medicare.security;

import org.springframework.http.HttpHeaders;
import feign.RequestInterceptor;
import feign.RequestTemplate;

public class AuthorizationHeaderInterceptor implements RequestInterceptor {

    private final AuthorizationSupplier tokenSupplier;

    public AuthorizationHeaderInterceptor(AuthorizationSupplier tokenSupplier) {
        this.tokenSupplier = tokenSupplier;
    }

    @Override
    public void apply(RequestTemplate template) {
        var token = tokenSupplier.get();
        
        if (token != null) {
            template.header(HttpHeaders.AUTHORIZATION, "Bearer " + token);
        }
    }

}
