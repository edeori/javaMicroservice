package hu.microservice.medicare.datastore;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Diet {
    @JsonProperty("No Diet")
	NO_DIET,
	@JsonProperty("Paleo")
	PALEO,
	@JsonProperty("Carnivore")
	CARNIVORE,
	@JsonProperty("Vegan")
	VEGAN,
	@JsonProperty("Vegetarian")
	VEGETARIAN,
	@JsonProperty("Ketogenic")
	KETOGENIC,
	@JsonProperty("Mediterranean")
	MEDITERRANEAN,
	@JsonProperty("Intermittent Fasting")
	INTERMITTENT_FASTING,
	@JsonProperty("Other Fittness")
	OTHER_FITNESS;
}
