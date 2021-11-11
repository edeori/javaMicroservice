package hu.microservice.medicare.user;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class UserApiImpl implements UserApi {

    private final UserService service;
    private final KeycloakTokenHelper helper;

    public UserApiImpl(UserService service, KeycloakTokenHelper helper) {
        this.service = service;
        this.helper = helper;
    }

    @Override
    public UserMeta getUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        var jwtToken = (Jwt) authentication.getPrincipal();

        try {
            return service.getUser(helper.getRealmFromJwt(jwtToken),
                    helper.getIdFromJwt(jwtToken));
        } catch (UserNotFound e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

}
