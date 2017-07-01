package com.project.library.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.library.entities.BooksLent;
import com.project.library.services.LentBookService;
import com.project.library.services.UserRegistryService;

@Controller
public class BooksLentByMeController {
	
	@Autowired
	private LentBookService lentBookServ;
	
	@Autowired
	private UserRegistryService userRegServ;
	
	@RequestMapping(value = "/booksLentByMe", method = RequestMethod.GET)
	public String getBooksLentByMe(Model model){
		
		UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = userDetails.getUsername();
		
		List<BooksLent> lentInfo = lentBookServ.getUsersActiveLents(userRegServ.findUserByName(username).get(0));

		model.addAttribute("lentInfo", lentInfo);
				
		return "booksLentByMe";
	}
	
}