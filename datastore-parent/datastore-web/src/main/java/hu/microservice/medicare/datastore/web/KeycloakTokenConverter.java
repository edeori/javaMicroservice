package hu.microservice.medicare.datastore.web;

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
    private Collection<GrantedAuthority> convertAuthoritiesFromToken(Jwt jwt) {
        final Map<String, Object> realmAccess = (Map<String, Object>) jwt.getClaims().get("realm_access");
        // prefix to map to a Spring Security "role"
        List<String> roles = (List<String>) realmAccess.get("roles");
        return roles.stream().map(roleName -> "ROLE_" + roleName).map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    @Override
    public AbstractAuthenticationToken convert(Jwt jwt) {
        return new JwtAuthenticationToken(jwt, convertAuthoritiesFromToken(jwt));
    }
}
