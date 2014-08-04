package com.course.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
 


import org.hibernate.criterion.Restrictions;

import com.course.dao.ISubtypeDao;
import com.course.entity.Course;
import com.course.entity.Courseapply;
import com.course.entity.Coursetype;
import com.course.entity.Subtype;
import com.course.entity.Subtypemodule;

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
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Subtype.class);
		criteria.add(Restrictions.eq("id", subtype.getId()));
		subtype = (Subtype)criteria.uniqueResult();
		
		Criteria temp2 = sessionFactory.getCurrentSession().createCriteria(Subtypemodule.class);
		temp2.add(Restrictions.eq("subtype.id", subtype.getId()));
		
		Criteria temp3 = sessionFactory.getCurrentSession().createCriteria(Course.class);
		temp3.add(Restrictions.eq("subtype.id", subtype.getId()));
		
		Criteria temp4 = sessionFactory.getCurrentSession().createCriteria(Courseapply.class);
		temp4.add(Restrictions.eq("subtype.id", subtype.getId()));
		
		//if(temp3.list() != null)
		//	System.out.println("error");
		
		if((temp2.list().size() == 0)  &&  (temp3.list().size() == 0)  &&  (temp4.list().size() == 0)){
			getSession().delete(subtype);
		}
		
	}
	
	@Override
	public void modifySubtype(Subtype subtype) {
		getSession().clear();
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
