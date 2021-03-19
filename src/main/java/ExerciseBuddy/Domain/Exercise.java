package ExerciseBuddy.Domain;

public class Exercise {

	private long id;
	private String name;
	private String type;
	private Integer duration;
	
	Exercise(){
		
	}
	
	Exercise (long id,String name,String type,Integer duration ){
		this.id=id;
		this.name= name;
		this.type= type;
		this.duration=duration;
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

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	
	
}

