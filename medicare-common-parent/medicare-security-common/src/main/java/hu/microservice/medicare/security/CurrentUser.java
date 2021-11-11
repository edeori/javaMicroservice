package hu.microservice.medicare.security;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Component;

@Component
public class CurrentUser {
    public String getEmail() {
        return getClaimFromToken("email");
    }

    public String getUserId() {
        return getClaimFromToken("sub");
    }

    public boolean isPresent() {
        return getToken() != null;
    }

    private String getClaimFromToken(String claim) {
        var token = getToken();
        if (token != null) {
            return token.getClaimAsString(claim);
        } else {
            return null;
        }
    }

    private Jwt getToken() {
        var authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof JwtAuthenticationToken) {
            return ((JwtAuthenticationToken) authentication).getToken();
        } else {
            return null;
        }
    }
}
