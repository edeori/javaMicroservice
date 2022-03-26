package hu.microservice.medicare.datastore.web;

import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import hu.microservice.medicare.datastore.PatientApi;
import hu.microservice.medicare.datastore.PatientData;
import hu.microservice.medicare.datastore.service.PatientDataNotFound;
import hu.microservice.medicare.datastore.service.PatientService;
import hu.microservice.medicare.user.UserApi;

@RestController
public class PatientApiImpl implements PatientApi {

    private final PatientService service;
    private final UserApi userApi;

    public PatientApiImpl(PatientService service, UserApi userApi) {
        this.service = service;
        this.userApi = userApi;
    }

    @Override
    public Set<PatientData> getAll() {
        return service.getAll();
    }

    @Override
    public PatientData getById(String id) {
        try {
            return service.getById(id);
        } catch (PatientDataNotFound e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public PatientData getByUser() {
        var patientId = userApi.getUser().getId();
        try {
            return service.getByUser(patientId);
        } catch (PatientDataNotFound e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public PatientData createOrUpdate(PatientData patientData) {
        var patientId = userApi.getUser().getId();
        return service.createOrUpdate(patientId, patientData);
    }

    @Override
    public void delete(String id) {
        service.delete(id);
    }

}
