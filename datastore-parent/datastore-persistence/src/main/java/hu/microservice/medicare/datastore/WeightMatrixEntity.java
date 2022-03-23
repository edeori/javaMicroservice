package hu.microservice.medicare.datastore;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "weights")
public class WeightMatrixEntity {

    @Id
    private String id;
    
    // From
    private String i;
    
    // To
    private String j;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
}
