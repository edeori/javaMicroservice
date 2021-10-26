package hu.microservice.medicare.datastore;

import java.util.Set;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/api/DataStore", produces = MediaType.APPLICATION_JSON_VALUE)
public interface SportApi {

    @GetMapping(value = "/Sport", produces = MediaType.APPLICATION_JSON_VALUE)
    Set<Sport> getAll();

    @GetMapping(value = "/Sport/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    Sport getById(@PathVariable(value = "id") String id);

    @PostMapping(value = "/Sport/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    Sport updateById(@PathVariable(value = "id") String id, @RequestBody Sport sport);

    @PutMapping(value = "/Sport", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    Sport create(@RequestBody Sport sport);

    @DeleteMapping(value = "/Sport/{id}")
    void delete(@PathVariable(value = "id") String id);

}
