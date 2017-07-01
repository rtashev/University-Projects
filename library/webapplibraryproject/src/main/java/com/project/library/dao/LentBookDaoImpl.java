package com.project.library.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.library.entities.Book;
import com.project.library.entities.BooksLent;
import com.project.library.entities.User;

@Repository("LentBookDao")
public class LentBookDaoImpl implements LentBookDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addLentBook(BooksLent lentBook) {
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		session.save(lentBook);
		tx.commit();
		session.close();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BooksLent> getUsersActiveLents(User user) {
		
		Criteria criteria = sessionFactory.openSession().createCriteria(BooksLent.class, "booksLent");
		criteria.add(Restrictions.eq("user", user));
		criteria.add(Restrictions.eq("bookReturned", Boolean.FALSE));
		List<BooksLent> result = criteria.list();
		
//		.createCriteria(YourEntity.class, "y")
//	      .createAlias("someMember", "s")
//	      .add(Restrictions.eq("y.name", someArgument));  // no more confusion
		
		return result;
	}

	@Override
	public void returnBook(BooksLent lent) {
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		session.update(lent);
		tx.commit();
		session.close();
		
		
	}

	@Override
	public BooksLent getLent(User user, Book book) {
		Criteria criteria = sessionFactory.openSession().createCriteria(BooksLent.class, "booksLent");
		criteria.add(Restrictions.eq("user", user));
		criteria.add(Restrictions.eq("book", book));
		criteria.add(Restrictions.eq("bookReturned", Boolean.FALSE));
		return (BooksLent) criteria.list().get(0);
	}

}
