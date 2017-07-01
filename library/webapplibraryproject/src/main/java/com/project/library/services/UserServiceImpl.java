package com.project.library.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.library.dao.UserDao;
import com.project.library.entities.User;

@Service("UserService")
public class UserServiceImpl implements UserService{

	private List<User> userList = new ArrayList<>();
	
	@Autowired
	private UserDao userDao;
	
	
	@Override
	public List<User> getallUsers() {
		
		userList = userDao.getAllUsers();
		
		return userList;
	}


	@Override
	public void createNewUser(User user) {
		
		userDao.addNewUser(user);		
	}

}

