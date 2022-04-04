package hu.microservice.medicare.datastore;

public enum AlcoholRegularity {
    DAILY(1),
    MORE_THAN_ONCE_A_WEEK(2),
    WEEKEND(3),
    OCCASION(4),
    NEVER(5);

    private double value;

    private AlcoholRegularity(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
