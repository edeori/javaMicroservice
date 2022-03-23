package hu.microservice.medicare.datastore;

import java.util.Set;

import javax.validation.constraints.NotNull;

public class HealthStatus {

    private String id;
    @NotNull
    private String patientId;
    private Set<PotentialIllness> potentialIllnesses;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public Set<PotentialIllness> getPotentialIllnesses() {
        return potentialIllnesses;
    }

    public void setPotentialIllnesses(Set<PotentialIllness> potentialIllnesses) {
        this.potentialIllnesses = potentialIllnesses;
    }

}
