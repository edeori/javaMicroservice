package hu.microservice.medicare.security;

import java.util.logging.Logger;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

import hu.microservice.medicare.feign.FeignProxyFactoryConfiguration;

public class JwtAuthorizationSupplier implements AuthorizationSupplier {
    
    Logger LOG = Logger.getLogger(FeignProxyFactoryConfiguration.class.toString());

    @Override
    public String get() {
        var securityContext = SecurityContextHolder.getContext();
        if (securityContext == null) {
            return null;
        }
        var authentication = securityContext.getAuthentication();
        if (authentication == null) {
            return null;
        }
        if (authentication instanceof JwtAuthenticationToken) {
            var jwtAuthentication = (JwtAuthenticationToken) authentication;
            return jwtAuthentication.getToken().getTokenValue();
        }
        return null;
    }

}
