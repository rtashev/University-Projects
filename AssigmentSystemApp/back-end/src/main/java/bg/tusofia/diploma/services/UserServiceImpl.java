package bg.tusofia.diploma.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bg.tusofia.diploma.dao.UserDao;
import bg.tusofia.diploma.entities.User;
import bg.tusofia.diploma.requestObjects.UserLoginRequestObject;
import bg.tusofia.diploma.responseObjects.LoginResponseObject;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;
	
	public LoginResponseObject authenticateUser(UserLoginRequestObject user){
		
		User returnedUser = null;
		returnedUser = userDao.getUser(user.getUsername(), user.getPassword());
		
		if(returnedUser == null){
			return null;
		}else{
			LoginResponseObject userResponse = new LoginResponseObject();
			
			userResponse.setFirst_name(returnedUser.getFirstName());
			userResponse.setId(returnedUser.getUserId());
			userResponse.setLast_name(returnedUser.getLastName());
			userResponse.setRole(returnedUser.getRole());
			userResponse.setHas_Assigment(returnedUser.getHasAssigment());
			userResponse.setUsername(returnedUser.getName());
			
			return userResponse;
		}
		
	}

}
