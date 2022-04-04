package hu.microservice.medicare.datastore.service;

import org.springframework.stereotype.Component;

import hu.microservice.medicare.datastore.WeightMatrix;
import hu.microservice.medicare.datastore.WeightMatrixEntity;

@Component
public class WeightMatrixMapper {
    
    public WeightMatrix map(WeightMatrixEntity entity) {
        var dto = new WeightMatrix();
        dto.setId(entity.getId());
        dto.setEta(entity.getEta());
        dto.setBias(entity.getBias());
        dto.setNetworkLayerSizes(entity.getNetworkLayerSizes());
        dto.setWeights(entity.getWeights());
        dto.setLastModification(entity.getLastModification());
        return dto;
    }

}
