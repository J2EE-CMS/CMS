package com.course.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.util.List;
import org.hibernate.sql.*;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.course.entity.Course;

public class CourseDaoImp implements ICourseDao{
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void addCourse(Course course){
		getSession().save(course);
	}
	
	@Override
	public void modifyCourse(Course course){
		getSession().update(course);
	}
	
	public void deleteCourse(Course course){
		getSession().delete(course);
	}
	
	public List<Course> findCourse(Course course){
		//return this.getHibernateTemplate().find("from Vip v where v.vname='"+course.getName()+"'");
		return getSession().createQuery("from Course c where c.name='"+course.getName()+"' and c.place='"+course.getPlace()+"'").list();
	}
	
	public List<Course> findAllCourse(){
		return getSession().createQuery("from Course").list();
	}
}
