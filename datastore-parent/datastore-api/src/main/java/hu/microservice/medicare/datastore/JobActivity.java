package hu.microservice.medicare.datastore;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum JobActivity {
    @JsonProperty("Physical")
	PHYSICAL,
	@JsonProperty("Mental")
	MENTAL,
	@JsonProperty("Trade")
	TRADE,
	@JsonProperty("Driving")
	DRIVING,
	@JsonProperty("Retired")
	RETIRED;
}
