package com.course.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.course.dao.ICourseapplyDao;
import com.course.entity.Course;
import com.course.entity.Courseapply;
import com.course.entity.Coursetype;
import com.course.entity.Subtype;
import com.course.entity.Subtypemodule;

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
		Coursetype coursetype = new Coursetype();
		if(courseapply.getSub_course_type() == 0)
			courseapply.setSub_course_type(-1);
		coursetype.setId(courseapply.getCourse_type());
		
		Subtype subtype = new Subtype();
		if(courseapply.getSub_course_type() == 0)
			courseapply.setSub_course_type(-1);
		subtype.setId(courseapply.getSub_course_type());
		
		Subtypemodule subtypemodule = new Subtypemodule();
		if(courseapply.getSub_course_type_module() == 0)
			courseapply.setSub_course_type_module(-1);
		subtypemodule.setId(courseapply.getSub_course_type_module());
		
		courseapply.setCoursetype(coursetype);
		courseapply.setSubtype(subtype);
		courseapply.setSubtypemodule(subtypemodule);
		
		courseapply.setStatus("未提交");
		this.getSession().save(courseapply);
	}
	
	@Override
	public void modifyCourseapply(Courseapply courseapply) {
		/*Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Courseapply.class);
		criteria.add(Restrictions.eq("c_course_name", courseapply.getC_course_name()));
		Courseapply temp = (Courseapply)criteria.uniqueResult();
		temp.setCourseapply(courseapply);
		sessionFactory.getCurrentSession().update(temp);*/
		Coursetype coursetype = new Coursetype();
		coursetype.setId(courseapply.getCourse_type());
		
		Subtype subtype = new Subtype();
		if(courseapply.getSub_course_type() == 0)
			courseapply.setSub_course_type(-1);
		subtype.setId(courseapply.getSub_course_type());
		
		Subtypemodule subtypemodule = new Subtypemodule();
		if(courseapply.getSub_course_type_module() == 0)
			courseapply.setSub_course_type_module(-1);
		subtypemodule.setId(courseapply.getSub_course_type_module());
		
		courseapply.setCoursetype(coursetype);
		courseapply.setSubtype(subtype);
		courseapply.setSubtypemodule(subtypemodule);
		
		courseapply.setStatus("未提交");
		//c.setInfo(cos.getInfo());
		getSession().update(courseapply);
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
		//criteria.add(Restrictions.or(Restrictions.eq("status", "未提交"),Restrictions.eq("status", "审批不通过"),Restrictions.eq("status", "审批通过")));
		List<Courseapply> list = criteria.list();
		return list;
	}
	
	
	@Override
	public void modifycommitCourseapply(Courseapply courseapply) {
		
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Courseapply.class);
		criteria.add(Restrictions.eq("id", courseapply.getId()));
		Courseapply temp = (Courseapply)criteria.uniqueResult();
		//temp.setStatus(1);
		//temp.setCourseapply(courseapply);
		if(temp != null){
			
			temp.setStatus("待审批");
		}
		System.out.println(temp.getId()+" "+temp.getBrief_course_name()+"  "+temp.getStatus());
				
		getSession().update(temp);
	}

	
	@Override
	public List<Courseapply> queryCourseapply(Courseapply courseapply) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Courseapply.class);
		
		/*
		if (begin_time != null) {
			criteria.add(Restrictions.ge("approval_time", begin_time));
		}
		if (end_time != null) {
			criteria.add(Restrictions.le("approval_time", end_time));
		}*/
		if (courseapply.getInstitute_course() != 0) {
			criteria.add(Restrictions.eq("institute_course",
					courseapply.getInstitute_course()));
		}
		if (courseapply.getC_course_name() != null
				&& !courseapply.getC_course_name().equals("")) {
			criteria.add(Restrictions.eq("c_course_name", courseapply.getC_course_name()));
		}
		if (courseapply.getE_course_name() != null
				&& !courseapply.getE_course_name().equals("")) {
			criteria.add(Restrictions.eq("e_course_name", courseapply.getE_course_name()));
		}
		if (courseapply.getBrief_course_name() != null
				&& !courseapply.getBrief_course_name().equals("")) {
			criteria.add(Restrictions.eq("brief_course_name",
					courseapply.getBrief_course_name()));
		}
		if (courseapply.getFaculty() != null && !courseapply.getFaculty().equals("")) {
			criteria.add(Restrictions.eq("faculty", courseapply.getFaculty()));
		}
		if (courseapply.getCredit() != 0) {
			criteria.add(Restrictions.eq("credit", courseapply.getCredit()));
		}
		if (courseapply.getCourse_type() != 0) {
			criteria.add(Restrictions.eq("coursetype.id", courseapply.getCourse_type()));
		}
		if (courseapply.getSub_course_type() != 0) {
			criteria.add(Restrictions.eq("subtype.id",
					courseapply.getSub_course_type()));
		}
		if (courseapply.getSub_course_type_module() != 0) {
			criteria.add(Restrictions.eq("subtypemodule.id",
					courseapply.getSub_course_type_module()));
		}
		//criteria.add(Restrictions.or(Restrictions.eq("status", "未提交"),Restrictions.eq("status", "审批不通过"),Restrictions.eq("status", "审批通过")));

		List<Courseapply> list = criteria.list();
		return list;

	}

	
	
	/*  ========  瀹℃壒      ========  */
	@Override
	public List<Courseapply> queryAllCourseapproval(){
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Courseapply.class);
		//criteria.add(Restrictions.eq("status", "待审批"));
		//criteria.add(Restrictions.eq("status", "审批未通过"));
		//criteria.add(Restrictions.eq("status", "审批通过"));
		criteria.add(Restrictions.or(Restrictions.eq("status", "待审批"),Restrictions.eq("status", "审批不通过"),Restrictions.eq("status", "审批通过")));
		List<Courseapply> list = criteria.list();
		return list;
	}
	
	@Override
	public void modifyapprovalCourseapply(Courseapply courseapply){
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Courseapply.class);
		criteria.add(Restrictions.eq("id", courseapply.getId()));
		Courseapply temp = (Courseapply)criteria.uniqueResult();
		//temp.setStatus(1);
		//temp.setCourseapply(courseapply);
		if(temp != null){
			System.out.println(courseapply.getC_course_name());
			temp.setStatus(courseapply.getStatus());
			if(temp.getStatus().equals("审批通过")){
				Date date = new Date();
				courseapply.setApproval_time(date);
				Course cos = new Course();
				cos.setCourse(courseapply);
				
				System.out.println(" !!!: "+ courseapply.getInstitute_course());
				
				Coursetype coursetype = new Coursetype();
				Subtype subtype = new Subtype();
				Subtypemodule subtypemodule = new Subtypemodule();
				
				coursetype.setId(courseapply.getCourse_type());
				subtype.setId(courseapply.getSub_course_type());
				subtypemodule.setId(courseapply.getSub_course_type_module());
				
				cos.setCoursetype(coursetype);
				cos.setSubtype(subtype);
				cos.setSubtypemodule(subtypemodule);
				
				getSession().save(cos);
			}
		}
		System.out.println(temp.getId()+" "+temp.getBrief_course_name()+"  "+temp.getStatus());
				
		getSession().update(temp);
	}
	
	
	@Override
	public List<Courseapply> queryCourseapproval(Courseapply courseapply){
Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Courseapply.class);
		
		/*
		if (begin_time != null) {
			criteria.add(Restrictions.ge("approval_time", begin_time));
		}
		if (end_time != null) {
			criteria.add(Restrictions.le("approval_time", end_time));
		}*/
		if (courseapply.getInstitute_course() != 0) {
			criteria.add(Restrictions.eq("institute_course",
					courseapply.getInstitute_course()));
		}
		if (courseapply.getC_course_name() != null
				&& !courseapply.getC_course_name().equals("")) {
			criteria.add(Restrictions.eq("c_course_name", courseapply.getC_course_name()));
		}
		if (courseapply.getE_course_name() != null
				&& !courseapply.getE_course_name().equals("")) {
			criteria.add(Restrictions.eq("e_course_name", courseapply.getE_course_name()));
		}
		if (courseapply.getBrief_course_name() != null
				&& !courseapply.getBrief_course_name().equals("")) {
			criteria.add(Restrictions.eq("brief_course_name",
					courseapply.getBrief_course_name()));
		}
		if (courseapply.getFaculty() != null && !courseapply.getFaculty().equals("")) {
			criteria.add(Restrictions.eq("faculty", courseapply.getFaculty()));
		}
		if (courseapply.getCredit() != 0) {
			criteria.add(Restrictions.eq("credit", courseapply.getCredit()));
		}
		if (courseapply.getCourse_type() != 0) {
			criteria.add(Restrictions.eq("coursetype.id", courseapply.getCourse_type()));
		}
		if (courseapply.getSub_course_type() != 0) {
			criteria.add(Restrictions.eq("subtype.id",
					courseapply.getSub_course_type()));
		}
		if (courseapply.getSub_course_type_module() != 0) {
			criteria.add(Restrictions.eq("subtypemodule.id",
					courseapply.getSub_course_type_module()));
		}
		
		criteria.add(Restrictions.or(Restrictions.eq("status", "待审批"),Restrictions.eq("status", "审批不通过"),Restrictions.eq("status", "审批通过")));

		List<Courseapply> list = criteria.list();
		if(list != null)
			System.out.println("error list");
		return list;
	}
	
}
