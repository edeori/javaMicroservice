package hu.microservice.medicare.datastore;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IllnessRepository extends JpaRepository<IllnessEntity, String> {

}
