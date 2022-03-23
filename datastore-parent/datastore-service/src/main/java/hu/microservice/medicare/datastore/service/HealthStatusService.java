package hu.microservice.medicare.datastore.service;

import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import hu.microservice.medicare.datastore.HealthStatus;
import hu.microservice.medicare.datastore.HealthStatusEntity;
import hu.microservice.medicare.datastore.HealthStatusRepository;

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
        var entity = createEntity(healthStatus);
        var saved = repository.save(entity);
        return mapper.map(saved);
    }

    private HealthStatusEntity createEntity(HealthStatus healthStatus) {
        var entity = new HealthStatusEntity();
        entity.setId(UUID.randomUUID().toString());
        entity.setPatientId(healthStatus.getPatientId());
        entity.setPotentialIllnesses(
                healthStatus.getPotentialIllnesses().stream().map(mapper::map).collect(Collectors.toSet()));
        return entity;
    }

    private void update(HealthStatusEntity entity, HealthStatus toBeUpdated) {
        entity.setPatientId(toBeUpdated.getPatientId());
        entity.setPotentialIllnesses(
                toBeUpdated.getPotentialIllnesses().stream().map(mapper::map).collect(Collectors.toSet()));
    }

}
