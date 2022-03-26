package hu.microservice.medicare.datastore;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Location {
    @JsonProperty("Capital City")
	CAPITAL_CITY,
	@JsonProperty("City")
	CITY,
	@JsonProperty("Country")
	COUNTRY,
	@JsonProperty("Village")
	VILLAGE;
}
