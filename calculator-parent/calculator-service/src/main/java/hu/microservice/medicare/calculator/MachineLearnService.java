package hu.microservice.medicare.calculator;

import org.springframework.stereotype.Service;

import hu.microservice.medicare.datastore.HealthStatus;
import hu.microservice.medicare.datastore.HealthStatusApi;
import hu.microservice.medicare.datastore.NeuralTransferObject;
import hu.microservice.medicare.datastore.PatientApi;
import hu.microservice.medicare.datastore.PatientData;
import hu.microservice.medicare.datastore.TargetData;
import hu.microservice.medicare.datastore.WeightApi;
import hu.microservice.medicare.datastore.WeightMatrix;
import hu.microservice.medicare.neural.NeuralApi;

@Service
public class MachineLearnService {

    private final CalculatorConfigurationProperties config;
    private final PatientApi patientApi;
    private final WeightApi weightApi;
    private final NeuralApi neuralApi;
    private final HealthStatusApi healthStatusApi;

    public MachineLearnService(CalculatorConfigurationProperties config, PatientApi patientApi, WeightApi weightApi,
            NeuralApi neuralApi,
            HealthStatusApi healthStatusApi) {
        this.config = config;
        this.patientApi = patientApi;
        this.weightApi = weightApi;
        this.neuralApi = neuralApi;
        this.healthStatusApi = healthStatusApi;
    }

    public void initNeuralSystem() {
        var initValues = neuralApi.initWeightsAndBias();
        weightApi.create(initValues.getWeightMatrix());
    }

    public WeightMatrix neuralTeachByPatientData(PatientData patientData) throws WeightNotFound {
        var weight = weightApi.getById(config.getMatrixId());
        if (weight == null) {
            throw new WeightNotFound();
        }
        
        var neuralTransferObject = new NeuralTransferObject();
        neuralTransferObject.setPatientData(patientData);
        neuralTransferObject.setWeightMatrix(weight);
        var response = neuralApi.innerTeach(neuralTransferObject);

        var res = weightApi.updateById(config.getMatrixId(), response);
        return res;
    }

    public void neuralTeach(NeuralTransferObject neuralTransferObject) throws WeightNotFound {
        System.out.println(config.getMatrixId());
        var weight = weightApi.getById(config.getMatrixId());
        if (weight == null) {
            throw new WeightNotFound();
        }

        neuralTransferObject.setWeightMatrix(weight);
        var response = neuralApi.innerTeach(neuralTransferObject);

        weightApi.updateById(config.getMatrixId(), response);
    }
    
    public HealthStatus processHealthStatus(String id) {
        var patientData = patientApi.getById(id);
        var weightMatrix = weightApi.getById(config.getMatrixId());

        var healthStatus = neuralApi.calculate(new NeuralTransferObject(weightMatrix, patientData, new TargetData()));

        var saved = healthStatusApi.createOrUpdate(healthStatus);

        return saved;
    }

}
