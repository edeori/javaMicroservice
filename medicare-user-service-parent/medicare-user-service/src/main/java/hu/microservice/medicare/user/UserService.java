package hu.microservice.medicare.user;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final KeycloakApi api;
    private final UserMapper mapper;

    public UserService(KeycloakApi api, UserMapper mapper) {
        this.api = api;
        this.mapper = mapper;
    }

    public UserMeta getUser(String realm, String id) throws UserNotFound {
        /*/
        var keycloakUser = api.getUserById(realm, id);
        
        if(keycloakUser != null) {
            return mapper.map(keycloakUser);
        } else {
            throw new UserNotFound();
        }
        /*/
        if(!id.isBlank()) {
            var user = new UserMeta();
            user.setId(id);
            return user;
        } else {
            throw new UserNotFound();
        }
    }

}
