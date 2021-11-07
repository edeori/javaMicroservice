package hu.microservice.medicare.datastore.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import hu.microservice.medicare.datastore.WeightApi;
import hu.microservice.medicare.datastore.WeightMatrix;
import hu.microservice.medicare.datastore.service.MatrixNotFound;
import hu.microservice.medicare.datastore.service.WeightMatrixService;

@RestController
public class WeightMatrixApiImpl implements WeightApi {

    private final WeightMatrixService service;

    public WeightMatrixApiImpl(WeightMatrixService service) {
        this.service = service;
    }

    @Override
    public WeightMatrix getById(String id) {
        try {
            return service.getById(id);
        } catch (MatrixNotFound e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public WeightMatrix updateById(String id, WeightMatrix weightMatrix) {
        try {
            return service.updateById(id, weightMatrix);
        } catch (MatrixNotFound e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

}
