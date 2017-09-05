package bg.tusofia.diploma.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bg.tusofia.diploma.entities.User;
import bg.tusofia.diploma.requestObjects.UserLoginRequestObject;
import bg.tusofia.diploma.responseObjects.LoginResponseObject;
import bg.tusofia.diploma.services.UserService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class LoginController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/auth", method = {RequestMethod.POST}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public LoginResponseObject authenticateUser(@RequestBody UserLoginRequestObject obj){
		
		
		LoginResponseObject loginResponse = userService.authenticateUser(obj);
		
		System.out.println(loginResponse.getFirst_name());
		System.out.println(loginResponse.getLast_name());
		System.out.println(loginResponse);
		
		
		return loginResponse;
	}
	
}
