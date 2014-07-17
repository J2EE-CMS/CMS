package com.course.dao;

import org.hibernate.Query;
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
		String hql = "from Course as c where c.name=?";
		Query query = getSession().createQuery(hql);
		query.setString(0, course.getName());
		Course c = (Course)query.uniqueResult();
		c.setPlace(course.getPlace());
		c.setTime(course.getTime());
		c.setIsDegree(course.getIsDegree());
		getSession().update(c);
	}
	
	public void deleteCourse(Course course){
		String hql = "from Course as c where c.name=?";
		Query query = getSession().createQuery(hql);
		query.setString(0, course.getName());
		Course c = (Course)query.uniqueResult();
		getSession().delete(c);
	}
	
	public List<Course> findCourse(Course course){
		String hql = "from Course as c where c.name=? and c.place=?";
		Query query = getSession().createQuery(hql);
		query.setString(0, course.getName());
		query.setString(1, course.getPlace());
		List<Course> list = query.list();
		for(Course c:list){
			System.out.println(c.getTime());
		}
		return list;
		//return this.getHibernateTemplate().find("from Vip v where v.vname='"+course.getName()+"'");
		//return getSession().createQuery("from Course as c where c.name="+course.getName()+" and c.place="+course.getPlace()).list();
	}
	
	public List<Course> findAllCourse(){
		return getSession().createQuery("from Course").list();
	}
}
