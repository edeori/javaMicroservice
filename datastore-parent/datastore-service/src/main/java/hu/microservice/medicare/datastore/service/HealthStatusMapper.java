package hu.microservice.medicare.datastore.service;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import hu.microservice.medicare.datastore.HealthStatus;
import hu.microservice.medicare.datastore.HealthStatusEntity;
import hu.microservice.medicare.datastore.PotentialIllness;
import hu.microservice.medicare.datastore.PotentialIllnessEntity;

@Component
public class HealthStatusMapper {

    public HealthStatus map(HealthStatusEntity entity) {
        var dto = new HealthStatus();
        dto.setId(entity.getId());
        dto.setPatientId(entity.getPatientId());
        dto.setPotentialIllnesses(entity.getPotentialIllnesses().stream().map(this::map).collect(Collectors.toSet()));

        return dto;
    }

    public PotentialIllness map(PotentialIllnessEntity entity) {
        var dto = new PotentialIllness();
        dto.setId(entity.getId());
        dto.setIllness(entity.getIllness());
        dto.setPrecent(entity.getPrecent());
        return dto;
    }
    
    public PotentialIllnessEntity map(PotentialIllness dto) {
        var entity = new PotentialIllnessEntity();
        entity.setId(entity.getId());
        entity.setIllness(entity.getIllness());
        entity.setPrecent(entity.getPrecent());
        return entity;
    }

}
