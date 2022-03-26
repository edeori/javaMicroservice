package hu.microservice.medicare.datastore;

public class PotentialIllness {
    private String id;
    private int percent;
    private IllnessCategory illness;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

    public IllnessCategory getIllness() {
        return illness;
    }

    public void setIllness(IllnessCategory illness) {
        this.illness = illness;
    }
}
