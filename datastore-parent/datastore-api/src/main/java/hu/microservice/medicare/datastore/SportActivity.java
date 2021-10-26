package hu.microservice.medicare.datastore;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum SportActivity {
	NONE,
	WALKING,
	FITNESS_OR_GYM,
	RUNNING_OR_ATHLETICS,
	SWIMMING,
	CYCLING,
	BUSHWALKING,
	FOOTBALL_OR_SOCCER,
	YOGA,
	MARTIAL_ARTS;

	@JsonValue
	@Override
	public String toString() {
		return StringUtils.capitalize(name().toLowerCase());
	}
	
	@JsonCreator
	public static SportActivity of(String value) {
		return valueOf(value.toUpperCase());
	}
}
