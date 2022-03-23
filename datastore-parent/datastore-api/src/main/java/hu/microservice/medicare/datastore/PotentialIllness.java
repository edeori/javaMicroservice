package hu.microservice.medicare.datastore;

public class PotentialIllness {
    private String id;
    private int precent;
    private IllnessCategory illness;

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
