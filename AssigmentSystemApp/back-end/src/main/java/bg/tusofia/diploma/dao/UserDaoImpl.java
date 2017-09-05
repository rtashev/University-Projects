package bg.tusofia.diploma.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bg.tusofia.diploma.entities.User;


@Component
public class UserDaoImpl implements UserDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public User getUser(String username, String password) {
		Criteria criteria = sessionFactory.openSession().createCriteria(User.class)
							.add(Restrictions.eq("name", username))
							.add(Restrictions.eq("password", password));
		
		Object result = criteria.uniqueResult();
		User user = null;
		if (result != null) {
	        user = (User) result;
	    }
	    
		return user;
	}

	@Override
	public User getUserById(Integer id) {
		Criteria criteria = sessionFactory.openSession().createCriteria(User.class)
				.add(Restrictions.eq("userId", id));

		Object result = criteria.uniqueResult();
		User user = null;
		if (result != null) {
			user = (User) result;
		}

		return user;
	}

	@Override
	public void updateUser(User user) {
		Session s = sessionFactory.openSession();
		String hql = "update User set hasAssigment = :hasAssigment where userId = :id";
		s.createQuery(hql).setParameter("hasAssigment", user.getHasAssigment()).setParameter("id", user.getUserId().intValue()).executeUpdate();
	}
	
}