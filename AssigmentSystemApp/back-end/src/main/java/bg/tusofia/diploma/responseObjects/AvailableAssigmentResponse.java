package bg.tusofia.diploma.responseObjects;

public class AvailableAssigmentResponse {
	
	private Integer id;
	private String name;
	private String description;
	private String category;
	
	public AvailableAssigmentResponse(){
		
	}
	
	public AvailableAssigmentResponse(Integer id, String name, String description, String category) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.category = category;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "OBJ : " + "/n" + "id:"+this.getId().intValue() + "/n" + "name:"+this.name 
				+"/n" + "descr:"+this.getDescription()+"/n"+"category:"+this.category;
	}
	
	
}
