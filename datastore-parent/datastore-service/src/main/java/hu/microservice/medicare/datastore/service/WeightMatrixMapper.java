package hu.microservice.medicare.datastore.service;

import org.springframework.stereotype.Component;

import hu.microservice.medicare.datastore.WeightMatrix;
import hu.microservice.medicare.datastore.WeightMatrixEntity;

@Component
public class WeightMatrixMapper {
    
    public WeightMatrix map(WeightMatrixEntity entity) {
        var dto = new WeightMatrix();
        dto.setId(entity.getId());
        // TODO and so on...
        return dto;
    }

}
