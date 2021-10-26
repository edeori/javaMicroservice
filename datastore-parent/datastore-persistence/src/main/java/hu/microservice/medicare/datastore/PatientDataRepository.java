package hu.microservice.medicare.datastore;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientDataRepository extends JpaRepository<PatientDataEntity, String> {

}
