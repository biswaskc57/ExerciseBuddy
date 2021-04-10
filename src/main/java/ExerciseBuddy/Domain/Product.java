package ExerciseBuddy.Domain;

import java.beans.Transient;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Product {

	
	
	private static final Long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	
	
	
	private String Name;
	private String Description;
	private boolean isAvailable;
	private int price;
	
	
	@Lob
	@Column(columnDefinition = "MEDIUMBLOB")
	private String image;
	
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "trainer_id")
	private Trainer trainer;
	
	public String getImage() {
		return image;
	}



	public void setImage(String image) {
		this.image = image;
	}



	public Product() {
		
	}

	

	public Product( String name, String description, boolean isAvailable, int price,Trainer trainer ) {
		super();
		Name = name;
		Description = description;
		this.isAvailable = isAvailable;
		this.price = price;
		this.trainer = trainer;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Trainer getTrainer() {
		return trainer;
	}



	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}



	public String getName() {
		return Name;
	}


	public void setName(String name) {
		Name = name;
	}


	public String getDescription() {
		return Description;
	}


	public void setDescription(String description) {
		Description = description;
	}


	public boolean isAvailable() {
		return isAvailable;
	}


	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}
	 @Transient
	    public String getPhotosImagePath() {
	        if (image== null || id == null) return null;
	         
	        return "/user-photos/" + id + "/" + image;
	    }
	
	
	
}
