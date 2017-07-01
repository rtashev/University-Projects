package com.project.library.dao;

import java.util.List;

import com.project.library.entities.Book;

public interface BookDao {
	
	List<Book> searchBookByAuthor(String bookAuthor);
	
	List<Book> searchBookByName(String bookName);
	
	List<Book> searchBookByIsbn(String bookIsbn);
	
	Book searchBookById(Long bookId);
	
	void saveNewBook(Book book);

	void updateBook(Book book);

	void deleteBook(Book book);
}
