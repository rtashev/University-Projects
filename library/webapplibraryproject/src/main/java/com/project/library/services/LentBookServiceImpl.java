package com.project.library.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.project.library.dao.LentBookDao;
import com.project.library.dao.UserDao;
import com.project.library.entities.Book;
import com.project.library.entities.BooksLent;
import com.project.library.entities.User;

@Service
public class LentBookServiceImpl implements LentBookService{
	
	@Autowired
	private LentBookDao lentBookDao;
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public void addLentBook(Book book, Date lentFrom, Date lentUntil) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		User user = userDao.getUserByName(currentPrincipalName);
		
		if(checkIfLendAlreadyExists(book, user)){
			
			System.out.println("Lent already exists");
			
		}else{
			System.out.println("Lent doesnt exist");
			BooksLent generatedLent = new BooksLent(); 
			generatedLent.setUser(user);
			generatedLent.setBook(book);
			generatedLent.setLentFrom(lentFrom);
			generatedLent.setLentUntil(lentUntil);
			generatedLent.setBookReturned(false);
			
			lentBookDao.addLentBook(generatedLent);
		
		}
				
	}
	
	private boolean checkIfLendAlreadyExists(Book book, User user){
		
		List<BooksLent> bookslent = lentBookDao.getUsersActiveLents(user);
		
		for (BooksLent bookLent : bookslent) {
			if (bookLent.getBook().getBookId().equals(book.getBookId())) {
				return true;
			}
		}
		
		/*
		 *     PROVERI DAO-to + ENTITY-tata za shitnite koito dobavi
		 */
		
		return false;
	}

	@Override
	public List<BooksLent> getUsersActiveLents(User user) {
				
		return lentBookDao.getUsersActiveLents(user);
	}

	@Override
	public void returnBook(User user, Book book) {
		
		BooksLent lent = lentBookDao.getLent(user, book);
		System.out.println(lent.getLentId());
		//System.out.println(lent.getBook());
		System.out.println(lent.getUser());
		System.out.println("\n\n\n\n" + lent.isBookReturned() + "\n\n\n\n");
		lent.setBookReturned(true);
		
		lentBookDao.returnBook(lent);
	}
	
	
}
