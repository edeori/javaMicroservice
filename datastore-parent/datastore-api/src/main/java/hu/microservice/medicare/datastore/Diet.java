package hu.microservice.medicare.datastore;

public enum Diet {
    NO_DIET(1),
    PALEO(2),
    CARNIVORE(3),
    VEGAN(4),
    VEGETARIAN(5),
    KETOGENIC(6),
    MEDITERRANEAN(7),
    INTERMITTENT_FASTING(8),
    OTHER_FITNESS(9);

    private double value;

    private Diet(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
