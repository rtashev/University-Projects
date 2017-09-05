package bg.tusofia.diploma.services;

import bg.tusofia.diploma.requestObjects.UserLoginRequestObject;
import bg.tusofia.diploma.responseObjects.LoginResponseObject;

public interface UserService {
	
	LoginResponseObject authenticateUser(UserLoginRequestObject user);
}
