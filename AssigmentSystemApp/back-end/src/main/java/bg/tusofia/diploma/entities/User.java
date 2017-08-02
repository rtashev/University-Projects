package bg.tusofia.diploma.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="user_id")
	@NotNull
	private Integer userId;
	
	@Column(name="name")
	@NotNull
	private String name;
	
	@Column(name="password")
	@NotNull
	private String password;
	
	@Column(name="first_name")
	@NotNull
	private String firstName;
	
	@Column(name="last_name")
	@NotNull
	private String lastName;
	
	@Column(name="role")
	private String role;
	
	@Column(name="has_assigment")
	private Boolean hasAssigment;
	
	public User(){
		
	}
	
	public User(Integer userId, String name, String password, String firstName, String lastName, String role,
			Boolean hasAssigment) {
		this.userId = userId;
		this.name = name;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
		this.hasAssigment = hasAssigment;
	}
	
	public Integer getUserId() {
		return userId;
	}
	
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
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
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	
	public Boolean getHasAssigment() {
		return hasAssigment;
	}
	
	public void setHasAssigment(Boolean hasAssigment) {
		this.hasAssigment = hasAssigment;
	}

}
