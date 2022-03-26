package hu.microservice.medicare.datastore;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Eating {
    @JsonProperty("Home Cooked")
	HOME_COOKED,
	@JsonProperty("Ordering")
	ORDERING,
	@JsonProperty("Fastfood")
	FASTFOOD;
}
