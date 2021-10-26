package hu.microservice.medicare.datastore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sport")
public class SportEntity {

	@Id
	private String id;

	@Column(name = "name", unique = true, nullable = false)
	private String name;
	
	private SportActivity sportActivity;

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

	public SportActivity getSportActivity() {
		return sportActivity;
	}

	public void setSportActivity(SportActivity sportActivity) {
		this.sportActivity = sportActivity;
	}	
}
