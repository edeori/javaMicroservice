package hu.microservice.medicare.datastore;

public class NeuralTransferObject {

    private WeightMatrix weightMatrix;

    private PatientData patientData;

    public NeuralTransferObject(WeightMatrix weightMatrix, PatientData patientData) {
        this.weightMatrix = weightMatrix;
        this.patientData = patientData;
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

}
