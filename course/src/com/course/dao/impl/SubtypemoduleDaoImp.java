package com.course.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
 
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;  

import com.course.dao.ISubtypemoduleDao;
import com.course.entity.Coursetype;
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
		else
			System.out.println("null");
	}
	
	@Override
	public void deleteSubtypemodule(Subtypemodule subtypemodule){
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Subtypemodule.class);
		criteria.add(Restrictions.eq("id", subtypemodule.getId()));
		subtypemodule = (Subtypemodule) criteria.uniqueResult();
		sessionFactory.getCurrentSession().delete(subtypemodule);
	}
	

	public void modifySubtypemodule(Subtypemodule subtypemodule) {
		//根据主键修改
		//getSession().clear();
		//sessionFactory.getCurrentSession().update(coursetype);
		
		//根据非主键修改，hql方法见梁炎的部分，这里改用Criteria
		//Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Coursetype.class);
		//criteria.add(Restrictions.eq("id", coursetype.getId()));
		
		Query query = sessionFactory.getCurrentSession().createQuery("from Subtypemodule where id=?");
		query.setInteger(0, subtypemodule.getId());
		Subtypemodule temp = (Subtypemodule )query.uniqueResult();
		temp.setSubtypemodule(subtypemodule);		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Subtypemodule> getAllSubtypemodules(){
		Query query = sessionFactory.getCurrentSession().createQuery("from Subtypemodule");
		return query.list();
	}
	
}
