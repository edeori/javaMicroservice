package hu.microservice.medicare.datastore;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Eating {
	HOME_COOKED,
	TAKE_AWAY,
	ORDERING,
	FASTFOOD;

	@JsonValue
	@Override
	public String toString() {
		return StringUtils.capitalize(name().toLowerCase());
	}
	
	@JsonCreator
	public static Eating of(String value) {
		return valueOf(value.toUpperCase());
	}
}
