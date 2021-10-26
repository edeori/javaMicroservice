package hu.microservice.medicare.datastore.service;

import org.springframework.stereotype.Component;

import hu.microservice.medicare.datastore.Illness;
import hu.microservice.medicare.datastore.IllnessEntity;

@Component
public class IllnessMapper {

	public IllnessEntity map(Illness dto) {
		var entity = new IllnessEntity();
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		entity.setCategory(dto.getCategory());
		entity.setDeathRate(dto.getDeathRate());
		return entity;
	}

	public Illness map(IllnessEntity entity) {
		var dto = new Illness();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setCategory(entity.getCategory());
		dto.setDeathRate(entity.getDeathRate());
		return dto;
	}

}
