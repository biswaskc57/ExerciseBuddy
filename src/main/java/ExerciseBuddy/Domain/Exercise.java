package ExerciseBuddy.Domain;





import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Exercise {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@DateTimeFormat(pattern= "yyyy-MM-dd")
	private Date reservedTime;
	
	private String name;
	private String type;
	private String sets;
	
	
	@ManyToOne
	@JoinColumn(name = "categoryId")
	private Category category;
	
	public Exercise(){
		
	}
	
	public Exercise (String name,String type,String sets, Category category, Date reservedTime){
		super();
		this.name= name;
		this.type= type;
		this.sets=sets;
		this.category=category;
		this.reservedTime= reservedTime;
	}

	public Date getReservedTime() {
		return reservedTime;
	}

	public void setReservedTime(Date reservedTime) {
		this.reservedTime = reservedTime;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSets() {
		return sets;
	}

	public void setSets(String sets) {
		this.sets = sets;
	}
	
	
}

