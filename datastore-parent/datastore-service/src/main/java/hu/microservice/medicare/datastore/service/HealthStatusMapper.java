package hu.microservice.medicare.datastore.service;

import org.springframework.stereotype.Component;

import hu.microservice.medicare.datastore.HealthStatus;
import hu.microservice.medicare.datastore.HealthStatusEntity;

@Component
public class HealthStatusMapper {

    public HealthStatusEntity map(HealthStatus dto) {
        var entity = new HealthStatusEntity();
        entity.setId(dto.getId());
        entity.setPatientData(dto.getPatientId());
        entity.setPotentialIllnesses(dto.getPotentialIllnesses());
        
        return entity;
    }
    
    public HealthStatus map(HealthStatusEntity entity) {
        var dto = new HealthStatus();
        dto.setId(entity.getId());
        dto.setPatientId(entity.getPatientData());
        dto.setPotentialIllnesses(entity.getPotentialIllnesses());
        
        return dto;
    }

}
