package hu.microservice.medicare.datastore.service;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.springframework.stereotype.Service;

import hu.microservice.medicare.datastore.HealthStatus;
import hu.microservice.medicare.datastore.HealthStatusEntity;
import hu.microservice.medicare.datastore.HealthStatusRepository;
import hu.microservice.medicare.datastore.PotentialIllness;
import hu.microservice.medicare.datastore.PotentialIllnessEntity;

@Service
public class HealthStatusService {
    private final HealthStatusRepository repository;
    private final HealthStatusMapper mapper;

    public HealthStatusService(HealthStatusRepository repository,
            HealthStatusMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public HealthStatus getByUserId(String patientId) throws PatientDataNotFound {
        return repository.findByPatientId(patientId).map(mapper::map).orElseThrow(PatientDataNotFound::new);
    }

    public HealthStatus createOrUpdate(String patientId, HealthStatus healthStatus) {
        var opt = repository.findByPatientId(patientId);
        if (opt.isEmpty()) {
            return create(patientId, healthStatus);
        }
        var entity = opt.get();
        update(entity, healthStatus);
        var saved = repository.save(entity);
        return mapper.map(saved);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }

    private HealthStatus create(String patientId, HealthStatus healthStatus) {
        var entity = createEntity(patientId, healthStatus);
        var saved = repository.save(entity);
        return mapper.map(saved);
    }

    private HealthStatusEntity createEntity(String patientId, HealthStatus healthStatus) {
        var entity = new HealthStatusEntity();
        entity.setId(UUID.randomUUID().toString());
        entity.setPatientId(patientId);
        setPotentialIllnesses(entity, healthStatus.getPotentialIllnesses());
        return entity;
    }

    private void setPotentialIllnesses(HealthStatusEntity entity, Set<PotentialIllness> potentialIllnesses) {
        for (var illness : potentialIllnesses) {
            var newIllness = createPotentialIllnessEntity(illness, entity);

            entity.getPotentialIllnesses().add(newIllness);
        }
    }
    
    private void update(HealthStatusEntity entity, HealthStatus healthStatus) {
        entity.setPotentialIllnesses(new HashSet<PotentialIllnessEntity>());
        setPotentialIllnesses(entity, healthStatus.getPotentialIllnesses());
    }

    private PotentialIllnessEntity createPotentialIllnessEntity(PotentialIllness dto, HealthStatusEntity healthStatus) {
        var entity = new PotentialIllnessEntity();
        entity.setId(UUID.randomUUID().toString());
        entity.setIllness(dto.getIllness());
        entity.setPercent(dto.getPercent());
        entity.setHealthStatus(healthStatus);
        return entity;
    }

}
