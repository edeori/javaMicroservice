package hu.microservice.medicare.datastore.service;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import hu.microservice.medicare.datastore.Illness;
import hu.microservice.medicare.datastore.IllnessEntity;
import hu.microservice.medicare.datastore.IllnessRepository;

@Service
public class IllnessService {

    private final IllnessRepository repository;
    private final IllnessMapper mapper;

    public IllnessService(IllnessRepository repository, IllnessMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Set<Illness> getAll() {
        return repository.findAll().stream().map(mapper::map).collect(Collectors.toSet());
    }

    public Illness getById(String id) throws IllnessNotFound {
        return repository.findById(id).map(mapper::map).orElseThrow(IllnessNotFound::new);
    }

    public Illness updateById(String id, Illness illness) throws IllnessNotFound {
        var opt = repository.findById(id);
        if (opt.isEmpty()) {
            throw new IllnessNotFound();
        }
        var entity = opt.get();
        update(entity, illness);
        var saved = repository.save(entity);
        return mapper.map(saved);
    }

    public Illness create(Illness illness) {
        var entity = createEntity(illness);
        var saved = repository.save(entity);
        return mapper.map(saved);
    }

    private IllnessEntity createEntity(Illness illness) {
        var entity = new IllnessEntity();
        entity.setId(UUID.randomUUID().toString());
        entity.setName(illness.getName());
        entity.setCategory(illness.getCategory());
        entity.setDeathRate(illness.getDeathRate());

        return entity;
    }

    public void delete(String id) {
        repository.deleteById(id);
    }

    private void update(IllnessEntity entity, Illness toBeUpdated) {
        entity.setName(toBeUpdated.getName());
        entity.setDeathRate(toBeUpdated.getDeathRate());
        entity.setCategory(toBeUpdated.getCategory());
    }
}
