package hu.microservice.medicare.datastore;

public enum Eating {
    HOME_COOKED(1),
    ORDERING(2),
    FASTFOOD(3);

    private double value;

    private Eating(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
