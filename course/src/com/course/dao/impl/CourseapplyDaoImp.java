package com.course.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.course.dao.ICourseapplyDao;
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
		courseapply.setStatus(0);
		this.getSession().save(courseapply);
	}
	
	@Override
	public void modifyCourseapply(Courseapply courseapply) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Courseapply.class);
		criteria.add(Restrictions.eq("c_course_name", courseapply.getC_course_name()));
		Courseapply temp = (Courseapply)criteria.uniqueResult();
		temp.setStatus(0);
		temp.setCourseapply(courseapply);
		sessionFactory.getCurrentSession().update(temp);
	}
	
	@Override
	public void deleteCourseapply(Courseapply courseapply){
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Courseapply.class);
		criteria.add(Restrictions.eq("c_course_name", courseapply.getC_course_name()));
		courseapply = (Courseapply)criteria.uniqueResult();
		sessionFactory.getCurrentSession().delete(courseapply);
	}
	
	@Override
	public List<Courseapply> queryAllCourseapply() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Courseapply.class);
		criteria.add(Restrictions.or(Restrictions.eq("status", 0),Restrictions.eq("status", 1)));
		List<Courseapply> list = criteria.list();
		return list;
	}
	
	
	@Override
	public void modifycommitCourseapply(Courseapply courseapply) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Courseapply.class);
		criteria.add(Restrictions.eq("c_course_name", courseapply.getC_course_name()));
		Courseapply temp = (Courseapply)criteria.uniqueResult();
		//temp.setStatus(1);
		//temp.setCourseapply(courseapply);
		if(temp != null){
			/*temp.setInstitute_course_id(courseapply.getInstitute_course_id());
			temp.setC_course_name(courseapply.getC_course_name());
			temp.setE_course_name(courseapply.getE_course_name());
			temp.setBrief_course_name(courseapply.getBrief_course_name());
			temp.setFaculty(courseapply.getFaculty());
			temp.setCredit(courseapply.getCredit());
			temp.setSub_course_type_module(courseapply.getSub_course_type_module());
			temp.setSub_course_type(courseapply.getSub_course_type());
			temp.setCourse_type(courseapply.getCourse_type());
			temp.setCourse_time(courseapply.getCourse_time());
			temp.setCourse_time_info(courseapply.getCourse_time_info());
			temp.setCourse_info(courseapply.getCourse_info());
			temp.setCourse_head(courseapply.getCourse_head());
			temp.setDegree(courseapply.isDegree());*/
			temp.setStatus(1);
		}
		System.out.println(temp.getId()+" "+temp.getBrief_course_name()+"  "+temp.getStatus());
		getSession().update(temp);
	}
	

	@Override
	public List<Courseapply> queryCourseapply(Courseapply courseapply) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Courseapply.class);
		
		if(courseapply.getInstitute_course_id() != 0){
			criteria.add(Restrictions.eq("institute_course_id", courseapply.getInstitute_course_id()));
		}
		
		if(courseapply.getC_course_name()!=null && !courseapply.getC_course_name().equals("")){
			criteria.add(Restrictions.eq("c_course_name", courseapply.getC_course_name()));
		}
		
		if(courseapply.getE_course_name()!=null && !courseapply.getE_course_name().equals("")){
			criteria.add(Restrictions.eq("e_course_name", courseapply.getE_course_name()));
		}
		
		if(courseapply.getBrief_course_name() !=null && !courseapply.getBrief_course_name().equals("")){
			criteria.add(Restrictions.eq("brief_course_name", courseapply.getBrief_course_name()));
		}
		
		if(courseapply.getFaculty()!=null && !courseapply.getFaculty().equals("")){
			criteria.add(Restrictions.eq("faculty", courseapply.getFaculty()));
		}
		
		if(courseapply.getCredit() != 0){
			criteria.add(Restrictions.eq("credit", courseapply.getFaculty()));
		}
		
		if(courseapply.getCourse_type() != 0){
			criteria.add(Restrictions.eq("course_type", courseapply.getCourse_type()));
		}
		
		if(courseapply.getSub_course_type() != 0){
			criteria.add(Restrictions.eq("sub_course_type", courseapply.getSub_course_type()));
		}
		
		if(courseapply.getSub_course_type_module() != 0){
			criteria.add(Restrictions.eq("sub_course_type_module", courseapply.getSub_course_type_module()));
		}
		
		criteria.add(Restrictions.or(Restrictions.eq("status", 0),Restrictions.eq("status", 1)));
		
		List<Courseapply> list = criteria.list();
		return list;
		
	}
	
	/*  ========  审批      ========  */
	@Override
	public List<Courseapply> queryAllCourseapproval(){
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Courseapply.class);
		criteria.add(Restrictions.or(Restrictions.eq("status", 2),Restrictions.eq("status", 3)));
		List<Courseapply> list = criteria.list();
		return list;
	}
	
	@Override
	public void modifyapprovalCourseapply(Courseapply courseapply){
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Courseapply.class);
		criteria.add(Restrictions.eq("c_course_name", courseapply.getC_course_name()));
		Courseapply temp = (Courseapply)criteria.uniqueResult();
		if(temp != null){
			temp.setStatus(courseapply.getStatus());
		}
		getSession().update(temp);
	}
	
	
	@Override
	public List<Courseapply> queryCourseapproval(Courseapply courseapply){
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Courseapply.class);
		
		if(courseapply.getInstitute_course_id() != 0){
			criteria.add(Restrictions.eq("institute_course_id", courseapply.getInstitute_course_id()));
		}
		
		if(courseapply.getC_course_name()!=null && !courseapply.getC_course_name().equals("")){
			criteria.add(Restrictions.eq("c_course_name", courseapply.getC_course_name()));
		}
		
		if(courseapply.getE_course_name()!=null && !courseapply.getE_course_name().equals("")){
			criteria.add(Restrictions.eq("e_course_name", courseapply.getE_course_name()));
		}
		
		if(courseapply.getBrief_course_name() !=null && !courseapply.getBrief_course_name().equals("")){
			criteria.add(Restrictions.eq("brief_course_name", courseapply.getBrief_course_name()));
		}
		
		if(courseapply.getFaculty()!=null && !courseapply.getFaculty().equals("")){
			criteria.add(Restrictions.eq("faculty", courseapply.getFaculty()));
		}
		
		if(courseapply.getCredit() != 0){
			criteria.add(Restrictions.eq("credit", courseapply.getFaculty()));
		}
		
		if(courseapply.getCourse_type() != 0){
			criteria.add(Restrictions.eq("course_type", courseapply.getCourse_type()));
		}
		
		if(courseapply.getSub_course_type() != 0){
			criteria.add(Restrictions.eq("sub_course_type", courseapply.getSub_course_type()));
		}
		
		if(courseapply.getSub_course_type_module() != 0){
			criteria.add(Restrictions.eq("sub_course_type_module", courseapply.getSub_course_type_module()));
		}
		
		criteria.add(Restrictions.or(Restrictions.eq("status", 2),Restrictions.eq("status", 3)));
		
		List<Courseapply> list = criteria.list();
		if(list != null)
			System.out.println("error");
		return list;
	}
	
}
