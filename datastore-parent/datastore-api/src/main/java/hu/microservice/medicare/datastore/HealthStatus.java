package hu.microservice.medicare.datastore;

import java.util.Set;

import javax.validation.constraints.NotNull;

public class HealthStatus {

    private String id;
    @NotNull
    private String patientId;
    private Set<String> potentialIllnesses;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientData) {
        this.patientId = patientData;
    }

    public Set<String> getPotentialIllnesses() {
        return potentialIllnesses;
    }

    public void setPotentialIllnesses(Set<String> potentialIllnesses) {
        this.potentialIllnesses = potentialIllnesses;
    }
}
