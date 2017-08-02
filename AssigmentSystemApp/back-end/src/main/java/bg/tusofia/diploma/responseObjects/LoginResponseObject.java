package bg.tusofia.diploma.responseObjects;

public class LoginResponseObject{
	
	private Integer id;
	private String username;
	private String role;
	private String first_name;
	private String last_name;
	private Boolean has_Assigment;

	public LoginResponseObject(){
		
	}
	
	public LoginResponseObject(Integer id, String username, String role, String first_name, String last_name, Boolean has_Assigment) {
		this.id = id;
		this.username = username;
		this.role = role;
		this.first_name = first_name;
		this.last_name = last_name;
		this.has_Assigment = has_Assigment;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public Boolean getHas_Assigment() {
		return has_Assigment;
	}

	public void setHas_Assigment(Boolean has_Assigment) {
		this.has_Assigment = has_Assigment;
	}

}
