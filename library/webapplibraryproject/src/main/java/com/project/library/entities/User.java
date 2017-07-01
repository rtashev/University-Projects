package com.project.library.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="USERS")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_ID", unique = true)
	private Long userId;
	
	@Column(name = "NAME", nullable = false)
	private String name;
	
	@Column(name = "PASSWORD" , nullable = false)
	private String password;
	
	@Column(name = "ROLE", nullable = false)
	private String role;
	
	@Column(name = "ENABLED", nullable = false)
	private boolean enabled;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<BooksLent> booksLentByUser;

	public Long getUserId() {
		return userId;
	}
	
	public List<BooksLent> getBooksLentByUser() {
		return booksLentByUser;
	}

	public void setBooksLentByUser(List<BooksLent> booksLentByUser) {
		this.booksLentByUser = booksLentByUser;
	}

	public void setUserId(Long userId) {
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
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	
	public boolean isEnabled() {
		return enabled;
	}
	
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

//	@Override
//	public String toString() {
//		return "User [userId=" + userId + ", name=" + name + ", password=" + password + ", role=" + role + ", enabled="
//				+ enabled + ", booksLentByUser=" + booksLentByUser + "]";
//	}
	

}
