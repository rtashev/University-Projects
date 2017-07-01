package com.project.library.services;

import java.util.List;

import com.project.library.entities.User;

public interface UserService {
	
	List<User> getallUsers();
	
	void createNewUser(User user);
}
