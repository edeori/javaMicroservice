package hu.microservice.medicare.user;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/Users")
public interface UserApi {
    
    @GetMapping(value = "/Current", produces = MediaType.APPLICATION_JSON_VALUE)
    UserMeta getUser();

}
