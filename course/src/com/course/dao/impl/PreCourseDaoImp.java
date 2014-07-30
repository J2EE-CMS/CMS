package com.course.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.course.dao.IPreCourseDao;
import com.course.entity.Course;
import com.course.entity.PreCourse;

public class PreCourseDaoImp implements IPreCourseDao {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void addPreCourse(PreCourse pcos) {
		getSession().save(pcos);
	}

	// @Override
	// public void modifyPreCourse(PreCourse pcos) {

	// }

	@Override
	public void deletePreCourse(Course cos) {
		Criteria crit = getSession().createCriteria(PreCourse.class);
		crit.add(Restrictions.eq("course", cos.getId()));
		List<PreCourse> list = crit.list();
		for (PreCourse pcos : list) {
			getSession().delete(pcos);
		}
	}

	@Override
	public List<PreCourse> queryPreCourse(Course cos) {
		Criteria crit = getSession().createCriteria(PreCourse.class);
		if (cos != null) {
			crit.add(Restrictions.eq("course", cos.getId()));
		}
		List<PreCourse> list = crit.list();
		return list;
	}

	@Override
	public List<PreCourse> queryAllPreCourseRelations() {
		Criteria crit = getSession().createCriteria(PreCourse.class);
		List<PreCourse> list = crit.list();
		return list;
	}

}
