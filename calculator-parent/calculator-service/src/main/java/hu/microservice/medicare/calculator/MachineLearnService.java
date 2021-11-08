package hu.microservice.medicare.calculator;

import org.springframework.stereotype.Service;

import hu.microservice.medicare.datastore.HealthStatus;
import hu.microservice.medicare.datastore.HealthStatusApi;
import hu.microservice.medicare.datastore.NeuralTransferObject;
import hu.microservice.medicare.datastore.PatientApi;
import hu.microservice.medicare.datastore.PatientData;
import hu.microservice.medicare.datastore.WeightApi;
import hu.microservice.medicare.datastore.WeightMatrix;
import hu.microservice.medicare.neural.NeuralApi;

@Service
public class MachineLearnService {

    private final String WEIGHT_ID = "";

    private final PatientApi patientApi;
    private final WeightApi weightApi;
    private final NeuralApi neuralApi;
    private final HealthStatusApi healthStatusApi;

    public MachineLearnService(PatientApi patientApi, WeightApi weightApi, NeuralApi neuralApi,
            HealthStatusApi healthStatusApi) {
        this.patientApi = patientApi;
        this.weightApi = weightApi;
        this.neuralApi = neuralApi;
        this.healthStatusApi = healthStatusApi;
    }

    public WeightMatrix neuralTeach(PatientData data) throws WeightNotFound {
        var weight = weightApi.getById(WEIGHT_ID);
        if (weight == null) {
            throw new WeightNotFound();
        }
        var response = neuralApi.teach(new NeuralTransferObject(weight, data));
        return response;
    }

    public HealthStatus processHealthStatus(String id) {
        var patientData = patientApi.getById(id);
        var weightMatrix = weightApi.getById(WEIGHT_ID);

        var healthStatus = neuralApi.calculate(new NeuralTransferObject(weightMatrix, patientData));

        var saved = healthStatusApi.createOrUpdate(id, healthStatus);

        return saved;
    }

}
