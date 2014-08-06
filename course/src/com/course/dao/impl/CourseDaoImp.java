package com.course.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.course.dao.ICourseDao;
import com.course.entity.Course;
import com.course.entity.Courseapply;
import com.course.entity.Coursetype;
import com.course.entity.PreCourse;
import com.course.entity.Subtype;
import com.course.entity.Subtypemodule;

public class CourseDaoImp implements ICourseDao {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public boolean addCourse(Course cos) {
		System.out.println("------CourseDaoImp.AddCourse------");
		if(!addcheckCourse(cos, 0))
			return false;
		Coursetype coursetype = new Coursetype();
		Subtype subtype = new Subtype();
		Subtypemodule subtypemodule = new Subtypemodule();

		subtype.setId(cos.getSub_course_type());		
		coursetype.setId(cos.getCourse_type());
		subtypemodule.setId(cos.getSub_course_type_module()==0?999:cos.getSub_course_type_module());
		
		cos.setCoursetype(coursetype);
		cos.setSubtype(subtype);
		cos.setSubtypemodule(subtypemodule);
		
		getSession().save(cos);
		return true;
	}

	// ���޸��ֶΰ������γ��������ơ��γ�Ӣ�����ơ��γ̼�ơ�ԭ���赥λ��ѧ�֡���ѧʱ����ѧʱ��ע���γ����͡���ע��
	@Override
	public boolean modifyCourse(Course cos) {
		System.out.println("------CourseDaoImp.modifyCourse------");
		if(!addcheckCourse(cos, 1))
			return false;
		/*String hql = "from Course as course where course.c_course_name=?";
		Query query = getSession().createQuery(hql);
		query.setString(0, cos.getC_course_name());
		Course c = (Course) query.uniqueResult();
		if (c != null) {
			c.setC_course_name(cos.getC_course_name());
			c.setE_course_name(cos.getE_course_name());
			c.setBrief_course_name(cos.getBrief_course_name());
			c.setFaculty(cos.getFaculty());
			c.setCredit(cos.getCredit());
			c.setCourse_time(cos.getCourse_time());
			c.setCourse_time_info(cos.getCourse_time_info());
			 */
			Coursetype coursetype = new Coursetype();
			coursetype.setId(cos.getCourse_type());
			
			Subtype subtype = new Subtype();
			subtype.setId(cos.getSub_course_type());
			
			Subtypemodule subtypemodule = new Subtypemodule();
			subtypemodule.setId(cos.getSub_course_type_module()==0?999:cos.getSub_course_type_module());
			
			cos.setCoursetype(coursetype);
			cos.setSubtype(subtype);
			cos.setSubtypemodule(subtypemodule);
			
			//c.setInfo(cos.getInfo());
			getSession().update(cos);
		
		//String temp = "update Course as cose set cose.course_type=? where cose.c_course_name=?";
		//Query que = getSession().createQuery("temp");
		//que.setInteger(0, cos.getCourse_type());
		//que.setString(1, cos.getC_course_name());
		//que.executeUpdate();
		return true;
	}

	@Override
	public void deleteCourse(Course cos) {
		System.out.println("------CourseDaoImp.deleteCourse------");
		String hql = "from Course as course where course.c_course_name=?";
		Query query = getSession().createQuery(hql);
		query.setString(0, cos.getC_course_name());

		//Criteria temp = sessionFactory.getCurrentSession().createCriteria(PreCourse.class);
		//temp.add(Restrictions.eq("course", cos.getId()));
		
		//if(temp.uniqueResult() == null){
		Course c = (Course) query.uniqueResult();
		
		Criteria temp = sessionFactory.getCurrentSession().createCriteria(PreCourse.class);
		temp.add(Restrictions.eq("cos.id", cos.getId()));
		
		if ((c != null)  &&  (temp.list().size()==0)) {
			getSession().delete(c);
		}
		//}
	}

	@Override
	public List<Course> queryCourse(Course cos, Date begin_time, Date end_time) {
		System.out.println("------CourseDaoImp.queryCourse------");

		Criteria crit = getSession().createCriteria(Course.class);

		if (cos.getId() != 0) {
			crit.add(Restrictions.eq("id", cos.getId()));
		}

		if (begin_time != null) {
			System.out.println("begin time: " + begin_time.toString() + "\t");
			crit.add(Restrictions.ge("approval_time", begin_time));
		}
		if (end_time != null) {
			System.out.println("end time: " + end_time.toString() + "\t");
			crit.add(Restrictions.le("approval_time", end_time));
		}
		if (cos.getInstitute_course() != 0) {
			crit.add(Restrictions.eq("institute_course",
					cos.getInstitute_course()));
		}
		if (cos.getC_course_name() != null
				&& !cos.getC_course_name().equals("")) {
			crit.add(Restrictions.eq("c_course_name", cos.getC_course_name()));
		}
		if (cos.getE_course_name() != null
				&& !cos.getE_course_name().equals("")) {
			crit.add(Restrictions.eq("e_course_name", cos.getE_course_name()));
		}
		if (cos.getBrief_course_name() != null
				&& !cos.getBrief_course_name().equals("")) {
			crit.add(Restrictions.eq("brief_course_name",
					cos.getBrief_course_name()));
		}
		if (cos.getFaculty() != null && !cos.getFaculty().equals("")) {
			crit.add(Restrictions.eq("faculty", cos.getFaculty()));
		}
		if (cos.getCredit() != 0) {
			crit.add(Restrictions.eq("credit", cos.getCredit()));
		}
		if (cos.getCourse_type() != 0) {
			crit.add(Restrictions.eq("coursetype.id", cos.getCourse_type()));
		}
		if (cos.getSub_course_type() != 0) {
			crit.add(Restrictions.eq("subtype.id",
					cos.getSub_course_type()));
		}
		if (cos.getSub_course_type_module() != 0) {
			crit.add(Restrictions.eq("subtypemodule.id",
					cos.getSub_course_type_module()));
		}
	//crit.add(Restrictions.eq("status", cos.getStatus()));

		List<Course> list = crit.list();
		for (Course c : list) {
			getInfo(c);
		}
		return list;

	}

	private void getInfo(Course cos) {
		System.out.println("Course id:"
				+ cos.getId()
				+ "\t"
				+ "institute_course:"
				+ (cos.getInstitute_course()) + "\t" + "c_course_name:"
				+ cos.getC_course_name() + "\t" + "e_course_name:"
				+ cos.getE_course_name() + "\t" + "brief_course_name:"
				+ cos.getBrief_course_name() + "\t" + "faculty:"
				+ cos.getFaculty() + "\t" + "credit:" + cos.getCredit() + "\n"
				+ "sub_course_type_module:" + cos.getSub_course_type_module()
				+ "\t" + "sub_course_type:" + cos.getSub_course_type() + "\t"
				+ "course_type:" + cos.getCourse_type() + "\n" + "course_time:"
				+ cos.getCourse_time() + "\t" + "course_time_info:"
				+ cos.getCourse_time_info() + "\t" + "course_info:"
				+ cos.getCourse_info() + "\t" + "course_head:"
				+ cos.getCourse_head() + "\t" + "approval_time:"
				+ cos.getApproval_time() + "\t" + "degree:" + cos.getDegree()
				+ "\t" + "status:" + cos.getStatus() + "\t" + "info:"
				+ cos.getInfo() + "\n");

	}

	@Override
	public List<Course> findAllCourse() {
		Criteria crit = getSession().createCriteria(Course.class);
		List<Course> list = crit.list();
		return list;
	}
	
	private boolean addcheckCourse(Course cos, int checktype) {

		List<Course> coslist = null;
		Criteria crit = null;
		// �����������Ժϵ�γ̺�
		if (checktype == 0) {// ���
			crit = getSession().createCriteria(Course.class);
			crit.add(Restrictions.or(Restrictions.eq("c_course_name", cos.getC_course_name()),
					Restrictions.eq("institute_course", cos.getInstitute_course())));
			coslist = crit.list();
			if (coslist.size() != 0) {
				return false;
			}
		} else if (checktype == 1) {// �޸�
			crit = getSession().createCriteria(Course.class);
			crit.add(Restrictions.or(Restrictions.eq("c_course_name", cos.getC_course_name()),
					Restrictions.eq("institute_course", cos.getInstitute_course())));
			coslist = crit.list();
			if (coslist.size() > 1) {
				System.out.println("�γ���������γ�Ӣ��������");
				return false;
			}
		}
		// ������ͣ���Ӧ��ϵ
		Coursetype costype = null;
		Subtype subtype = null;
		Subtypemodule subtm = null;

		crit = getSession().createCriteria(Coursetype.class);
		crit.add(Restrictions.eq("id", cos.getCourse_type()));
		costype = (Coursetype) crit.uniqueResult();
		if (costype == null) {
			System.out.println("��𲻴���");
			return false;
		}

		crit = getSession().createCriteria(Subtype.class);
		crit.add(Restrictions.eq("id", cos.getSub_course_type()));
		subtype = (Subtype) crit.uniqueResult();
		if (subtype == null) {
			System.out.println("ϸ�಻����");
			return false;
		}
		if (costype.getId() != subtype.getCoursetype().getId()) {
			System.out.println(costype.getId() + " " + subtype.getBelongtotype() + " ϸ������𲻶�Ӧ");
			return false;
		}

		if (cos.getSub_course_type_module() != 0) {
			crit = getSession().createCriteria(Subtypemodule.class);
			crit.add(Restrictions.eq("id", cos.getSub_course_type_module()));
			subtm = (Subtypemodule) crit.uniqueResult();
			if (subtm == null) {
				System.out.println("ϸ��ģ�鲻����");
				return false;
			}
			if (subtm.getSubtype().getId() != subtype.getId()) {
				System.out.println("ϸ��ģ����ϸ�಻��Ӧ");
				return false;
			}
		}
		getSession().clear();
		return true;
	}
}
