package ExerciseBuddy.Domain;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Product {

	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	
	
	@Column(columnDefinition = "MEDIUMBLOB")
	    private String photos;
	  
	  

	




	

	private String Name;
	private String Description;
	private boolean isAvailable;
	private int price;
	
	
	
	
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "trainer_id")
	private Trainer trainer;
	
	



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
	 
	public String getPhotos() {
		return photos;
	}



	public void setPhotos(String photos) {
		this.photos = photos;
	}

	
	 @Transient
	    public String getPhotosImagePath() {
	        if (photos == null || id == null) return null;
	         
	        return "/user-photos/" + id + "/" + photos;
	    }
	}
	

