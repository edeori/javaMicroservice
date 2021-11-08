package hu.microservice.medicare.neural;

import org.springframework.web.bind.annotation.RestController;

import hu.microservice.medicare.datastore.HealthStatus;
import hu.microservice.medicare.datastore.NeuralTransferObject;
import hu.microservice.medicare.datastore.WeightMatrix;

@RestController
public class NeuralApiImpl implements NeuralApi {

    private final NeuralProcessorService service;

    public NeuralApiImpl(NeuralProcessorService service) {
        this.service = service;
    }

    @Override
    public WeightMatrix teach(NeuralTransferObject neuralTransferObject) {
        return service.teach(neuralTransferObject);
    }

    @Override
    public HealthStatus calculate(NeuralTransferObject neuralTransferObject) {
        return service.calculate(neuralTransferObject);
    }

}
