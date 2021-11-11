package hu.microservice.medicare.security;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

public class KeycloakTokenConverter implements Converter<Jwt, AbstractAuthenticationToken> {

    @Override
    public AbstractAuthenticationToken convert(Jwt jwt) {
        return new JwtAuthenticationToken(jwt, convertAuthoritiesFromToken(jwt));
    }

    private Collection<GrantedAuthority> convertAuthoritiesFromToken(Jwt jwt) {
        // prefix to map to a Spring Security "role"        
        return getRolesFromToken(jwt).stream()
                .map("ROLE_"::concat)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    @SuppressWarnings("unchecked")
    private List<String> getRolesFromToken(Jwt token) {
        var claims = token.getClaims();
        var realmAccess = (Map<String, Object>) claims.getOrDefault("realm_access", Map.of());
        return (List<String>) realmAccess.getOrDefault("roles", List.of());
    }

}
