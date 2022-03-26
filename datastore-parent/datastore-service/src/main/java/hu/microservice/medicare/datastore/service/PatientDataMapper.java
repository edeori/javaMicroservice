package hu.microservice.medicare.datastore.service;

import org.springframework.stereotype.Component;

import hu.microservice.medicare.datastore.PatientData;
import hu.microservice.medicare.datastore.PatientDataEntity;

@Component
public class PatientDataMapper {

    public PatientData map(PatientDataEntity entity) {
        var dto = new PatientData();
        dto.setId(entity.getId());
        dto.setActiveSportActivities(entity.getActiveSportActivities());
        dto.setAlcoholRegularity(entity.getAlcoholRegularity());
        dto.setAncestorDeathCauses(entity.getAncestorDeathCauses());
        dto.setAncestorIllnesses(entity.getAncestorIllnesses());
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
        dto.setKnownIllnesses(entity.getKnownIllnesses());
        dto.setLivingLocation(entity.getLivingLocation());
        dto.setMealsPerDay(entity.getMealsPerDay());
        dto.setOnScreenTime(entity.getOnScreenTime());
        dto.setPostSportActivities(entity.getPostSportActivities());
        dto.setRace(entity.getRace());
        dto.setRegularEating(entity.isRegularEating());
        dto.setRelationshipStatus(entity.getRelationshipStatus());
        dto.setDoSmoke(entity.getDoSmoke());
        dto.setWeight(entity.getWeight());
        dto.setCreatedBy(entity.getCreatedBy());
        return dto;
    }

}
