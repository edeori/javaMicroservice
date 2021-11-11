package hu.microservice.medicare.user;

import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;

@Component
public class KeycloakTokenHelper {
    
    public String getIdFromJwt(Jwt jwt) {
        return (String) jwt.getClaims().get("sub");
    }
    
    public String getRealmFromJwt(Jwt jwt) {
        String iss = (String) jwt.getClaims().get("iss");
        return iss.split("/(?!.*/)")[1];
    }
    
    public String getTokenValue(Jwt jwt) {
        return jwt.getTokenValue();
    }

}
