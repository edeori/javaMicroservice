package hu.microservice.medicare.datastore;

public enum SportActivity {
    NONE(1),
    WALKING(2),
    FITNESS_OR_GYM(3),
    RUNNING_OR_ATHLETICS(4),
    SWIMMING(5),
    CYCLING(6),
    BUSHWALKING(7),
    FOOTBALL_OR_SOCCER(8),
    YOGA(9),
    MARTIAL_ARTS(10),
    OTHER(11);

    private double value;

    private SportActivity(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
