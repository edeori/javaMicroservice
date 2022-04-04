package hu.microservice.medicare.datastore;

public enum RelationshipStatus {
	SINGLE(1),
	IN_A_RELATIONSHIP(2),
	ENGAGED(3),
	MARRIED(4),
	SEPARATED(5),
	DIVORCED(6),
	WIDOWED(7);
    
    private double value;

    private RelationshipStatus(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
