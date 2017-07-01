package com.project.library.services;

import java.util.List;

import com.project.library.entities.Book;

public interface BookRegistryService {
	
	List<Book> searchBookByAuthor(String bookAuthor);
	
	List<Book> searchBookByIsbn(String bookIsbn);
	
	List<Book> searchBookByName(String bookName);
	
	Book searchBookById(Long bookId);
	
	void saveNewBook(Book book);

	void updateBook(Book book);

	void deleteBook(Book book);
	
}
