package bg.tusofia.diploma.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bg.tusofia.diploma.requestObjects.UserLoginRequestObject;
import bg.tusofia.diploma.responseObjects.LoginResponseObject;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class LoginController {
	
	@RequestMapping(value = "/auth", method = {RequestMethod.POST}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public LoginResponseObject authenticateUser(@RequestBody UserLoginRequestObject obj){
		System.out.println(obj);
		System.out.println(obj.getUsername());
		System.out.println(obj.getUsername());
		
		// TODO : call service (map to entity) -> call DAO (save in DB)
		
		return new LoginResponseObject(1,"201213052","TEACHER","Radoslav","Tashev", null);
	}
	
}
