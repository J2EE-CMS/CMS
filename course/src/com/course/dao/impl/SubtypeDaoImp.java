package com.course.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
 


import com.course.dao.ISubtypeDao;
import com.course.entity.Coursetype;
import com.course.entity.Subtype;

public class SubtypeDaoImp implements ISubtypeDao {

	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void addSubtype(Subtype subtype) {
		Coursetype coursetype = new Coursetype();
		coursetype.setId(subtype.getBelongtotype());
		
		subtype.setCoursetype(coursetype);
		getSession().save(subtype);
		
		/*
		String hql = "from Subtype as subtype where subtype.id=?";
		Query query = getSession().createQuery(hql);
		query.setInteger(0, 1);

		Subtype sub = (Subtype) query.uniqueResult();
		System.out.println(sub.getCoursetype().getQuality());
		*/
	}
	
	@Override
	public void deleteSubtype(Subtype subtype){
		getSession().delete(subtype);
	}
	
	@Override
	public void modifySubtype(Subtype subtype) {
		//getSession().clear();
		Coursetype coursetype = new Coursetype();
		coursetype.setId(subtype.getBelongtotype());
		
		subtype.setCoursetype(coursetype);
		getSession().update(subtype);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Subtype> getAllSubtypes(){
		String hql = "from Subtype";
		Query query = getSession().createQuery(hql);
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Subtype> findBySubtypename(String name){ 
		String hql = "from Subtype where subtypename like ?";
		Query query = getSession().createQuery(hql);
		query.setString(0, "%"+name+"%");
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Subtype> findByBelongtotype(String name){ 
		String hql = "from Subtype where belongtotype like ?";
		Query query = getSession().createQuery(hql);
		query.setString(0, "%"+name+"%");
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Subtype> findByDepartment(String name){ 
		String hql = "from Subtype where department like ?";
		Query query = getSession().createQuery(hql);
		query.setString(0, "%"+name+"%");
		return query.list();
	}
	
}
