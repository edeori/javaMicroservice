package hu.microservice.medicare.datastore;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientDataRepository extends JpaRepository<PatientDataEntity, String> {
    
    Optional<PatientDataEntity> findByCreatedBy(String createdBy);

}
