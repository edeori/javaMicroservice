package hu.microservice.medicare.datastore;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Diet {
	NO_DIET,
	PALEO,
	CARNIVORE,
	VEGAN,
	VEGETARIAN,
	KETOGENIC,
	MEDITERRANEAN,
	INTERMITTENT_FASTING,
	OTHER_FITNESS;

	@JsonValue
	@Override
	public String toString() {
		return StringUtils.capitalize(name().toLowerCase());
	}
	
	@JsonCreator
	public static Diet of(String value) {
		return valueOf(value.toUpperCase());
	}
}
