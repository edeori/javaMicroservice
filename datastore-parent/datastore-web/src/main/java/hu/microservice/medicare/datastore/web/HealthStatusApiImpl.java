package hu.microservice.medicare.datastore.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import hu.microservice.medicare.datastore.HealthStatus;
import hu.microservice.medicare.datastore.HealthStatusApi;
import hu.microservice.medicare.datastore.service.HealthStatusService;
import hu.microservice.medicare.datastore.service.PatientDataNotFound;
import hu.microservice.medicare.user.UserApi;

@RestController
public class HealthStatusApiImpl implements HealthStatusApi {

    private final HealthStatusService service;
    private final UserApi userApi;

    public HealthStatusApiImpl(HealthStatusService service, UserApi userApi) {
        this.service = service;
        this.userApi = userApi;
    }

    @Override
    public HealthStatus getByUser() {
        try {
            var patientId = userApi.getUser().getId();
            return service.getByUserId(patientId);
        } catch (PatientDataNotFound e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public HealthStatus createOrUpdate(HealthStatus newHealthStatus) {
        var patientId = userApi.getUser().getId();
        return service.createOrUpdate(patientId, newHealthStatus);
    }

    @Override
    public void delete(String id) {
        service.delete(id);
    }

}
