package hu.microservice.medicare.datastore;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "healthstatus")
public class HealthStatusEntity {

    @Id
    private String id;
    private String patientId;
    
    @OneToMany(mappedBy = "healthStatus", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private Set<PotentialIllnessEntity> potentialIllnesses = new HashSet<>();

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

    public Set<PotentialIllnessEntity> getPotentialIllnesses() {
        return potentialIllnesses;
    }

    public void setPotentialIllnesses(Set<PotentialIllnessEntity> potentialIllnesses) {
        this.potentialIllnesses = potentialIllnesses;
    }

}
