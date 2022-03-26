package hu.microservice.medicare.datastore.service;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import hu.microservice.medicare.datastore.PatientData;
import hu.microservice.medicare.datastore.PatientDataEntity;
import hu.microservice.medicare.datastore.PatientDataRepository;
import hu.microservice.medicare.user.UserApi;

@Service
public class PatientService {

    private final PatientDataRepository repository;
    private final PatientDataMapper mapper;
    private final UserApi userApi;

    public PatientService(PatientDataRepository repository,
            PatientDataMapper mapper, UserApi userApi) {
        this.repository = repository;
        this.mapper = mapper;
        this.userApi = userApi;
    }

    public Set<PatientData> getAll() {
        return repository.findAll().stream().map(mapper::map).collect(Collectors.toSet());
    }

    public PatientData getById(String id) throws PatientDataNotFound {
        return repository.findById(id).map(mapper::map).orElseThrow(PatientDataNotFound::new);
    }
    
    public PatientData getByUser(String patientId) throws PatientDataNotFound {
        return repository.findByCreatedBy(patientId).map(mapper::map).orElseThrow(PatientDataNotFound::new);
    }
    
    public PatientData createOrUpdate(String patientId, PatientData patientData) {
        var opt = repository.findByCreatedBy(patientId);
        
        if(opt.isPresent()) {
            return update(opt.get(), patientData);
        }
        
        return create(patientData);
    }

    public PatientData update(PatientDataEntity entity, PatientData toBeUpdated) {
        entity.setActiveSportActivities(toBeUpdated.getActiveSportActivities());
        entity.setAlcoholRegularity(toBeUpdated.getAlcoholRegularity());
        entity.setAncestorDeathCauses(toBeUpdated.getAncestorDeathCauses());
        entity.setAncestorIllnesses(toBeUpdated.getAncestorIllnesses());
        entity.setAverageSleepTime(toBeUpdated.getAverageSleepTime());
        entity.setAverageStressLevel(toBeUpdated.getAverageStressLevel());
        entity.setDateOfBirth(toBeUpdated.getDateOfBirth());
        entity.setDiet(toBeUpdated.getDiet());
        entity.setDoHaveGlasses(toBeUpdated.isDoHaveGlasses());
        entity.setDoHaveKids(toBeUpdated.isDoHaveKids());
        entity.setDoHavePet(toBeUpdated.isDoHavePet());
        entity.setDoUseDrugs(toBeUpdated.isDoUseDrugs());
        entity.setEating(toBeUpdated.getEating());
        entity.setGender(toBeUpdated.getGender());
        entity.setHeight(toBeUpdated.getHeight());
        entity.setJobActivity(toBeUpdated.getJobActivity());
        entity.setJobType(toBeUpdated.getJobType());
        entity.setKnownIllnesses(toBeUpdated.getKnownIllnesses());
        entity.setLivingLocation(toBeUpdated.getLivingLocation());
        entity.setMealsPerDay(toBeUpdated.getMealsPerDay());
        entity.setOnScreenTime(toBeUpdated.getOnScreenTime());
        entity.setPostSportActivities(toBeUpdated.getPostSportActivities());
        entity.setRace(toBeUpdated.getRace());
        entity.setRegularEating(toBeUpdated.isRegularEating());
        entity.setRelationshipStatus(toBeUpdated.getRelationshipStatus());
        entity.setDoSmoke(toBeUpdated.getDoSmoke());
        entity.setWeight(toBeUpdated.getWeight());
        
        var saved = repository.save(entity);
        return mapper.map(saved);
    }

    public PatientData create(PatientData patientData) {
        var entity = createEntity(patientData);
        setCreatedBy(entity);
        var saved = repository.save(entity);
        return mapper.map(saved);
    }

    private void setCreatedBy(PatientDataEntity entity) {
        var user = userApi.getUser();
        entity.setCreatedBy(user.getId());
    }

    private PatientDataEntity createEntity(PatientData dto) {
        var entity = new PatientDataEntity();
        entity.setId(UUID.randomUUID().toString());
        entity.setActiveSportActivities(dto.getActiveSportActivities());
        entity.setAlcoholRegularity(dto.getAlcoholRegularity());
        entity.setAncestorDeathCauses(dto.getAncestorDeathCauses());
        entity.setAncestorIllnesses(dto.getAncestorIllnesses());
        entity.setAverageSleepTime(dto.getAverageSleepTime());
        entity.setAverageStressLevel(dto.getAverageStressLevel());
        entity.setDateOfBirth(dto.getDateOfBirth());
        entity.setDiet(dto.getDiet());
        entity.setDoHaveGlasses(dto.isDoHaveGlasses());
        entity.setDoHaveKids(dto.isDoHaveKids());
        entity.setDoHavePet(dto.isDoHavePet());
        entity.setDoUseDrugs(dto.isDoUseDrugs());
        entity.setEating(dto.getEating());
        entity.setGender(dto.getGender());
        entity.setHeight(dto.getHeight());
        entity.setJobActivity(dto.getJobActivity());
        entity.setJobType(dto.getJobType());
        entity.setKnownIllnesses(dto.getKnownIllnesses());
        entity.setLivingLocation(dto.getLivingLocation());
        entity.setMealsPerDay(dto.getMealsPerDay());
        entity.setOnScreenTime(dto.getOnScreenTime());
        entity.setPostSportActivities(dto.getPostSportActivities());
        entity.setRace(dto.getRace());
        entity.setRegularEating(dto.isRegularEating());
        entity.setRelationshipStatus(dto.getRelationshipStatus());
        entity.setDoSmoke(dto.getDoSmoke());
        entity.setWeight(dto.getWeight());
        return entity;
    }

    public void delete(String id) {
        repository.deleteById(id);
    }
}
