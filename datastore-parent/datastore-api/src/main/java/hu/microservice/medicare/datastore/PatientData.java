package hu.microservice.medicare.datastore;

import java.util.HashSet;
import java.util.Set;

public class PatientData {

	private String id;
	private Gender gender;
	private String dateOfBirth;
	private Double weight;
	private Double height;
	private RelationshipStatus relationshipStatus;
	private boolean doHaveKids;
	private JobType jobType;
	private JobActivity jobActivity;
	private Location livingLocation;
	private Race race;
	private String createdBy;

	private Integer averageSleepTime;
	private Integer onScreenTime;

	private Integer averageStressLevel;

	private boolean regularEating;
	private Integer mealsPerDay;
	private Eating eating;
	private Diet diet;
	private AlcoholRegularity alcoholRegularity;

	private boolean isSmoking;
	private boolean doUseDrugs;
	private boolean doHaveGlasses;
	private boolean doHavePet;

	private Set<SportActivity> activeSportActivities = new HashSet<>();
	private Set<SportActivity> postSportActivities = new HashSet<>();

	private Set<IllnessCategory> knownIllnesses = new HashSet<>();
	private Set<IllnessCategory> ancestorIllnesses = new HashSet<>();
	private Set<IllnessCategory> ancestorDeathCauses = new HashSet<>();
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public Gender getGender() {
        return gender;
    }
    public void setGender(Gender gender) {
        this.gender = gender;
    }
    public String getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public Double getWeight() {
        return weight;
    }
    public void setWeight(Double weight) {
        this.weight = weight;
    }
    public Double getHeight() {
        return height;
    }
    public void setHeight(Double height) {
        this.height = height;
    }
    public RelationshipStatus getRelationshipStatus() {
        return relationshipStatus;
    }
    public void setRelationshipStatus(RelationshipStatus relationshipStatus) {
        this.relationshipStatus = relationshipStatus;
    }
    public boolean isDoHaveKids() {
        return doHaveKids;
    }
    public void setDoHaveKids(boolean doHaveKids) {
        this.doHaveKids = doHaveKids;
    }
    public JobType getJobType() {
        return jobType;
    }
    public void setJobType(JobType jobType) {
        this.jobType = jobType;
    }
    public JobActivity getJobActivity() {
        return jobActivity;
    }
    public void setJobActivity(JobActivity jobActivity) {
        this.jobActivity = jobActivity;
    }
    public Location getLivingLocation() {
        return livingLocation;
    }
    public void setLivingLocation(Location livingLocation) {
        this.livingLocation = livingLocation;
    }
    public Race getRace() {
        return race;
    }
    public void setRace(Race race) {
        this.race = race;
    }
    public String getCreatedBy() {
        return createdBy;
    }
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
    public Integer getAverageSleepTime() {
        return averageSleepTime;
    }
    public void setAverageSleepTime(Integer averageSleepTime) {
        this.averageSleepTime = averageSleepTime;
    }
    public Integer getOnScreenTime() {
        return onScreenTime;
    }
    public void setOnScreenTime(Integer onScreenTime) {
        this.onScreenTime = onScreenTime;
    }
    public Integer getAverageStressLevel() {
        return averageStressLevel;
    }
    public void setAverageStressLevel(Integer averageStressLevel) {
        this.averageStressLevel = averageStressLevel;
    }
    public boolean isRegularEating() {
        return regularEating;
    }
    public void setRegularEating(boolean regularEating) {
        this.regularEating = regularEating;
    }
    public Integer getMealsPerDay() {
        return mealsPerDay;
    }
    public void setMealsPerDay(Integer mealsPerDay) {
        this.mealsPerDay = mealsPerDay;
    }
    public Eating getEating() {
        return eating;
    }
    public void setEating(Eating eating) {
        this.eating = eating;
    }
    public Diet getDiet() {
        return diet;
    }
    public void setDiet(Diet diet) {
        this.diet = diet;
    }
    public AlcoholRegularity getAlcoholRegularity() {
        return alcoholRegularity;
    }
    public void setAlcoholRegularity(AlcoholRegularity alcoholRegularity) {
        this.alcoholRegularity = alcoholRegularity;
    }
    public boolean isSmoking() {
        return isSmoking;
    }
    public void setSmoking(boolean isSmoking) {
        this.isSmoking = isSmoking;
    }
    public boolean isDoUseDrugs() {
        return doUseDrugs;
    }
    public void setDoUseDrugs(boolean doUseDrugs) {
        this.doUseDrugs = doUseDrugs;
    }
    public boolean isDoHaveGlasses() {
        return doHaveGlasses;
    }
    public void setDoHaveGlasses(boolean doHaveGlasses) {
        this.doHaveGlasses = doHaveGlasses;
    }
    public boolean isDoHavePet() {
        return doHavePet;
    }
    public void setDoHavePet(boolean doHavePet) {
        this.doHavePet = doHavePet;
    }
    public Set<SportActivity> getActiveSportActivities() {
        return activeSportActivities;
    }
    public void setActiveSportActivities(Set<SportActivity> activeSportActivities) {
        this.activeSportActivities = activeSportActivities;
    }
    public Set<SportActivity> getPostSportActivities() {
        return postSportActivities;
    }
    public void setPostSportActivities(Set<SportActivity> postSportActivities) {
        this.postSportActivities = postSportActivities;
    }
    public Set<IllnessCategory> getKnownIllnesses() {
        return knownIllnesses;
    }
    public void setKnownIllnesses(Set<IllnessCategory> knownIllnesses) {
        this.knownIllnesses = knownIllnesses;
    }
    public Set<IllnessCategory> getAncestorIllnesses() {
        return ancestorIllnesses;
    }
    public void setAncestorIllnesses(Set<IllnessCategory> ancestorIllnesses) {
        this.ancestorIllnesses = ancestorIllnesses;
    }
    public Set<IllnessCategory> getAncestorDeathCauses() {
        return ancestorDeathCauses;
    }
    public void setAncestorDeathCauses(Set<IllnessCategory> ancestorDeathCauses) {
        this.ancestorDeathCauses = ancestorDeathCauses;
    }
}
