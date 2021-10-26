package hu.microservice.medicare.datastore;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Location {
	CAPITAL_CITY,
	CITY,
	COUNTRY,
	VILLAGE;

	@JsonValue
	@Override
	public String toString() {
		return StringUtils.capitalize(name().toLowerCase());
	}

	@JsonCreator
	public static Location of(String value) {
		return valueOf(value.toUpperCase());
	}
}
