package com.course.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

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
	public void AddCoursetype(Coursetype coursetype) {
		this.getSession().save(coursetype);
	}
	
	@Override
	public void deleteCoursetype(Coursetype coursetype){
		this.getSession().delete(coursetype);
	}
	
	@Override
	public void modifyCoursetype(Coursetype coursetype) {
		this.getSession().update(coursetype);
	}
	
}
