package hu.microservice.medicare.datastore;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "potential-illnesses")
public class PotentialIllnessEntity {
    @Id
    private String id;
    private int precent;
    private IllnessCategory illness;
    
    @ManyToOne
    @JoinColumn(name = "healthStatusId", referencedColumnName = "id")
    private HealthStatusEntity healthStatus;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPrecent() {
        return precent;
    }

    public void setPrecent(int precent) {
        this.precent = precent;
    }

    public IllnessCategory getIllness() {
        return illness;
    }

    public void setIllness(IllnessCategory illness) {
        this.illness = illness;
    }
}
