package com.coursemanage.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.coursemanage.entity.Course;

public class CourseDaoImp implements ICourseDao{
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void AddCourse(Course cos) {
		System.out.println("------CourseDaoImp.AddCourse------"+cos.getC_course_name());
		getSession().save(cos);
			
	}

	@Override
	public void modifyCourse(Course cos) {
		System.out.println("------CourseDaoImp.modifyCourse------");
		
		String hql = "from Course as course where course.id=?";
		Query query = getSession().createQuery(hql);
		query.setInteger(0, cos.getId());
		
		List<Course> list=query.list();
		for(Course c : list){
			c.setC_course_name(cos.getC_course_name());;
			getSession().update(c);
		}
	}

	@Override
	public void deleteCourse(Course cos) {
		System.out.println("------CourseDaoImp.deleteCourse------");
		String hql = "from Course as course where course.id=?";
		Query query = getSession().createQuery(hql);
		query.setInteger(0, cos.getId());
		
		Course c = (Course) query.uniqueResult();
		getSession().delete(c);
	}

	@Override
	public void queryCourse(Course cos) {
		System.out.println("------CourseDaoImp.queryCourse------");
		String hql = "from Course as course where course.c_course_name=?";
		Query query = getSession().createQuery(hql);
		System.out.println(cos.getC_course_name());
		query.setString(0, cos.getC_course_name());
		List<Course> list = query.list();
		for(Course c : list){
			System.out.println(c.getBrief_course_name()+"  "+c.getC_course_name()+"  "
		                      +c.getE_course_name());
		}
	}
}
 