package com.course.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
 
import org.springframework.transaction.annotation.Transactional;  

import com.course.entity.Coursetype;

public class CoursetypeDaoImp implements ICoursetypeDao {

	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void addCoursetype(Coursetype coursetype) {
		this.getSession().persist(coursetype);
	}
	
	@Override
	public void deleteCoursetype(Integer id){
		//getSession().clear();
		//sessionFactory.getCurrentSession().delete(coursetype);
		Coursetype coursetype = (Coursetype)sessionFactory.getCurrentSession().get(Coursetype.class, id);
		sessionFactory.getCurrentSession().delete(coursetype);
	}
	
	@Override
	public void modifyCoursetype(Coursetype coursetype) {
		getSession().clear();
		sessionFactory.getCurrentSession().update(coursetype);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Coursetype> getAllCoursetypes(){
		Query query = sessionFactory.getCurrentSession().createQuery("from Coursetype");
		return query.list();
	}
	
}
