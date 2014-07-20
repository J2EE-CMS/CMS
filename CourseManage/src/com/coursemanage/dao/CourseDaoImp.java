package com.coursemanage.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

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
		System.out.println("------CourseDaoImp.AddCourse------");
		getInfo(cos);
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
		//getInfo(cos);
	    Criteria crit = getSession().createCriteria(Course.class);
	    
	    if(!cos.getInstitute_course().equals("")){
	    crit.add(Restrictions.eq("institute_course",cos.getInstitute_course() ));
	    }	    
	    if(!cos.getC_course_name().equals("")){
		    crit.add(Restrictions.eq("c_course_name",cos.getC_course_name() ));
		}	  
	    if(!cos.getE_course_name().equals("")){
		    crit.add(Restrictions.eq("e_course_name",cos.getE_course_name() ));
		}	
	    if(!cos.getBrief_course_name().equals("")){
		    crit.add(Restrictions.eq("brief_course_name",cos.getBrief_course_name() ));
		}
	    if(!cos.getBrief_course_name().equals("")){
		    crit.add(Restrictions.eq("faculty",cos.getBrief_course_name() ));
		}
	    if(cos.getCredit()!=0){
	    	crit.add(Restrictions.eq("credit",cos.getCredit()));
	    }
	    if(cos.getCourse_type()!=0){
	    	crit.add(Restrictions.eq("course_type",cos.getCourse_type()));
	    }
	    if(cos.getSub_course_type()!=0){
	    	crit.add(Restrictions.eq("sub_course_type",cos.getSub_course_type()));
	    }
	    if(cos.getSub_course_type_module()!=0){
	    	crit.add(Restrictions.eq("sub_course_type_module",cos.getSub_course_type_module()));
	    }
	    crit.add(Restrictions.eq("status", cos.getStatus()));
	    
		List<Course> list = crit.list();
		for(Course c : list){
			getInfo(c);
		}
		
	}
	private void getInfo(Course cos){
		System.out.println("Course id:"+cos.getId()+"\t"
				+"institute_course:"+(cos.getInstitute_course().equals("")?"NULL":cos.getInstitute_course())+"\t"
				+"c_course_name:"+cos.getC_course_name()+"\t"
				+"e_course_name:"+cos.getE_course_name()+"\t"
				+"brief_course_name:"+cos.getBrief_course_name()+"\t"
				+"faculty:"+cos.getFaculty()+"\t"
				+"credit:"+cos.getCredit()+"\n"
				+"sub_course_type_module:"+cos.getSub_course_type_module()+"\t"
				+"sub_course_type:"+cos.getSub_course_type()+"\t"
				+"course_type:"+cos.getCourse_type()+"\n"
				+"course_time:"+cos.getCourse_time()+"\t"
				+"course_time_info:"+cos.getCourse_time_info()+"\t"
				+"course_info:"+cos.getCourse_info()+"\t"
				+"course_head:"+cos.getCourse_head()+"\t"
				+"approval_time:"+cos.getApproval_time()+"\t"
				+"degree:"+cos.isDegree()+"\t"
				+"status:"+cos.getStatus()+"\t"
				+"info:"+cos.getInfo()+"\n");
		
	}
}
 