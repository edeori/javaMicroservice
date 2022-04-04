package hu.microservice.medicare.datastore;

public enum JobActivity {
    PHYSICAL(1),
    MENTAL(2),
    TRADE(3),
    DRIVING(4),
    RETIRED(5);

    private double value;

    private JobActivity(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
