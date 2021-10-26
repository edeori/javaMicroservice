package hu.microservice.medicare.datastore;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum RelationshipStatus {
	SINGLE,
	IN_A_RELATIONSHIP,
	ENGAGED,
	MARRIED,
	SEPARATED,
	DIVORCED,
	WIDOWED;

	@JsonValue
	@Override
	public String toString() {
		return StringUtils.capitalize(name().toLowerCase());
	}

	@JsonCreator
	public static RelationshipStatus of(String value) {
		return valueOf(value.toUpperCase());
	}
}
