package com.project.library.dao;

import java.util.List;

import com.project.library.entities.User;

public interface UserDao {
	
	List<User> getAllUsers();
	
	User getUserByName(String username);
	
	void addNewUser(User user);
	
}
