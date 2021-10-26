package hu.microservice.medicare.datastore.web;

import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import hu.microservice.medicare.datastore.Sport;
import hu.microservice.medicare.datastore.SportApi;
import hu.microservice.medicare.datastore.service.SportNotFound;
import hu.microservice.medicare.datastore.service.SportService;

@RestController
public class SportApiImpl implements SportApi {
	
	private final SportService service;
	
	public SportApiImpl(SportService service) {
		this.service = service;
	}

	@Override
	public Set<Sport> getAll() {
		return service.getAll();
	}

	@Override
	public Sport getById(String id) {
		try {
			return service.getById(id);
		} catch (SportNotFound e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public Sport updateById(String id, Sport sport) {
		try {
			return service.updateById(id, sport);
		} catch (SportNotFound e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public Sport create(Sport sport) {
		return service.create(sport);
	}

	@Override
	public void delete(String id) {
		service.delete(id);
	}

}
