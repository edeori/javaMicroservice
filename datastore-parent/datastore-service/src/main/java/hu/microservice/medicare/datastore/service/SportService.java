package hu.microservice.medicare.datastore.service;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import hu.microservice.medicare.datastore.Sport;
import hu.microservice.medicare.datastore.SportEntity;
import hu.microservice.medicare.datastore.SportRepository;

@Service
public class SportService {

    private final SportRepository repository;
    private final SportMapper mapper;

    public SportService(SportRepository repository, SportMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Set<Sport> getAll() {
        return repository.findAll().stream().map(mapper::map).collect(Collectors.toSet());
    }

    public Sport getById(String id) throws SportNotFound {
        return repository.findById(id).map(mapper::map).orElseThrow(SportNotFound::new);
    }

    public Sport updateById(String id, Sport sport) throws SportNotFound {
        var opt = repository.findById(id);
        if (opt.isEmpty()) {
            throw new SportNotFound();
        }
        var entity = opt.get();
        update(entity, sport);
        var saved = repository.save(entity);
        return mapper.map(saved);
    }

    public Sport create(Sport sport) {
        var entity = createEntity(sport);
        var saved = repository.save(entity);
        return mapper.map(saved);
    }

    private SportEntity createEntity(Sport sport) {
        var entity = new SportEntity();
        entity.setId(UUID.randomUUID().toString());
        entity.setName(sport.getName());
        entity.setSportActivity(sport.getSportActivity());
        return entity;
    }

    public void delete(String id) {
        repository.deleteById(id);
    }

    private void update(SportEntity entity, Sport dto) {
        entity.setName(dto.getName());
        entity.setSportActivity(dto.getSportActivity());
    }
}
