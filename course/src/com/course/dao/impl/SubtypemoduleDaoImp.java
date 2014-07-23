package com.course.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
 
import org.springframework.transaction.annotation.Transactional;  

import com.course.dao.ISubtypemoduleDao;
import com.course.entity.Subtypemodule;

public class SubtypemoduleDaoImp implements ISubtypemoduleDao {

	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void addSubtypemodule(Subtypemodule subtypemodule) {
		if(subtypemodule != null){
			this.getSession().save(subtypemodule);
		}
		System.out.println("null");
	}
	
	@Override
	public void deleteSubtypemodule(Integer id){
		//getSession().clear();
		//sessionFactory.getCurrentSession().delete(subtypemodule);
		Subtypemodule subtypemodule = (Subtypemodule)sessionFactory.getCurrentSession().get(Subtypemodule.class, id);
		sessionFactory.getCurrentSession().delete(subtypemodule);
	}
	
	@Override
	public void modifySubtypemodule(Subtypemodule subtypemodule) {
		getSession().clear();
		sessionFactory.getCurrentSession().update(subtypemodule);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Subtypemodule> getAllSubtypemodules(){
		Query query = sessionFactory.getCurrentSession().createQuery("from Subtypemodule");
		return query.list();
	}
	
}
