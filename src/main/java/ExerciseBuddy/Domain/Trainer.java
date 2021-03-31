package ExerciseBuddy.Domain;

public class Trainer {

	private String firstName;
	private String lastName;
	private String email;
	private Integer phoneNumber;
	private String  sSN;
	private String training;
	private String description;
	
	public Trainer() {
		
	}

	public Trainer(String firstName, String lastName, String email, Integer phoneNumber, String sSN, String training,
			String description) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.sSN = sSN;
		this.training = training;
		this.description = description;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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
	
	
}
