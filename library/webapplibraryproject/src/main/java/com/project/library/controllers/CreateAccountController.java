package com.project.library.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.library.entities.User;
import com.project.library.services.UserService;

@Controller
public class CreateAccountController {
	
	private boolean passwordsDontMatch = false;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value ="/createAccount", method = RequestMethod.GET)
	public String getCreateAccount(Model model){
		
		model.addAttribute("passwordsDontMatch", passwordsDontMatch);
		
		System.out.println("create acc hit");
		return "createAccount";
	}
	
	@RequestMapping(value="/createAccount", method = RequestMethod.POST)
	public String createAccount(Model model, @ModelAttribute("user") User user, @RequestParam("confirmPassword") String confrimPassword){

		System.out.println("hit da fking controller");
		
		if(user.getPassword().equals(confrimPassword)){
			
			passwordsDontMatch = false;
			
			// Setting the enabled and role fields of the User
			user.setEnabled(true);
			user.setRole("ROLE_USER");						
			System.out.println(user.toString());
			
			userService.createNewUser(user);
			
			return "redirect:/login";

		}else{
			
			passwordsDontMatch = true;
			model.addAttribute("passwordsDontMatch",passwordsDontMatch);
			
			return "redirect:/createAccount";
		}

	}
	
}
