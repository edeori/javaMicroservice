package hu.microservice.medicare.datastore;

public enum Location {
	CAPITAL_CITY(1),
	CITY(2),
	COUNTRY(3),
	VILLAGE(4);
    
    private double value;

    private Location(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
