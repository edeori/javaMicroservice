package hu.microservice.medicare.datastore;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "healthstatus")
public class HealthStatusEntity {

    @Id
    private String id;
    private String patientId;

    @ManyToMany
    @JoinTable(name = "potential_illness",
            joinColumns = @JoinColumn(name = "health_status_id"),
            inverseJoinColumns = @JoinColumn(name = "illness_id"))
    private Set<IllnessEntity> potentialIllnesses;

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

    public Set<IllnessEntity> getPotentialIllnesses() {
        return potentialIllnesses;
    }

    public void setPotentialIllnesses(Set<IllnessEntity> potentialIllnesses) {
        this.potentialIllnesses = potentialIllnesses;
    }

}
