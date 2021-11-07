package hu.microservice.medicare.datastore;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/api/HealthStatus")
public interface HealthStatusApi {
    
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    HealthStatus getByUserId(@PathVariable(value = "id") String id);
    
    @PutMapping(value = "/{patientId}", produces = MediaType.APPLICATION_JSON_VALUE)
    HealthStatus createOrUpdate(@PathVariable(value = "patientId") String patientId, @RequestBody HealthStatus healthStatus);

    @DeleteMapping(value = "/{id}")
    void delete(@PathVariable(value = "id") String id);
}
