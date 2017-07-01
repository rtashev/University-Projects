package com.project.library.dao;

import java.util.List;

import com.project.library.entities.Book;
import com.project.library.entities.BooksLent;
import com.project.library.entities.User;

public interface LentBookDao {
	
	void addLentBook(BooksLent lentBook);
	
	List<BooksLent> getUsersActiveLents(User user);
	
	void returnBook(BooksLent lent);

	BooksLent getLent(User user, Book book);
}
