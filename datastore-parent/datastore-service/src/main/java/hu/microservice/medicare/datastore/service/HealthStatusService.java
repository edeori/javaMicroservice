package hu.microservice.medicare.datastore.service;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.springframework.stereotype.Service;

import hu.microservice.medicare.datastore.HealthStatus;
import hu.microservice.medicare.datastore.HealthStatusEntity;
import hu.microservice.medicare.datastore.HealthStatusRepository;
import hu.microservice.medicare.datastore.IllnessEntity;
import hu.microservice.medicare.datastore.IllnessRepository;

@Service
public class HealthStatusService {

    private final HealthStatusRepository repository;
    private final IllnessRepository illnessRepository;
    private final HealthStatusMapper mapper;

    public HealthStatusService(HealthStatusRepository repository, IllnessRepository illnessRepository,
            HealthStatusMapper mapper) {
        this.repository = repository;
        this.illnessRepository = illnessRepository;
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
        var entity = createEntity(healthStatus);
        var saved = repository.save(entity);
        return mapper.map(saved);
    }

    private HealthStatusEntity createEntity(HealthStatus healthStatus) {
        var entity = new HealthStatusEntity();
        entity.setId(UUID.randomUUID().toString());
        entity.setPatientData(healthStatus.getPatientId());
        entity.setPotentialIllnesses(getIllnesses(healthStatus.getPotentialIllnesses()));
        return entity;
    }

    private void update(HealthStatusEntity entity, HealthStatus toBeUpdated) {
        entity.setPatientData(toBeUpdated.getPatientId());
        entity.setPotentialIllnesses(getIllnesses(toBeUpdated.getPotentialIllnesses()));
    }

    private Set<IllnessEntity> getIllnesses(Set<String> illnesses) {
        var returnSet = new HashSet<IllnessEntity>();
        illnesses
                .stream()
                .forEach(illnessId -> {
                    illnessRepository.findById(illnessId).ifPresent(illness -> returnSet.add(illness));
                });

        return returnSet;
    }

}
