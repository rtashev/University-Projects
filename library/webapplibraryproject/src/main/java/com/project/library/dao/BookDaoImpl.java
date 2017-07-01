package com.project.library.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.StatelessSession;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.library.entities.Book;

@Repository("BookDao")
public class BookDaoImpl implements BookDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Book> searchBookByAuthor(String bookAuthor) {
		
		Criteria criteria = sessionFactory.openSession().createCriteria(Book.class);		
		List<Book> result  = criteria.add(Restrictions.like("author",bookAuthor, MatchMode.ANYWHERE)).list();
		
		return result;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Book> searchBookByName(String bookName) {
		
		Criteria criteria = sessionFactory.openSession().createCriteria(Book.class);		
		List<Book> result  = criteria.add(Restrictions.like("name",bookName, MatchMode.ANYWHERE)).list();
		
		return result;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Book> searchBookByIsbn(String bookIsbn) {
		
		Criteria criteria = sessionFactory.openSession().createCriteria(Book.class);		
		List<Book> result  = criteria.add(Restrictions.like("isbn",bookIsbn, MatchMode.ANYWHERE)).list();
		
		return result;
	}

	@Override
	public Book searchBookById(Long bookId) {
		
		Criteria criteria = sessionFactory.openSession().createCriteria(Book.class);
		Book book = (Book) criteria.add(Restrictions.idEq(bookId)).list().get(0);
		
		return book;
	}

	
	@Override
	public void saveNewBook(Book book) {
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		session.save(book);
		tx.commit();
		session.close();
		
	}

	@Override
	public void updateBook(Book book) {
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		session.update(book);
		tx.commit();
		session.close();
		
	}
	
	@Transactional
	@Override
	public void deleteBook(Book book) {
		
		StatelessSession session = sessionFactory.openStatelessSession();
		Transaction tx = session.beginTransaction();
		
		session.delete(book);
		tx.commit();
		session.close();
		
	}
	
	
}
