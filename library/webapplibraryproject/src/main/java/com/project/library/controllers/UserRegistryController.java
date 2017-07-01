package com.project.library.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.library.entities.BooksLent;
import com.project.library.entities.User;
import com.project.library.services.BookRegistryService;
import com.project.library.services.LentBookService;
import com.project.library.services.UserRegistryService;

@Scope("session")
@Controller
@Secured("ROLE_ADMIN")
public class UserRegistryController {
	
	@Autowired
	private UserRegistryService userRegService;
	
	@Autowired
	private LentBookService lentBookService;
	
	@Autowired
	private BookRegistryService bookRegService;
	
	private List<User> resultList;
	
	@RequestMapping(value = "/userRegistry", method = RequestMethod.GET)
	public String getUserRegisrty(Model model){
		
		model.addAttribute("user", resultList);
		
		return "userRegistry";
	}
	
	@RequestMapping(value = "/finduser", method = RequestMethod.POST)
	public String findUserByName(Model model,  @RequestParam("userSearchBar") String searchAttribute){
		
		if(searchAttribute == null || searchAttribute.isEmpty()){
			resultList = null;
		}
		
		if(searchAttribute != null && !searchAttribute.isEmpty()){
			
			resultList = userRegService.findUserByName(searchAttribute);
			
			model.addAttribute("user", resultList);
		}
		return "redirect:/userRegistry";
	}
	
	@RequestMapping(value = "/changeUserStatus/{userId}", method = RequestMethod.POST)
	public String changeUserStatus(Model model, @ModelAttribute("user") User user, 
			@PathVariable("userId") Long userId){
		
		userRegService.changeUserStatus(userRegService.findUserById(userId));
		
		return "redirect:/userRegistry";
	}
	
	
	@RequestMapping(value = "/changeUserRole/{userId}", method = RequestMethod.POST)
	public String changeUserRole(Model model, @ModelAttribute("user") User user , 
			@PathVariable("userId") Long userId){
		
		userRegService.changeUserRole(userRegService.findUserById(userId));
		
		return "redirect:/userRegistry";
	}
	
	@RequestMapping(value = "/booksLentByUser/{userId}", method = RequestMethod.GET)
	public String getBooksLentByUser(Model model, @PathVariable("userId") Long userId){
		
		model.addAttribute("lentInfo", lentBookService.getUsersActiveLents(userRegService.findUserById(userId)));
		
		return "booksLentByUser";
	}
	
	@RequestMapping(value = "/booksLentByUser/{userId}/returned/{bookId}", method = RequestMethod.POST)
	public String submitReturnedBook(Model model, @PathVariable("userId") Long userId, 
			@PathVariable("bookId") Long bookId){		
		/**
		 * WORK TO BE DONE :
		 * - see if you can get @modelAttribute(lentinfo) and pass it to DB directly
		 * -debug whole flow !!!
		 */
		
		User user = userRegService.findUserById(userId);
		
		lentBookService.returnBook(user, bookRegService.searchBookById(bookId));
		
		List<BooksLent> bl = lentBookService.getUsersActiveLents(user);
		
		model.addAttribute("lentInfo",bl);
		
		return "redirect:/booksLentByUser/{userId}";
	}

	
}
