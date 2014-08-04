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
import com.course.entity.Course;
import com.course.entity.Courseapply;
import com.course.entity.Coursetype;
import com.course.entity.Subtype;
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
		Coursetype coursetype = new Coursetype();
		coursetype.setId(subtypemodule.getCourse_type());
		
		Subtype subtype = new Subtype();
		subtype.setId(subtypemodule.getSubtype_name());
		
		subtypemodule.setCoursetype(coursetype);
		subtypemodule.setSubtype(subtype);
		
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
		
		Criteria temp3 = sessionFactory.getCurrentSession().createCriteria(Course.class);
		temp3.add(Restrictions.eq("subtypemodule.id", subtypemodule.getId()));
		
		Criteria temp4 = sessionFactory.getCurrentSession().createCriteria(Courseapply.class);
		temp4.add(Restrictions.eq("subtypemodule.id", subtypemodule.getId()));
		
		if((temp3.list().size() == 0)  &&  (temp4.list().size() == 0)){
			sessionFactory.getCurrentSession().delete(subtypemodule);
		}
		
	}
	

	public void modifySubtypemodule(Subtypemodule subtypemodule) {
		//根据主键修改
		//getSession().clear();
		//sessionFactory.getCurrentSession().update(coursetype);
		
		//根据非主键修改，hql方法见梁炎的部分，这里改用Criteria
		//Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Coursetype.class);
		//criteria.add(Restrictions.eq("id", coursetype.getId()));
		getSession().clear();
		Coursetype coursetype = new Coursetype();
		coursetype.setId(subtypemodule.getCourse_type());
		
		Subtype subtype = new Subtype();
		subtype.setId(subtypemodule.getSubtype_name());
		
		subtypemodule.setCoursetype(coursetype);
		subtypemodule.setSubtype(subtype);
		
		getSession().update(subtypemodule);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Subtypemodule> getAllSubtypemodules(){
		Query query = sessionFactory.getCurrentSession().createQuery("from Subtypemodule");
		return query.list();
	}
	
}
