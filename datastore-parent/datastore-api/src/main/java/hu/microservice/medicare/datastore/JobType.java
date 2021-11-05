package hu.microservice.medicare.datastore;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum JobType {
	STUDENT,
	STUDENT_AND_WORKING,
	AGRICULTURE,
	ARCHITECTURE_AND_CONSTRUCTION,
	ARTS,
	BUSINESS_AND_FINANCE,
	EDUCATION_AND_TRAINING,
	GOVERNMENT_AND_PUBLIC_ADMINISTRATION,
	HEALTH,
	INFORMATION_TECHNOLOGY,
	FASHION,
	GOODS,
	SERVICE_CONTRACT,
	HOSPITALITY,
	RETIRED;
	
	@JsonValue
	@Override
	public String toString() {
		return StringUtils.capitalize(name().toLowerCase());
	}

	@JsonCreator
	public static JobType of(String value) {
		return valueOf(value.toUpperCase());
	}
}
