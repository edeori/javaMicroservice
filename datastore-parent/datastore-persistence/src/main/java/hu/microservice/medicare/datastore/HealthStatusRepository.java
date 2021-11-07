package hu.microservice.medicare.datastore;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HealthStatusRepository extends JpaRepository<HealthStatusEntity, String> {

    Optional<HealthStatusEntity> findByPatientId(String patientId);
}
