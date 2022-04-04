package hu.microservice.medicare.datastore;

public class TargetData {

    private String id;
    private IllnessCategory deathCause;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public IllnessCategory getDeathCause() {
        return deathCause;
    }

    public void setDeathCause(IllnessCategory deathCause) {
        this.deathCause = deathCause;
    }

}
