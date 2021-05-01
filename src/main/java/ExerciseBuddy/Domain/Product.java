package ExerciseBuddy.Domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Product {

	private static final Long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String photos;

	private String name;
	private String description;
	private boolean isAvailable;
	private int price;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "trainer_id")
	private Trainer trainer;

	public Product() {

	}

	public Product( String name, String description, boolean isAvailable, int price, Trainer trainer, String photos) {
		super();
		this.name = name;
		this.description = description;
		this.isAvailable = isAvailable;
		this.price = price;
		this.trainer = trainer;
		this.photos= photos;
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
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
		if (photos == null || id == null)
			return null;

		return "/" + getId() + "/" + photos;
	}

}