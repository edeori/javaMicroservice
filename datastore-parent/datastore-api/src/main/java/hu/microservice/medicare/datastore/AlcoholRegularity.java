package hu.microservice.medicare.datastore;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum AlcoholRegularity {
	DAILY,
	MORE_THAN_ONCE_A_WEEK,
	WEEKEND,
	OCCASION,
	NEVER;

	@JsonValue
	@Override
	public String toString() {
		return StringUtils.capitalize(name().toLowerCase());
	}
	
	@JsonCreator
	public static AlcoholRegularity of(String value) {
		return valueOf(value.toUpperCase());
	}
}
