package com.project.library.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.library.entities.User;

@Repository("UserDao")
public class UserDaoImpl implements UserDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	@SuppressWarnings("unchecked")
	public List<User> getAllUsers() {
		
		Criteria criteria = sessionFactory.openSession().createCriteria(User.class);
		List<User> result = criteria.list();
		//sessionFactory.close();
		
		return result;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public User getUserByName(String username) {
		
		Criteria criteria = sessionFactory.openSession().createCriteria(User.class);		
		List<User> result  = criteria.add(Restrictions.eq("name",username)).list();
		//sessionFactory.close();
		System.out.println(result.get(0).toString());
		return result.get(0);
	}

	@Override
	@Transactional
	public void addNewUser(User user) {
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		session.save(user);
		tx.commit();
		session.close();
		
	}
	

}
