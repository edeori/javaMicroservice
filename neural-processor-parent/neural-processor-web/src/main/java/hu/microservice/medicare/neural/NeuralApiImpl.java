package hu.microservice.medicare.neural;

import org.springframework.web.bind.annotation.RestController;

import hu.microservice.medicare.datastore.HealthStatus;
import hu.microservice.medicare.datastore.PatientData;
import hu.microservice.medicare.datastore.WeightMatrix;

@RestController
public class NeuralApiImpl implements NeuralApi{
    
    private final NeuralProcessorService service;
    
    public NeuralApiImpl(NeuralProcessorService service) {
        this.service = service;
    }

    @Override
    public WeightMatrix teach(WeightMatrix weightMatrix, PatientData patientData) {
        return service.teach(weightMatrix, patientData);
    }

    @Override
    public HealthStatus calculate(WeightMatrix weightMatrix, PatientData patientData) {
        return service.calculate(weightMatrix, patientData);
    }

}
