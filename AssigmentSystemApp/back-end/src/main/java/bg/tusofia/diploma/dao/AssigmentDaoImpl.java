package bg.tusofia.diploma.dao;

import java.io.IOException;
import java.sql.Blob;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import bg.tusofia.diploma.entities.Assigment;
import bg.tusofia.diploma.entities.User;

//@Component
//@Transactional
@Repository
public class AssigmentDaoImpl implements AssigmentDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@PersistenceContext
	private EntityManager entityMangaer;
	
	@Override
	public List<Assigment> getAvailableAssigments() {
		Criteria criteria = sessionFactory.openSession().createCriteria(Assigment.class)
								.add(Restrictions.eq("isAssigned", false));
		List<Assigment> list = (List<Assigment>) criteria.list();
		return list;
	}

	@Override
	public Assigment getMyAssigment(Integer userId) {
		Criteria criteria = sessionFactory.openSession().createCriteria(Assigment.class)
								.createAlias("user", "u")
								.add(Restrictions.eq("u.userId", userId));
	
		
		Object result = criteria.uniqueResult();
		Assigment myAssigment = null;
		if (result != null) {
			myAssigment = (Assigment) result;
	    }		
		return myAssigment;
	}

	@Override
	public void saveAssigment(Assigment assigment) {
		Session session = sessionFactory.openSession();
		session.saveOrUpdate(assigment);
		session.flush();
		session.close();
		
	}
	
	@Override
	public List<Assigment> getSubmittedAssigments(){
		Criteria criteria = sessionFactory.openSession().createCriteria(Assigment.class)
				.add(Restrictions.eq("isSubmitted", true));
		List<Assigment> list = (List<Assigment>) criteria.list();
		return list;
	}

	@Override
	public Assigment getAssigmentById(Integer assigmentId) {
		Criteria criteria = sessionFactory.openSession().createCriteria(Assigment.class)
								.add(Restrictions.eq("assigmentId", assigmentId));

		Object result = criteria.uniqueResult();
		Assigment assigmentResult = null;
		if (result != null) {
			assigmentResult = (Assigment) result;
		}		
		return assigmentResult;
	}

	@Override
	public void submitMyAssigment(Assigment assigment, MultipartFile file) {
		
		Blob pdfBlob= null;
		
		try {
			pdfBlob = Hibernate.getLobCreator(sessionFactory.openSession()).createBlob(file.getBytes());
		} catch (HibernateException e) {
			System.err.println("Failed to create LOB file");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assigment.setPdf(pdfBlob);
		assigment.setIsSubmitted(true);
		
		this.saveAssigment(assigment);
		
	}
	//@Transactional
	@Override
	public void deleteAssigment(Integer id) {
		Session s = sessionFactory.openSession();
		String hql = "delete from Assigment where assigmentId= :id"; 
		s.createQuery(hql).setInteger("id", id).executeUpdate();
	}

	@Override
	public void takeAssigment(boolean isAssigned, User user, Integer assigmentId) {
		Session s = sessionFactory.openSession();
		String hql = "update Assigment set isAssigned=:isAssigned, user=:user where assigmentId= :id"; 
		s.createQuery(hql).setParameter("isAssigned", isAssigned).setParameter("user", user).setParameter("id", assigmentId).executeUpdate();
		
	}
	
	
	
}
