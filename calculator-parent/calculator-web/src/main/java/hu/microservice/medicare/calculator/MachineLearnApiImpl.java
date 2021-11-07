package hu.microservice.medicare.calculator;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import hu.microservice.medicare.datastore.HealthStatus;
import hu.microservice.medicare.datastore.PatientData;
import hu.microservice.medicare.datastore.WeightMatrix;

@RestController
public class MachineLearnApiImpl implements MachineLearnApi {

    private final MachineLearnService service;

    public MachineLearnApiImpl(MachineLearnService service) {
        this.service = service;
    }

    @Override
    public WeightMatrix neuralTeach(PatientData data) {
        try {
            return service.neuralTeach(data);
        } catch (WeightNotFound e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public HealthStatus processHealthStatus(String id) {
        return service.processHealthStatus(id);
    }

}
