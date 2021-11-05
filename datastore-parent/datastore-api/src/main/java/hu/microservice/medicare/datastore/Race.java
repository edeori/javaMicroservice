package hu.microservice.medicare.datastore;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Race {
	CAUCASIAN,
	ASIAN,
	BLACK,
	AUSTRALOID,
	GYPSY,
	MIXED;

	@JsonValue
	@Override
	public String toString() {
		return StringUtils.capitalize(name().toLowerCase());
	}
	
	@JsonCreator
	public static Race of(String value) {
		return valueOf(value.toUpperCase());
	}
}
