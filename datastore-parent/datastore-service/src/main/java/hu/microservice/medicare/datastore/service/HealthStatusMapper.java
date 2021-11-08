package hu.microservice.medicare.datastore.service;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import hu.microservice.medicare.datastore.HealthStatus;
import hu.microservice.medicare.datastore.HealthStatusEntity;
import hu.microservice.medicare.datastore.Illness;
import hu.microservice.medicare.datastore.IllnessEntity;

@Component
public class HealthStatusMapper {

    public HealthStatusEntity map(HealthStatus dto) {
        var entity = new HealthStatusEntity();
        entity.setId(dto.getId());
        entity.setPatientData(dto.getPatientId());
        entity.setPotentialIllnesses(dto.getPotentialIllnesses().stream().map(this::map).collect(Collectors.toSet()));
        
        return entity;
    }
    
    public HealthStatus map(HealthStatusEntity entity) {
        var dto = new HealthStatus();
        dto.setId(entity.getId());
        dto.setPatientId(entity.getPatientData());
        dto.setPotentialIllnesses(entity.getPotentialIllnesses().stream().map(this::map).collect(Collectors.toSet()));
        
        return dto;
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
