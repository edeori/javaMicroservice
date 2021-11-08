package hu.microservice.medicare.datastore.service;

import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import hu.microservice.medicare.datastore.HealthStatus;
import hu.microservice.medicare.datastore.HealthStatusEntity;
import hu.microservice.medicare.datastore.HealthStatusRepository;

@Service
public class HealthStatusService {

    private final HealthStatusRepository repository;
    private final HealthStatusMapper mapper;
    private final IllnessMapper illnessMapper;

    public HealthStatusService(HealthStatusRepository repository, HealthStatusMapper mapper,
            IllnessMapper illnessMapper) {
        this.repository = repository;
        this.mapper = mapper;
        this.illnessMapper = illnessMapper;
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
        var saved = repository.save(mapper.map(healthStatus));
        return mapper.map(saved);
    }

    private void update(HealthStatusEntity entity, HealthStatus toBeUpdated) {
        entity.setPatientData(toBeUpdated.getPatientId());
        entity.setPotentialIllnesses(
                toBeUpdated.getPotentialIllnesses().stream().map(illnessMapper::map).collect(Collectors.toSet()));
    }

}
