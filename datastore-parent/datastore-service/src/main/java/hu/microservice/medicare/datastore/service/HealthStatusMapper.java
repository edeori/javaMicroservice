package hu.microservice.medicare.datastore.service;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import hu.microservice.medicare.datastore.HealthStatus;
import hu.microservice.medicare.datastore.HealthStatusEntity;
import hu.microservice.medicare.datastore.IllnessEntity;

@Component
public class HealthStatusMapper {
    
    public HealthStatus map(HealthStatusEntity entity) {
        var dto = new HealthStatus();
        dto.setId(entity.getId());
        dto.setPatientId(entity.getPatientData());
        dto.setPotentialIllnesses(entity.getPotentialIllnesses().stream().map(IllnessEntity::getId).collect(Collectors.toSet()));
        
        return dto;
    }

}
