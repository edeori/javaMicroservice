package hu.microservice.medicare.datastore;

public enum IllnessCategory {
    BLOOD(1),
    CANCER_AND_NEOPLASMS(2),
    CARDIOVASCULAR(3),
    EAR(4),
    EYE(5),
    INFECTION(6),
    INFLAMMATORY_AND_IMMUNE_SYSTEM(7),
    INJURIES_AND_ACCIDENTS(8),
    MENTAL_HEALTH(9),
    METABOLIC_AND_ENDOCRINE(10),
    MUSCULOSKELETAL(11),
    NEUROLOGICAL(12),
    ORAL_AND_GASTROINTESTINAL(13),
    RENAL_AND_UROGENITAL(14),
    REPRODUCTIVE_HEALTH_AND_CHILDBIRTH(15),
    RESPIRATORY(16),
    SKIN(17),
    STROKE(18),
    UNKNOWN(19);

    private double value;

    private IllnessCategory(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
