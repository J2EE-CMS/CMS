package com.course.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.course.entity.Courseapply;

public class CourseapplyDaoImp implements ICourseapplyDao {
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void addCourseapply (Courseapply courseapply) {
		//courseapply.setStatus(0);
		this.getSession().save(courseapply);
	}
	
	@Override
	public void modifyCourseapply(Courseapply courseapply) {
		Query query = sessionFactory.getCurrentSession().createQuery("from Courseapply where id=?");
		query.setInteger(0, courseapply.getId());
		Courseapply temp = (Courseapply)query.uniqueResult();
		temp.setCourseapply(courseapply);
	}
	
	@Override
	public void deleteCourseapply(Courseapply courseapply){
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Courseapply.class);
		criteria.add(Restrictions.eq("id", courseapply.getId()));
		courseapply = (Courseapply)criteria.uniqueResult();
		sessionFactory.getCurrentSession().delete(courseapply);
	}
	
	@Override
	public List<Courseapply> queryAllCourseapply() {
		//Query query = sessionFactory.getCurrentSession().createQuery("from Courseapply");
		//return query.list();
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Courseapply.class);
		criteria.add(Restrictions.or(Restrictions.eq("status", 0),Restrictions.eq("status", 1)));
		List<Courseapply> list = criteria.list();
		return list;
	}
	
	
	@Override
	public void commitCourseapply(Courseapply courseapply) {
		courseapply.setStatus(1);
	}
	
	
	/*
	@Override
	public List<Courseapply> queryCourseapply(Courseapply courseapply) {
		
	}
	*/
	
	/*  ========  审批      ========  */
	@Override
	public List<Courseapply> queryAllCourseapproval(){
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Courseapply.class);
		criteria.add(Restrictions.or(Restrictions.eq("status", 2),Restrictions.eq("status", 3)));
		List<Courseapply> list = criteria.list();
		return list;
	}
	
	@Override
	public void approvalCourseapply(Courseapply courseapply){
		if(courseapply.getStatus() == 1){
			courseapply.setStatus(courseapply.getStatus());
		}
	}
	
	/*
	@Override
	public List<Courseapply> queryCourseapproval(Courseapply courseapply)
	*/
}
