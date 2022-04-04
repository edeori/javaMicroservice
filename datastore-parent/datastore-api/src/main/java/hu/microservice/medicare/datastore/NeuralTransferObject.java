package hu.microservice.medicare.datastore;

public class NeuralTransferObject {

    private WeightMatrix weightMatrix;

    private PatientData patientData;

    private TargetData targetData;
    
    public NeuralTransferObject(){}

    public NeuralTransferObject(WeightMatrix weightMatrix, PatientData patientData, TargetData targetData) {
        this.weightMatrix = weightMatrix;
        this.patientData = patientData;
        this.targetData = targetData;
    }

    public WeightMatrix getWeightMatrix() {
        return weightMatrix;
    }

    public void setWeightMatrix(WeightMatrix weightMatrix) {
        this.weightMatrix = weightMatrix;
    }

    public PatientData getPatientData() {
        return patientData;
    }

    public void setPatientData(PatientData patientData) {
        this.patientData = patientData;
    }

    public TargetData getTargetData() {
        return targetData;
    }

    public void setTargetData(TargetData targetData) {
        this.targetData = targetData;
    }

}
