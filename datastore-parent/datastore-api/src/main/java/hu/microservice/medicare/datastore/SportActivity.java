package hu.microservice.medicare.datastore;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum SportActivity {
    @JsonProperty("None")
	NONE,
	@JsonProperty("Walking")
	WALKING,
	@JsonProperty("Fitness or Gym")
	FITNESS_OR_GYM,
	@JsonProperty("Running or Athletics")
	RUNNING_OR_ATHLETICS,
	@JsonProperty("Swimming")
	SWIMMING,
	@JsonProperty("Cycling")
	CYCLING,
	@JsonProperty("Bushwalking")
	BUSHWALKING,
	@JsonProperty("Football or Soccer")
	FOOTBALL_OR_SOCCER,
	@JsonProperty("Yoga")
	YOGA,
	@JsonProperty("Martial Arts")
	MARTIAL_ARTS,
	@JsonProperty("Other")
	OTHER;
}
