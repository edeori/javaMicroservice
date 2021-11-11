package hu.microservice.medicare.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/auth")
public interface KeycloakApi {
    
    @GetMapping(value = "/admin/realms/{realm}/users/{id}")
    KeycloakUser getUserById(@PathVariable(value = "realm") String realm, @PathVariable(value = "id") String id);

}
