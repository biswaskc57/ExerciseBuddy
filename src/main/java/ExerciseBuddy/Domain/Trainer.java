package ExerciseBuddy.Domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Trainer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	
	private String name;
	
	private String email;
	private Integer phoneNumber;
	private String  sSN;
	private String training;

	private String description;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "trainer")
	private List <Training> trainings;
	
	

	public Trainer() {
		
	}

	public Trainer( String name, String email, Integer phoneNumber, String sSN, String training,
			String description) {
		super();
		this.name = name;
		
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.sSN = sSN;
		this.training = training;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	} 
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumbebr(Integer phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getSSN() {
		return sSN;
	}

	public void setSSN(String sSN) {
		this.sSN = sSN;
	}

	public String getTraining() {
		return training;
	}

	public void setTraining(String training) {
		this.training = training;
	}

	public String getDescription() {
		return description;
	}

	public void setDescriptiom(String descriptiom) {
		this.description = descriptiom;
	}

	public List <Training> getTrainings() {
		return trainings;
	}

	public void setTrainings(List <Training> trainings) {
		this.trainings = trainings;
	}
	
	
}
