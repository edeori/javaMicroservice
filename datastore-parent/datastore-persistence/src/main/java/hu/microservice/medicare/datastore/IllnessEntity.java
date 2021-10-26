package hu.microservice.medicare.datastore;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "illness")
public class IllnessEntity {

	@Id
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
}
