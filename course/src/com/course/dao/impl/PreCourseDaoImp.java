package com.course.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
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
	public boolean addPreCourse(PreCourse pcos) {
		Criteria crit = getSession().createCriteria(Course.class);
		crit.add(Restrictions.eq("id", pcos.getCourse()));
		if (crit.uniqueResult() != null) {
			Course cos = new Course();
			cos.setId(pcos.getCourse());
			pcos.setCos(cos);

			getSession().save(pcos);
			return true;
		}
		return false;
	}

	// @Override
	// public void modifyPreCourse(PreCourse pcos) {

	// }

	@Override
	public void deletePreCourse(Course cos) {
		Criteria crit = getSession().createCriteria(PreCourse.class);
		crit.add(Restrictions.eq("cos.id", cos.getId()));
		List<PreCourse> list = crit.list();
		for (PreCourse pcos : list) {
			getSession().delete(pcos);
		}
	}

	@Override
	public List<PreCourse> queryPreCourse(Course cos) {
		Criteria crit = getSession().createCriteria(PreCourse.class);
		crit.addOrder(Order.asc("id"));

		if (cos != null) {
			crit.add(Restrictions.eq("cos.id", cos.getId()));
		}
		List<PreCourse> list = crit.list();
		return list;
	}

	@Override
	public List<PreCourse> queryAllPreCourseRelations() {
		Criteria crit = getSession().createCriteria(PreCourse.class);
		crit.addOrder(Order.asc("id"));
		List<PreCourse> list = crit.list();
		return list;
	}

	@Override
	public void approvePreCourse(Course cos, int isApprove) {
		Criteria crit = getSession().createCriteria(PreCourse.class);
		if (cos != null) {
			crit.add(Restrictions.eq("cos.id", cos.getId()));
		}
		List<PreCourse> list = crit.list();
		System.out.println(" "+ list.size()+" "+ isApprove);
		for(PreCourse pcos : list){
			pcos.setStatus(isApprove);
			getSession().update(pcos);
		}
	}

}
