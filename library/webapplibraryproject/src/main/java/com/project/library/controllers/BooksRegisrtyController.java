package com.project.library.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
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

import com.project.library.entities.Book;
import com.project.library.services.BookRegistryService;
import com.project.library.services.LentBookService;
import com.project.library.utils.MyDateUtil;

@Scope("session")
@Controller
public class BooksRegisrtyController {
	
	@Autowired
	private BookRegistryService bookRegService;
	
	@Autowired
	private MyDateUtil myDateUtil;
	
	@Autowired
	private LentBookService lentBookService;
	
	private List<Book> resultList;
	
	@RequestMapping(value = "/booksRegistry", method = RequestMethod.GET)
	public String getBookRegisrty(Model model){
		
		model.addAttribute("book", resultList);
				
		return "booksRegistry";
	}
	
	@RequestMapping(value = "/bookSearch", method = RequestMethod.POST)
	public String searchBook(Model model,  @RequestParam("bookSearchBar") String searchAttribute, @RequestParam("searchBookBy") String searchMethod){
		
		if(searchAttribute == null || searchAttribute.isEmpty()){
			resultList = null;
		}
		
		if(searchAttribute != null && !searchAttribute.isEmpty()){
			
			if(searchMethod.equals("name")){
				resultList = bookRegService.searchBookByName(searchAttribute);
				
			}else if(searchMethod.equals("isbn")){
				resultList = bookRegService.searchBookByIsbn(searchAttribute);
				
			}else if(searchMethod.equals("author")){
				resultList = bookRegService.searchBookByAuthor(searchAttribute);				
			}
		}	
						
		return "redirect:/booksRegistry";
	}
	
	@RequestMapping(value="/editBook/{bookId}", method = RequestMethod.GET)
	@Secured("ROLE_ADMIN")
	public String getEditBook(Model model, @PathVariable("bookId") Long bookId){
				
		model.addAttribute("book", bookRegService.searchBookById(bookId));
		
		return "editBook";
	}
	
	@RequestMapping(value="/editBook/{bookId}", method = RequestMethod.POST)
	@Secured("ROLE_ADMIN")
	public String postEditBook(Model model, @ModelAttribute("book") Book book ,@PathVariable("bookId") Long bookId){
		
		
		bookRegService.updateBook(book);
		
		return "redirect:/booksRegistry";
	}
	
	@RequestMapping(value ="/addBook", method = RequestMethod.GET)
	@Secured("ROLE_ADMIN")
	public String getAddBook(Model model){
		
		System.out.println("addBook get controller");
		return "addBook";
	}
	
	@RequestMapping(value ="/addBookSave", method = RequestMethod.POST)
	@Secured("ROLE_ADMIN")
	public String addBookSave(Model model, @ModelAttribute("book") Book book){
		
		bookRegService.saveNewBook(book);
	
		return "redirect:/booksRegistry";
	}
	
	@RequestMapping(value="/deleteBook/{bookId}", method = RequestMethod.POST)
	@Secured("ROLE_ADMIN")
	public String deleteBook(Model model, @ModelAttribute("book") Book book, 
			@PathVariable("bookId") Long bookId){	
		
		bookRegService.deleteBook(bookRegService.searchBookById(bookId));
		
		return "redirect:/booksRegistry";
	}
	
	@RequestMapping(value = "/lendBookDetails/{bookId}")
	public String getLendBookDetails(Model model, @PathVariable("bookId") Long bookId) throws InstantiationException, IllegalAccessException{
		
		//Date date = new Date();
		String modifiedDate= new SimpleDateFormat("yyyy-MM-dd").format(Date.class.newInstance());
		
		model.addAttribute("book", bookRegService.searchBookById(bookId));
		model.addAttribute("currentDate", modifiedDate);
		
		return "lendBookDetails";
	}
	
	@RequestMapping(value = "/lendBookDetails/{bookId}/saveLend")
	public String saveLendBookDetails(Model model, @PathVariable("bookId") Long bookId,
			@RequestParam("lendDays") int daysLent) throws InstantiationException, IllegalAccessException{
		
		lentBookService.addLentBook(bookRegService.searchBookById(bookId), new Date(), 
				myDateUtil.calculateDate(new SimpleDateFormat("yyyy-MM-dd").format(Date.class.newInstance()), daysLent));	
		
		return "redirect:/";
	}
	
//	/**
//	 * Method that parses the string data from the <b>dateReleased</b> input field in the <i>addBook.jsp</i> to 
//	 * {@link java.util.Date} so the correct format can be saved in the database.
//	 * 
//	 * </br>
//	 *  For more info : https://www.intertech.com/Blog/spring-frameworks-webdatabinder/
//	 * 
//	 * @param binder
//	 */
//	@InitBinder
//	public void dataBinding(WebDataBinder binder) {
//		
//		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//		dateFormat.setLenient(false);
//		binder.registerCustomEditor(Date.class, "dateReleased", new CustomDateEditor(dateFormat, true));
//	}
	
	
}
