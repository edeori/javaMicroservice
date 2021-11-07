package hu.microservice.medicare.datastore;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "healthstatus")
public class HealthStatusEntity {

    @Id
    private String id;
    private String patientId;
    private Set<String> potentialIllnesses;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPatientData() {
        return patientId;
    }

    public void setPatientData(String patientData) {
        this.patientId = patientData;
    }

    public Set<String> getPotentialIllnesses() {
        return potentialIllnesses;
    }

    public void setPotentialIllnesses(Set<String> potentialIllnesses) {
        this.potentialIllnesses = potentialIllnesses;
    }

}
