package hu.microservice.medicare.datastore;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum RelationshipStatus {
    @JsonProperty("Single")
	SINGLE,
	@JsonProperty("In a relationship")
	IN_A_RELATIONSHIP,
	@JsonProperty("Engaged")
	ENGAGED,
	@JsonProperty("Married")
	MARRIED,
	@JsonProperty("Separated")
	SEPARATED,
	@JsonProperty("Divorced")
	DIVORCED,
	@JsonProperty("Widowed")
	WIDOWED;
}
