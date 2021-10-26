package hu.microservice.medicare.datastore.service;

import org.springframework.stereotype.Component;

import hu.microservice.medicare.datastore.Sport;
import hu.microservice.medicare.datastore.SportEntity;

@Component
public class SportMapper {

	public SportEntity map(Sport dto) {
		var entity = new SportEntity();
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		entity.setSportActivity(dto.getSportActivity());
		return entity;
	}

	public Sport map(SportEntity entity) {
		var dto = new Sport();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setSportActivity(entity.getSportActivity());
		return dto;
	}
}
