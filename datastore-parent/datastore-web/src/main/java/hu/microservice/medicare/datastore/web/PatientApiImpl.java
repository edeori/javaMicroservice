package hu.microservice.medicare.datastore.web;

import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import hu.microservice.medicare.datastore.PatientApi;
import hu.microservice.medicare.datastore.PatientData;
import hu.microservice.medicare.datastore.service.PatientDataNotFound;
import hu.microservice.medicare.datastore.service.PatientService;

@RestController
public class PatientApiImpl implements PatientApi {

    private final PatientService service;

    public PatientApiImpl(PatientService service) {
        this.service = service;
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
    public PatientData updateById(String id, PatientData patientData) {
        try {
            return service.updateById(id, patientData);
        } catch (PatientDataNotFound e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public PatientData create(PatientData patientData) {
        return service.create(patientData);
    }

    @Override
    public void delete(String id) {
        service.delete(id);
    }

}
