package hu.microservice.medicare.datastore;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "patientdata")
public class PatientDataEntity {

	@Id
	private String id;
	private Genre genre;
	private String dateOfBirth;
	private Double weight;
	private Double height;
	private RelationshipStatus relationshipStatus;
	private boolean doHaveKids;
	private JobType jobType;
	private JobActivity jobActivity;
	private Location livingLocation;
	private Race race;

	private Integer averageSleepTime;
	private String wakeUpTime;
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

	@ManyToMany
	@JoinTable(name = "active_sport_activities", joinColumns = @JoinColumn(name = "patient_data_id"), inverseJoinColumns = @JoinColumn(name = "sport_id"))
	private Set<SportEntity> activeSportActivities = new HashSet<>();
	
	@ManyToMany
	@JoinTable(name = "post_sport_activities", joinColumns = @JoinColumn(name = "patient_data_id"), inverseJoinColumns = @JoinColumn(name = "sport_id"))
	private Set<SportEntity> postSportActivities = new HashSet<>();

	@ManyToMany
	@JoinTable(name = "known_illnesses", joinColumns = @JoinColumn(name = "patient_data_id"), inverseJoinColumns = @JoinColumn(name = "illness_id"))
	private Set<IllnessEntity> knownIllnesses = new HashSet<>();

	@ManyToMany
	@JoinTable(name = "ancestor_illnesses", joinColumns = @JoinColumn(name = "patient_data_id"), inverseJoinColumns = @JoinColumn(name = "illness_id"))
	private Set<IllnessEntity> ancestorIllnesses = new HashSet<>();

	@ManyToMany
	@JoinTable(name = "ancestor_death_causes", joinColumns = @JoinColumn(name = "patient_data_id"), inverseJoinColumns = @JoinColumn(name = "illness_id"))
	private Set<IllnessEntity> ancestorDeathCauses = new HashSet<>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
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

	public Integer getAverageSleepTime() {
		return averageSleepTime;
	}

	public void setAverageSleepTime(Integer averageSleepTime) {
		this.averageSleepTime = averageSleepTime;
	}

	public String getWakeUpTime() {
		return wakeUpTime;
	}

	public void setWakeUpTime(String wakeUpTime) {
		this.wakeUpTime = wakeUpTime;
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

	public Set<SportEntity> getActiveSportActivities() {
		return activeSportActivities;
	}

	public void setActiveSportActivities(Set<SportEntity> activeSportActivities) {
		this.activeSportActivities = activeSportActivities;
	}

	public Set<SportEntity> getPostSportActivities() {
		return postSportActivities;
	}

	public void setPostSportActivities(Set<SportEntity> postSportActivities) {
		this.postSportActivities = postSportActivities;
	}

	public Set<IllnessEntity> getKnownIllnesses() {
		return knownIllnesses;
	}

	public void setKnownIllnesses(Set<IllnessEntity> knownIllnesses) {
		this.knownIllnesses = knownIllnesses;
	}

	public Set<IllnessEntity> getAncestorIllnesses() {
		return ancestorIllnesses;
	}

	public void setAncestorIllnesses(Set<IllnessEntity> ancestorIllnesses) {
		this.ancestorIllnesses = ancestorIllnesses;
	}

	public Set<IllnessEntity> getAncestorDeathCauses() {
		return ancestorDeathCauses;
	}

	public void setAncestorDeathCauses(Set<IllnessEntity> ancestorDeathCauses) {
		this.ancestorDeathCauses = ancestorDeathCauses;
	}

}
