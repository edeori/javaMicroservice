package hu.microservice.medicare.datastore;

public enum Race {
	CAUCASIAN(1),
	ASIAN(2),
	BLACK(3),
	GYPSY(4),
	MIXED(5);
    
    private double value;

    private Race(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
