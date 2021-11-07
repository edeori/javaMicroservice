package hu.microservice.medicare.neural;

import org.springframework.stereotype.Service;

import hu.microservice.medicare.datastore.HealthStatus;
import hu.microservice.medicare.datastore.PatientData;
import hu.microservice.medicare.datastore.WeightMatrix;

@Service
public class NeuralProcessorService {

    public WeightMatrix teach(WeightMatrix weightMatrix, PatientData patientData) {
        var matrix = new WeightMatrix();
        
        return matrix;
    }

    public HealthStatus calculate(WeightMatrix weightMatrix, PatientData patientData) {
        var status = new HealthStatus();
        status.setPatientId(patientData.getId());
        
        // TODO some magic and wizardry
        
        return status;
    }

}
