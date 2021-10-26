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
public interface PatientApi {

    @GetMapping(value = "/PatientData", produces = MediaType.APPLICATION_JSON_VALUE)
    Set<PatientData> getAll();

    @GetMapping(value = "/PatientData/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    PatientData getById(@PathVariable(value = "id") String id);

    @PostMapping(value = "/PatientData/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    PatientData updateById(@PathVariable(value = "id") String id, @RequestBody PatientData patientData);

    @PutMapping(value = "/PatientData", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    PatientData create(@RequestBody PatientData patientData);

    @DeleteMapping(value = "/PatientData/{id}")
    void delete(@PathVariable(value = "id") String id);
}
