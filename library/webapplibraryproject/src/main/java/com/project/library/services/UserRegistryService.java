package com.project.library.services;

import java.util.List;

import com.project.library.entities.User;

public interface UserRegistryService {
	
	List<User> findUserByName(String userName);
	
	User findUserById(Long id);
	
	void changeUserStatus(User user);

	void changeUserRole(User user);
}
