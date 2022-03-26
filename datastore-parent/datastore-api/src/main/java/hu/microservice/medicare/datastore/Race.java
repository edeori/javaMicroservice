package hu.microservice.medicare.datastore;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Race {
    @JsonProperty("Caucasian")
	CAUCASIAN,
	@JsonProperty("Asian")
	ASIAN,
	@JsonProperty("Black")
	BLACK,
	@JsonProperty("Gypsy")
	GYPSY,
	@JsonProperty("Mixed")
	MIXED;
}
