package com.project.library.dao;

import java.util.List;

import com.project.library.entities.User;

public interface UserRegistryDao {
	
	List<User> findUserByName(String userName);

	User findUserById(Long id);
	
	void updateUser(User user);

	
}
