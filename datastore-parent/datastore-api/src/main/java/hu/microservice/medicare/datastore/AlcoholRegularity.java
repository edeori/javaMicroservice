package hu.microservice.medicare.datastore;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum AlcoholRegularity {
    @JsonProperty("Daily")
	DAILY,
	@JsonProperty("More than once a ween")
	MORE_THAN_ONCE_A_WEEK,
	@JsonProperty("Weekend")
	WEEKEND,
	@JsonProperty("Occasion")
	OCCASION,
	@JsonProperty("Never")
	NEVER;
}
