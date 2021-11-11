package hu.microservice.medicare.datastore.service;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import hu.microservice.medicare.datastore.IllnessEntity;
import hu.microservice.medicare.datastore.IllnessRepository;
import hu.microservice.medicare.datastore.PatientData;
import hu.microservice.medicare.datastore.PatientDataEntity;
import hu.microservice.medicare.datastore.PatientDataRepository;
import hu.microservice.medicare.datastore.SportEntity;
import hu.microservice.medicare.datastore.SportRepository;
import hu.microservice.medicare.user.UserApi;

@Service
public class PatientService {

    private final PatientDataRepository repository;
    private final IllnessRepository illnessRepository;
    private final SportRepository sportRepository;
    private final PatientDataMapper mapper;
    private final UserApi userApi;

    public PatientService(PatientDataRepository repository,
            IllnessRepository illnessRepository,
            SportRepository sportRepository,
            PatientDataMapper mapper, UserApi userApi) {
        this.repository = repository;
        this.illnessRepository = illnessRepository;
        this.sportRepository = sportRepository;
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
        entity.setActiveSportActivities(getSportActivities(dto.getActiveSportActivities()));
        entity.setAlcoholRegularity(dto.getAlcoholRegularity());
        entity.setAncestorDeathCauses(getIllnesses(dto.getAncestorDeathCauses()));
        entity.setAncestorIllnesses(getIllnesses(dto.getAncestorIllnesses()));
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
        entity.setKnownIllnesses(getIllnesses(dto.getKnownIllnesses()));
        entity.setLivingLocation(dto.getLivingLocation());
        entity.setMealsPerDay(dto.getMealsPerDay());
        entity.setOnScreenTime(dto.getOnScreenTime());
        entity.setPostSportActivities(getSportActivities(dto.getPostSportActivities()));
        entity.setRace(dto.getRace());
        entity.setRegularEating(dto.isRegularEating());
        entity.setRelationshipStatus(dto.getRelationshipStatus());
        entity.setSmoking(dto.isSmoking());
        entity.setWakeUpTime(dto.getWakeUpTime());
        entity.setWeight(dto.getWeight());
        return entity;
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

    private Set<SportEntity> getSportActivities(Set<String> sportActivities) {
        var returnSet = new HashSet<SportEntity>();
        sportActivities
                .stream()
                .forEach(sportId -> {
                    sportRepository.findById(sportId).ifPresent(sport -> returnSet.add(sport));
                });

        return returnSet;
    }

    public void delete(String id) {
        repository.deleteById(id);
    }

    private void update(PatientDataEntity entity, PatientData dto) {
        entity.setActiveSportActivities(getSportActivities(dto.getActiveSportActivities()));
        entity.setAlcoholRegularity(dto.getAlcoholRegularity());
        entity.setAncestorDeathCauses(getIllnesses(dto.getAncestorDeathCauses()));
        entity.setAncestorIllnesses(getIllnesses(dto.getAncestorIllnesses()));
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
        entity.setKnownIllnesses(getIllnesses(dto.getKnownIllnesses()));
        entity.setLivingLocation(dto.getLivingLocation());
        entity.setMealsPerDay(dto.getMealsPerDay());
        entity.setOnScreenTime(dto.getOnScreenTime());
        entity.setPostSportActivities(getSportActivities(dto.getPostSportActivities()));
        entity.setRace(dto.getRace());
        entity.setRegularEating(dto.isRegularEating());
        entity.setRelationshipStatus(dto.getRelationshipStatus());
        entity.setSmoking(dto.isSmoking());
        entity.setWakeUpTime(dto.getWakeUpTime());
        entity.setWeight(dto.getWeight());
    }
}
