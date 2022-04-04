package hu.microservice.medicare.datastore;

public enum Gender {
	MALE(1),
	FEMALE(2),
	OTHER(3);
    
    private double value;
    
    private Gender(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
