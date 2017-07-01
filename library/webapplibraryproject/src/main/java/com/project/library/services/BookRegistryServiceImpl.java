package com.project.library.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.library.dao.BookDao;
import com.project.library.entities.Book;

@Service("bookRegistryService")
public class BookRegistryServiceImpl implements BookRegistryService{

	@Autowired
	BookDao bookDao;
	
	@Override
	public List<Book> searchBookByAuthor(String bookAuthor) {
			
		return bookDao.searchBookByAuthor(bookAuthor);
	}

	@Override
	public List<Book> searchBookByIsbn(String bookIsbn) {
		
		return bookDao.searchBookByIsbn(bookIsbn);
	}

	@Override
	public List<Book> searchBookByName(String bookName) {
	
		return bookDao.searchBookByName(bookName);
	}
	
	@Override
	public Book searchBookById(Long bookId) {
		
		return bookDao.searchBookById(bookId);
	}

	@Override
	public void saveNewBook(Book book) {
		
		bookDao.saveNewBook(book);
	}

	@Override
	public void updateBook(Book book) {

		bookDao.updateBook(book);		
	}

	@Override
	public void deleteBook(Book book) {

		bookDao.deleteBook(book);		
	}
	
	

	
}
