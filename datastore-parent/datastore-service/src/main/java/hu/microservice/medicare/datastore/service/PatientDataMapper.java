package hu.microservice.medicare.datastore.service;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import hu.microservice.medicare.datastore.Illness;
import hu.microservice.medicare.datastore.IllnessEntity;
import hu.microservice.medicare.datastore.PatientData;
import hu.microservice.medicare.datastore.PatientDataEntity;
import hu.microservice.medicare.datastore.Sport;
import hu.microservice.medicare.datastore.SportEntity;

@Component
public class PatientDataMapper {

	public PatientData map(PatientDataEntity entity) {
		var dto = new PatientData();
		dto.setActiveSportActivities(entity.getActiveSportActivities().stream().map(this::map).collect(Collectors.toSet()));
		dto.setAlcoholRegularity(entity.getAlcoholRegularity());
		dto.setAncestorDeathCauses(entity.getAncestorDeathCauses().stream().map(this::map).collect(Collectors.toSet()));
		dto.setAncestorIllnesses(
				entity.getAncestorIllnesses().stream().map(this::map).collect(Collectors.toSet()));
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
		dto.setKnownIllnesses(entity.getKnownIllnesses().stream().map(this::map).collect(Collectors.toSet()));
		dto.setLivingLocation(entity.getLivingLocation());
		dto.setMealsPerDay(entity.getMealsPerDay());
		dto.setOnScreenTime(entity.getOnScreenTime());
		dto.setPostSportActivities(
				entity.getPostSportActivities().stream().map(this::map).collect(Collectors.toSet()));
		dto.setRace(entity.getRace());
		dto.setRegularEating(entity.isRegularEating());
		dto.setRelationshipStatus(entity.getRelationshipStatus());
		dto.setSmoking(entity.isSmoking());
		dto.setWakeUpTime(entity.getWakeUpTime());
		dto.setWeight(entity.getWeight());
		return dto;
	}
	
	public PatientDataEntity map(PatientData dto) {
		var entity = new PatientDataEntity();
		entity.setActiveSportActivities(dto.getActiveSportActivities().stream().map(this::map).collect(Collectors.toSet()));
		entity.setAlcoholRegularity(dto.getAlcoholRegularity());
		entity.setAncestorDeathCauses(dto.getAncestorDeathCauses().stream().map(this::map).collect(Collectors.toSet()));
		entity.setAncestorIllnesses(
				dto.getAncestorIllnesses().stream().map(this::map).collect(Collectors.toSet()));
		entity.setAverageSleepTime(dto.getAverageSleepTime());
		entity.setAverageStressLevel(dto.getAverageStressLevel());
		entity.setDateOfBirth(dto.getDateOfBirth());
		entity.setDiet(dto.getDiet());
		entity.setDoHaveGlasses(dto.isDoHaveGlasses());
		entity.setDoHaveKids(dto.isDoHaveKids());
		entity.setDoHavePet(dto.isDoHavePet());
		entity.setDoUseDrugs(dto.isDoUseDrugs());
		entity.setEating(dto.getEating());
		entity.setGender(dto.getGender());
		entity.setHeight(dto.getHeight());
		entity.setJobActivity(dto.getJobActivity());
		entity.setJobType(dto.getJobType());
		entity.setKnownIllnesses(dto.getKnownIllnesses().stream().map(this::map).collect(Collectors.toSet()));
		entity.setLivingLocation(dto.getLivingLocation());
		entity.setMealsPerDay(dto.getMealsPerDay());
		entity.setOnScreenTime(dto.getOnScreenTime());
		entity.setPostSportActivities(
				dto.getPostSportActivities().stream().map(this::map).collect(Collectors.toSet()));
		entity.setRace(dto.getRace());
		entity.setRegularEating(dto.isRegularEating());
		entity.setRelationshipStatus(dto.getRelationshipStatus());
		entity.setSmoking(dto.isSmoking());
		entity.setWakeUpTime(dto.getWakeUpTime());
		entity.setWeight(dto.getWeight());
		return entity;
	}
	
	private Sport map(SportEntity entity) {
		var dto = new Sport();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setSportActivity(entity.getSportActivity());
		return dto;
	}
	
	private SportEntity map(Sport dto) {
		var entity = new SportEntity();
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		entity.setSportActivity(dto.getSportActivity());
		return entity;
	}
	
	private Illness map(IllnessEntity entity) {
		var dto = new Illness();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setCategory(entity.getCategory());
		dto.setDeathRate(entity.getDeathRate());
		return dto;
	}
	
	private IllnessEntity map(Illness dto) {
		var entity = new IllnessEntity();
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		entity.setCategory(dto.getCategory());
		entity.setDeathRate(dto.getDeathRate());
		return entity;
	}

}
