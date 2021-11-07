package hu.microservice.medicare.datastore.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import hu.microservice.medicare.datastore.HealthStatus;
import hu.microservice.medicare.datastore.HealthStatusApi;
import hu.microservice.medicare.datastore.service.HealthStatusService;
import hu.microservice.medicare.datastore.service.PatientDataNotFound;

@RestController
public class HealthStatusApiImpl implements HealthStatusApi {

    private final HealthStatusService service;

    public HealthStatusApiImpl(HealthStatusService service) {
        this.service = service;
    }

    @Override
    public HealthStatus getByUserId(String id) {
        try {
            return service.getByUserId(id);
        } catch (PatientDataNotFound e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void delete(String id) {
        service.delete(id);
    }

    @Override
    public HealthStatus createOrUpdate(String patientId, HealthStatus newHealthStatus) {
        return service.createOrUpdate(patientId, newHealthStatus);
    }

}
