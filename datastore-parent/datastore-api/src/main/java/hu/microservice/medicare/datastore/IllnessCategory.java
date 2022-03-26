package hu.microservice.medicare.datastore;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum IllnessCategory {
    @JsonProperty("Blood")
	BLOOD,
	@JsonProperty("Cancer and Neoplasms")
	CANCER_AND_NEOPLASMS,
	@JsonProperty("Cardiovascular")
	CARDIOVASCULAR,
	@JsonProperty("Ear")
	EAR,
	@JsonProperty("Eye")
	EYE,
	@JsonProperty("Infection")
	INFECTION,
	@JsonProperty("Inflammatory and Immune System")
	INFLAMMATORY_AND_IMMUNE_SYSTEM,
	@JsonProperty("Injuries and Accidents")
	INJURIES_AND_ACCIDENTS,
	@JsonProperty("Mental Healt")
	MENTAL_HEALTH,
	@JsonProperty("Metabolic and Endocrine")
	METABOLIC_AND_ENDOCRINE,
	@JsonProperty("Musculoskeletal")
	MUSCULOSKELETAL,
	@JsonProperty("Neurological")
	NEUROLOGICAL,
	@JsonProperty("Oral and Gastrointestinal")
	ORAL_AND_GASTROINTESTINAL,
	@JsonProperty("Renal and Urogenital")
	RENAL_AND_UROGENITAL,
	@JsonProperty("Reproductive Health and Childbirth")
	REPRODUCTIVE_HEALTH_AND_CHILDBIRTH,
	@JsonProperty("Respiratory")
	RESPIRATORY,
	@JsonProperty("Skin")
	SKIN,
	@JsonProperty("Stroke")
	STROKE,
	@JsonProperty("Unknown")
	UNKNOWN;
}
