package hu.microservice.medicare.datastore;

public class WeightMatrix {

    private String id;
    private double[][][] weights;
    private double eta;
    private int[] networkLayerSizes;
    private double[][] bias;
    private String lastModification;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double[][][] getWeights() {
        return weights;
    }

    public void setWeights(double[][][] weights) {
        this.weights = weights;
    }

    public double getEta() {
        return eta;
    }

    public void setEta(double eta) {
        this.eta = eta;
    }

    public int[] getNetworkLayerSizes() {
        return networkLayerSizes;
    }

    public void setNetworkLayerSizes(int[] networkLayerSizes) {
        this.networkLayerSizes = networkLayerSizes;
    }

    public double[][] getBias() {
        return bias;
    }

    public void setBias(double[][] bias) {
        this.bias = bias;
    }

    public String getLastModification() {
        return lastModification;
    }

    public void setLastModification(String lastModification) {
        this.lastModification = lastModification;
    }

}
