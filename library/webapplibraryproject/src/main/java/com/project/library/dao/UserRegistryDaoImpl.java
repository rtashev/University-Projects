package com.project.library.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.StatelessSession;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.library.entities.User;

@Repository("userRegistryDao")
public class UserRegistryDaoImpl implements UserRegistryDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<User> findUserByName(String userName) {
		
		Criteria criteria = sessionFactory.openSession().createCriteria(User.class);		
		List<User> result  = criteria.add(Restrictions.like("name",userName, MatchMode.ANYWHERE)).list();
		
		return result;
	}

	@Override
	public User findUserById(Long id) {
		
		Criteria criteria = sessionFactory.openSession().createCriteria(User.class);
		User result = (User) criteria.add(Restrictions.like("userId", id)).list().get(0);
		
		return result;
	}
	
	@Transactional
	public void updateUser(User user) {
		
		StatelessSession session = sessionFactory.openStatelessSession();
		Transaction tx = session.beginTransaction();
		
		session.update(user);
		tx.commit();
		session.close();
	}

}
