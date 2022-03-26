package hu.microservice.medicare.datastore;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum JobType {
    @JsonProperty("Student")
	STUDENT,
	@JsonProperty("Student and Working")
	STUDENT_AND_WORKING,
	@JsonProperty("Agriculture")
	AGRICULTURE,
	@JsonProperty("Architecture and Construction")
	ARCHITECTURE_AND_CONSTRUCTION,
	@JsonProperty("Arts")
	ARTS,
	@JsonProperty("Business and Finance")
	BUSINESS_AND_FINANCE,
	@JsonProperty("Education and Training")
	EDUCATION_AND_TRAINING,
	@JsonProperty("Government and Public Administration")
	GOVERNMENT_AND_PUBLIC_ADMINISTRATION,
	@JsonProperty("Health")
	HEALTH,
	@JsonProperty("Information Technology")
	INFORMATION_TECHNOLOGY,
	@JsonProperty("Fashion")
	FASHION,
	@JsonProperty("Goods")
	GOODS,
	@JsonProperty("Service Contract")
	SERVICE_CONTRACT,
	@JsonProperty("Hospitality")
	HOSPITALITY,
	@JsonProperty("Retired")
	RETIRED;
}
