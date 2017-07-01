package com.project.library.services;

import java.util.Date;
import java.util.List;

import com.project.library.entities.Book;
import com.project.library.entities.BooksLent;
import com.project.library.entities.User;

public interface LentBookService {
	
	void addLentBook(Book book, Date lentFrom, Date lentUntil);
	
	List<BooksLent> getUsersActiveLents(User user);
	
	void returnBook(User user, Book book);
}
