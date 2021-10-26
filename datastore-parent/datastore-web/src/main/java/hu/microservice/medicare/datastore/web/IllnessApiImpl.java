package hu.microservice.medicare.datastore.web;

import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import hu.microservice.medicare.datastore.Illness;
import hu.microservice.medicare.datastore.IllnessApi;
import hu.microservice.medicare.datastore.service.IllnessNotFound;
import hu.microservice.medicare.datastore.service.IllnessService;

@RestController
public class IllnessApiImpl implements IllnessApi {

    private final IllnessService service;

    public IllnessApiImpl(IllnessService service) {
        this.service = service;
    }

    @Override
    public Set<Illness> getAll() {
        return service.getAll();
    }

    @Override
    public Illness getById(String id) {
        try {
            return service.getById(id);
        } catch (IllnessNotFound e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Illness updateById(String id, Illness illness) {
        try {
            return service.updateById(id, illness);
        } catch (IllnessNotFound e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Illness create(Illness illness) {
        return service.create(illness);
    }

    @Override
    public void delete(String id) {
        service.delete(id);
    }

}
