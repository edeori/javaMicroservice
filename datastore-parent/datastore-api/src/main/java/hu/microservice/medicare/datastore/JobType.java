package hu.microservice.medicare.datastore;

public enum JobType {
    STUDENT(1),
    STUDENT_AND_WORKING(2),
    AGRICULTURE(3),
    ARCHITECTURE_AND_CONSTRUCTION(4),
    ARTS(5),
    BUSINESS_AND_FINANCE(6),
    EDUCATION_AND_TRAINING(7),
    GOVERNMENT_AND_PUBLIC_ADMINISTRATION(8),
    HEALTH(9),
    INFORMATION_TECHNOLOGY(10),
    FASHION(11),
    GOODS(12),
    SERVICE_CONTRACT(13),
    HOSPITALITY(14),
    RETIRED(15);

    private double value;

    private JobType(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
