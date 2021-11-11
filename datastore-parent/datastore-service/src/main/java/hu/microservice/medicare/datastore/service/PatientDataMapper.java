package hu.microservice.medicare.datastore.service;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import hu.microservice.medicare.datastore.IllnessEntity;
import hu.microservice.medicare.datastore.PatientData;
import hu.microservice.medicare.datastore.PatientDataEntity;
import hu.microservice.medicare.datastore.SportEntity;

@Component
public class PatientDataMapper {

	public PatientData map(PatientDataEntity entity) {
		var dto = new PatientData();
		dto.setId(entity.getId());
		dto.setActiveSportActivities(entity.getActiveSportActivities().stream().map(SportEntity::getId).collect(Collectors.toSet()));
		dto.setAlcoholRegularity(entity.getAlcoholRegularity());
		dto.setAncestorDeathCauses(entity.getAncestorDeathCauses().stream().map(IllnessEntity::getId).collect(Collectors.toSet()));
		dto.setAncestorIllnesses(
				entity.getAncestorIllnesses().stream().map(IllnessEntity::getId).collect(Collectors.toSet()));
		dto.setAverageSleepTime(entity.getAverageSleepTime());
		dto.setAverageStressLevel(entity.getAverageStressLevel());
		dto.setDateOfBirth(entity.getDateOfBirth());
		dto.setDiet(entity.getDiet());
		dto.setDoHaveGlasses(entity.isDoHaveGlasses());
		dto.setDoHaveKids(entity.isDoHaveKids());
		dto.setDoHavePet(entity.isDoHavePet());
		dto.setDoUseDrugs(entity.isDoUseDrugs());
		dto.setEating(entity.getEating());
		dto.setGender(entity.getGender());
		dto.setHeight(entity.getHeight());
		dto.setJobActivity(entity.getJobActivity());
		dto.setJobType(entity.getJobType());
		dto.setKnownIllnesses(entity.getKnownIllnesses().stream().map(IllnessEntity::getId).collect(Collectors.toSet()));
		dto.setLivingLocation(entity.getLivingLocation());
		dto.setMealsPerDay(entity.getMealsPerDay());
		dto.setOnScreenTime(entity.getOnScreenTime());
		dto.setPostSportActivities(
				entity.getPostSportActivities().stream().map(SportEntity::getId).collect(Collectors.toSet()));
		dto.setRace(entity.getRace());
		dto.setRegularEating(entity.isRegularEating());
		dto.setRelationshipStatus(entity.getRelationshipStatus());
		dto.setSmoking(entity.isSmoking());
		dto.setWakeUpTime(entity.getWakeUpTime());
		dto.setWeight(entity.getWeight());
		dto.setCreatedBy(entity.getCreatedBy());
		return dto;
	}

}
