package com.course.dao.impl;

import java.io.InputStream;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
 

import org.hibernate.criterion.Restrictions;

import com.course.dao.ICoursetypeDao;
import com.course.entity.Course;
import com.course.entity.Courseapply;
import com.course.entity.Coursetype;
import com.course.entity.PreCourse;
import com.course.entity.Subtype;
import com.course.entity.Subtypemodule;

public class CoursetypeDaoImp implements ICoursetypeDao {
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void addCoursetype(Coursetype coursetype) {
		getSession().save(coursetype);
		getSession().flush();
	}
	
	@Override
	public void deleteCoursetype(Coursetype coursetype){
		//������������ ʱ������ʹ��get()��load()���� 
		//Coursetype coursetype = (Coursetype)sessionFactory.getCurrentSession().get(Coursetype.class, id);
		//sessionFactory.getCurrentSession().delete(coursetype);
		
		//���ݷ���������ʱ��ʹ��hql/Criteria
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Coursetype.class);
		criteria.add(Restrictions.eq("id", coursetype.getId()));
		//criteria.add(Restrictions.eq("type", type));
		
		coursetype = (Coursetype)criteria.uniqueResult();
				
		Criteria temp1 = sessionFactory.getCurrentSession().createCriteria(Subtype.class);
		temp1.add(Restrictions.eq("coursetype.id", coursetype.getId()));

		Criteria temp2 = sessionFactory.getCurrentSession().createCriteria(Subtypemodule.class);
		temp2.add(Restrictions.eq("coursetype.id", coursetype.getId()));
		
		Criteria temp3 = sessionFactory.getCurrentSession().createCriteria(Course.class);
		temp3.add(Restrictions.eq("coursetype.id", coursetype.getId()));
		
		Criteria temp4 = sessionFactory.getCurrentSession().createCriteria(Courseapply.class);
		temp4.add(Restrictions.eq("coursetype.id", coursetype.getId()));
		
		if((temp1.list().size() == 0)  &&  (temp2.list().size() == 0)  &&  (temp3.list().size() == 0)  &&  (temp4.list().size() == 0)){
			sessionFactory.getCurrentSession().delete(coursetype);
		}
	}
	
	
	@Override
	public void modifyCoursetype(Coursetype coursetype) {
		//���������޸�
		//getSession().clear();
		//sessionFactory.getCurrentSession().update(coursetype);
		
		//���ݷ������޸ģ�hql���������׵Ĳ��֣��������Criteria
		//Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Coursetype.class);
		//criteria.add(Restrictions.eq("id", coursetype.getId()));
		
		Query query = sessionFactory.getCurrentSession().createQuery("from Coursetype where id=?");
		query.setInteger(0, coursetype.getId());
		Coursetype costype = (Coursetype )query.uniqueResult();
		costype.setCoursetype(coursetype);		
	}
	
	@Override
	public List<Coursetype> getAllCoursetypes(){
		Query query = sessionFactory.getCurrentSession().createQuery("from Coursetype");
		return query.list();
	}

}
