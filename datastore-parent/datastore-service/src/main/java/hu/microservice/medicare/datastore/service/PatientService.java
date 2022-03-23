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

    public PatientData updateById(String id, PatientData patientData) throws PatientDataNotFound {
        var opt = repository.findById(id);
        if (opt.isEmpty()) {
            throw new PatientDataNotFound();
        }
        var entity = opt.get();
        update(entity, patientData);
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
        entity.setSmoking(dto.isSmoking());
        entity.setWeight(dto.getWeight());
        return entity;
    }

    private void update(PatientDataEntity entity, PatientData dto) {
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
        entity.setSmoking(dto.isSmoking());
        entity.setWeight(dto.getWeight());
    }

    public void delete(String id) {
        repository.deleteById(id);
    }
}
