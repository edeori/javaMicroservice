package hu.microservice.medicare.datastore;

public class Illness {

	private String id;
	private String name;
	private IllnessCategory category;
	private Double deathRate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public IllnessCategory getCategory() {
		return category;
	}

	public void setCategory(IllnessCategory category) {
		this.category = category;
	}

	public Double getDeathRate() {
		return deathRate;
	}

	public void setDeathRate(Double deathRate) {
		this.deathRate = deathRate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((deathRate == null) ? 0 : deathRate.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Illness other = (Illness) obj;
		if (category != other.category)
			return false;
		if (deathRate == null) {
			if (other.deathRate != null)
				return false;
		} else if (!deathRate.equals(other.deathRate))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
