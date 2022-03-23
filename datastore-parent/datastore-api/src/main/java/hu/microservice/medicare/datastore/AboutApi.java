package hu.microservice.medicare.datastore;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/api/About")
public interface AboutApi {
    
    @GetMapping(value = "/{nameId}", produces = MediaType.APPLICATION_JSON_VALUE)
    About getAbout(@PathVariable(value = "nameId") String nameId);

}
