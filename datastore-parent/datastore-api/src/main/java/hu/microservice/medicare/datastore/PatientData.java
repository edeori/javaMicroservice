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

	private Set<String> activeSportActivities = new HashSet<>();
	private Set<String> postSportActivities = new HashSet<>();

	private Set<String> knownIllnesses = new HashSet<>();
	private Set<String> ancestorIllnesses = new HashSet<>();
	private Set<String> ancestorDeathCauses = new HashSet<>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender genre) {
		this.gender = genre;
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

	public Set<String> getActiveSportActivities() {
		return activeSportActivities;
	}

	public void setActiveSportActivities(Set<String> activeSportActivities) {
		this.activeSportActivities = activeSportActivities;
	}

	public Set<String> getPostSportActivities() {
		return postSportActivities;
	}

	public void setPostSportActivities(Set<String> postSportActivities) {
		this.postSportActivities = postSportActivities;
	}

	public Set<String> getKnownIllnesses() {
		return knownIllnesses;
	}

	public void setKnownIllnesses(Set<String> knownIllnesses) {
		this.knownIllnesses = knownIllnesses;
	}

	public Set<String> getAncestorIllnesses() {
		return ancestorIllnesses;
	}

	public void setAncestorIllnesses(Set<String> ancestorIllnesses) {
		this.ancestorIllnesses = ancestorIllnesses;
	}

	public Set<String> getAncestorDeathCauses() {
		return ancestorDeathCauses;
	}

	public void setAncestorDeathCauses(Set<String> ancestorDeathCauses) {
		this.ancestorDeathCauses = ancestorDeathCauses;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((activeSportActivities == null) ? 0 : activeSportActivities.hashCode());
		result = prime * result + ((alcoholRegularity == null) ? 0 : alcoholRegularity.hashCode());
		result = prime * result + ((ancestorDeathCauses == null) ? 0 : ancestorDeathCauses.hashCode());
		result = prime * result + ((ancestorIllnesses == null) ? 0 : ancestorIllnesses.hashCode());
		result = prime * result + ((averageSleepTime == null) ? 0 : averageSleepTime.hashCode());
		result = prime * result + ((averageStressLevel == null) ? 0 : averageStressLevel.hashCode());
		result = prime * result + ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
		result = prime * result + ((diet == null) ? 0 : diet.hashCode());
		result = prime * result + (doHaveGlasses ? 1231 : 1237);
		result = prime * result + (doHaveKids ? 1231 : 1237);
		result = prime * result + (doHavePet ? 1231 : 1237);
		result = prime * result + (doUseDrugs ? 1231 : 1237);
		result = prime * result + ((eating == null) ? 0 : eating.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((height == null) ? 0 : height.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + (isSmoking ? 1231 : 1237);
		result = prime * result + ((jobActivity == null) ? 0 : jobActivity.hashCode());
		result = prime * result + ((jobType == null) ? 0 : jobType.hashCode());
		result = prime * result + ((knownIllnesses == null) ? 0 : knownIllnesses.hashCode());
		result = prime * result + ((livingLocation == null) ? 0 : livingLocation.hashCode());
		result = prime * result + ((mealsPerDay == null) ? 0 : mealsPerDay.hashCode());
		result = prime * result + ((onScreenTime == null) ? 0 : onScreenTime.hashCode());
		result = prime * result + ((postSportActivities == null) ? 0 : postSportActivities.hashCode());
		result = prime * result + ((race == null) ? 0 : race.hashCode());
		result = prime * result + (regularEating ? 1231 : 1237);
		result = prime * result + ((relationshipStatus == null) ? 0 : relationshipStatus.hashCode());
		result = prime * result + ((wakeUpTime == null) ? 0 : wakeUpTime.hashCode());
		result = prime * result + ((weight == null) ? 0 : weight.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PatientData other = (PatientData) obj;
		if (activeSportActivities == null) {
			if (other.activeSportActivities != null)
				return false;
		} else if (!activeSportActivities.equals(other.activeSportActivities))
			return false;
		if (alcoholRegularity != other.alcoholRegularity)
			return false;
		if (ancestorDeathCauses == null) {
			if (other.ancestorDeathCauses != null)
				return false;
		} else if (!ancestorDeathCauses.equals(other.ancestorDeathCauses))
			return false;
		if (ancestorIllnesses == null) {
			if (other.ancestorIllnesses != null)
				return false;
		} else if (!ancestorIllnesses.equals(other.ancestorIllnesses))
			return false;
		if (averageSleepTime == null) {
			if (other.averageSleepTime != null)
				return false;
		} else if (!averageSleepTime.equals(other.averageSleepTime))
			return false;
		if (averageStressLevel == null) {
			if (other.averageStressLevel != null)
				return false;
		} else if (!averageStressLevel.equals(other.averageStressLevel))
			return false;
		if (dateOfBirth == null) {
			if (other.dateOfBirth != null)
				return false;
		} else if (!dateOfBirth.equals(other.dateOfBirth))
			return false;
		if (diet != other.diet)
			return false;
		if (doHaveGlasses != other.doHaveGlasses)
			return false;
		if (doHaveKids != other.doHaveKids)
			return false;
		if (doHavePet != other.doHavePet)
			return false;
		if (doUseDrugs != other.doUseDrugs)
			return false;
		if (eating != other.eating)
			return false;
		if (gender != other.gender)
			return false;
		if (height == null) {
			if (other.height != null)
				return false;
		} else if (!height.equals(other.height))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isSmoking != other.isSmoking)
			return false;
		if (jobActivity != other.jobActivity)
			return false;
		if (jobType != other.jobType)
			return false;
		if (knownIllnesses == null) {
			if (other.knownIllnesses != null)
				return false;
		} else if (!knownIllnesses.equals(other.knownIllnesses))
			return false;
		if (livingLocation != other.livingLocation)
			return false;
		if (mealsPerDay == null) {
			if (other.mealsPerDay != null)
				return false;
		} else if (!mealsPerDay.equals(other.mealsPerDay))
			return false;
		if (onScreenTime == null) {
			if (other.onScreenTime != null)
				return false;
		} else if (!onScreenTime.equals(other.onScreenTime))
			return false;
		if (postSportActivities == null) {
			if (other.postSportActivities != null)
				return false;
		} else if (!postSportActivities.equals(other.postSportActivities))
			return false;
		if (race != other.race)
			return false;
		if (regularEating != other.regularEating)
			return false;
		if (relationshipStatus != other.relationshipStatus)
			return false;
		if (wakeUpTime == null) {
			if (other.wakeUpTime != null)
				return false;
		} else if (!wakeUpTime.equals(other.wakeUpTime))
			return false;
		if (weight == null) {
			if (other.weight != null)
				return false;
		} else if (!weight.equals(other.weight))
			return false;
		return true;
	}
}
