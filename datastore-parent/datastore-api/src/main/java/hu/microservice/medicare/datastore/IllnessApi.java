package hu.microservice.medicare.datastore;

import java.util.Set;

import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/api/DataStore", produces = MediaType.APPLICATION_JSON_VALUE)
public interface IllnessApi {

    @PreAuthorize("hasRole('ILLNESS_READER')")
    @GetMapping(value = "/Illness", produces = MediaType.APPLICATION_JSON_VALUE)
    Set<Illness> getAll();

    @PreAuthorize("hasRole('ILLNESS_READER')")
    @GetMapping(value = "/Illness/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    Illness getById(@PathVariable(value = "id") String id);

    @PreAuthorize("hasRole('ILLNESS_WRITER')")
    @PostMapping(value = "/Illness/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    Illness updateById(@PathVariable(value = "id") String id, @RequestBody Illness illness);

    @PreAuthorize("hasRole('ILLNESS_WRITER')")
    @PutMapping(value = "/Illness", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    Illness create(@RequestBody Illness illness);

    @PreAuthorize("hasRole('ILLNESS_WRITER')")
    @DeleteMapping(value = "/Illness/{id}")
    void delete(@PathVariable(value = "id") String id);

}
