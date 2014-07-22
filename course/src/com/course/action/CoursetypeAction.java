package com.course.action;

import java.util.List;

import javax.annotation.Resource;

import com.course.entity.Coursetype;
import com.course.service.ICoursetypeManage;
import com.opensymphony.xwork2.ActionSupport;

public class CoursetypeAction extends ActionSupport  {
	
	private Coursetype coursetype;
	List<Coursetype> coursetypes;
	
	@Resource
	private ICoursetypeManage coursetypeM;

	public Coursetype getCoursetype() {
		return coursetype;
	}

	public void setCoursetype(Coursetype coursetype) {
		this.coursetype = coursetype;
	}

	public List<Coursetype> getCourses() {
		return coursetypes;
	}

	public void setCourses(List<Coursetype> courses) {
		this.coursetypes = courses;
	}

	public ICoursetypeManage getCoursetypeM() {
		return coursetypeM;
	}

	public void setCoursetypeM(ICoursetypeManage coursetypeM) {
		this.coursetypeM = coursetypeM;
	}

		
	public String addCoursetype()
	{		
		coursetypeM.addCoursetype(coursetype);
		return "success";
	}
	
	public String deleteCoursetype()
	{
		coursetypeM.deleteCoursetype(coursetype);
		return "success";
	}
	
	public String modifyCoursetype()
	{
		coursetypeM.modifyCoursetype(coursetype);
		return "success";
	}
	
	public String getAllCoursetypes(){
		coursetypes = coursetypeM.getAllCoursetypes();
		return "allcoursetype";
	}

	
}
