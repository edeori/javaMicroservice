package hu.microservice.medicare.neural;

import org.springframework.stereotype.Service;

import hu.microservice.medicare.datastore.HealthStatus;
import hu.microservice.medicare.datastore.NeuralTransferObject;
import hu.microservice.medicare.datastore.WeightMatrix;

@Service
public class NeuralProcessorService {

    public WeightMatrix teach(NeuralTransferObject neuralTransferObject) {
        var weightMatrix = neuralTransferObject.getWeightMatrix();
        var patientData = neuralTransferObject.getPatientData();

        var matrix = new WeightMatrix();

        return matrix;
    }

    public HealthStatus calculate(NeuralTransferObject neuralTransferObject) {
        var weightMatrix = neuralTransferObject.getWeightMatrix();
        var patientData = neuralTransferObject.getPatientData();

        var status = new HealthStatus();
        status.setPatientId(patientData.getId());

        // TODO some magic and wizardry

        return status;
    }

}
