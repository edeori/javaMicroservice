package hu.microservice.medicare.user;

import org.springframework.stereotype.Component;

import hu.microservice.medicare.keycloak.KeycloakUser;

@Component
public class UserMapper {

    public UserMeta map(KeycloakUser keycloakUser) {
        var meta = new UserMeta();
        meta.setId(keycloakUser.getId());
        meta.setEmail(keycloakUser.getEmail());
        return meta;
    }

}
