package hu.microservice.medicare.datastore;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum IllnessCategory {
	BLOOD,
	CANCER_AND_NEOPLASMS,
	CARDIOVASCULAR,
	CONGENITAL_DISORDERS,
	EAR,
	EYE,
	INFECTION,
	INFLAMMATORY_AND_IMMUNE_SYSTEM,
	INJURIES_AND_ACCIDENTS,
	MENTAL_HEALTH,
	METABOLIC_AND_ENDOCRINE,
	MUSCULOSKELETAL,
	NEUROLOGICAL,
	ORAL_AND_GASTROINTESTINAL,
	RENAL_AND_UROGENITAL,
	REPRODUCTIVE_HEALTH_AND_CHILDBIRTH,
	RESPIRATORY,
	SKIN,
	STROKE,
	GENERIC_HEALTH_RELEVANCE,
	DISPUTED_AETIOLOGY_AND_OTHER;

	@JsonValue
	@Override
	public String toString() {
		return StringUtils.capitalize(name().toLowerCase());
	}
	
	@JsonCreator
	public static IllnessCategory of(String value) {
		return valueOf(value.toUpperCase());
	}
}
