package com.project.library.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.library.dao.UserRegistryDao;
import com.project.library.entities.User;

@Service("userRegistryService")
public class UserRegistryServiceImpl implements UserRegistryService{
	
	@Autowired
	private UserRegistryDao userRegistryDao;
	
	@Override
	public List<User> findUserByName(String name) {
		
		
		return userRegistryDao.findUserByName(name);
	}

	@Override
	public User findUserById(Long id) {
		
		
		return userRegistryDao.findUserById(id);
	}

	@Override
	public void changeUserStatus(User user) {
		
		User userChangedStatus = user;
		
		if(userChangedStatus.isEnabled()){
			
			userChangedStatus.setEnabled(false);
		}else{
			
			userChangedStatus.setEnabled(true);
		}
		
		
		userRegistryDao.updateUser(userChangedStatus);
	}

	@Override
	public void changeUserRole(User user) {
		
		if(user.getRole().equals("ROLE_USER")){
			
			user.setRole("ROLE_ADMIN");
			
		}else{
			
			user.setRole("ROLE_USER");			
		}
		
		userRegistryDao.updateUser(user);
	}

}
