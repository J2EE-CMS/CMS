package com.course.action;

import java.util.List;

import javax.annotation.Resource;

import com.course.entity.Coursetype;
import com.course.service.ICoursetypeManage;
import com.opensymphony.xwork2.ActionSupport;

public class CoursetypeAction extends ActionSupport  {
	
	private Coursetype coursetype;
	private List<Coursetype> courses;
	private Integer id;
	
	@Resource
	private ICoursetypeManage coursetypeM;

	public void setICoursetypeM (ICoursetypeManage coursetypeM) {
		this.coursetypeM = coursetypeM;
	}
	
	public ICoursetypeManage getICoursetypeM() {
		return coursetypeM;
	}
	
	
	public Coursetype getCoursetype() {
		return coursetype;
	}

	public void setCoursetype(Coursetype coursetype) {
		this.coursetype = coursetype;
	}

	public String addCoursetype()
	{		
		coursetypeM.addCoursetype(coursetype);
		return "success";
	}
	
	public String deleteCoursetype()
	{
		coursetypeM.deleteCoursetype(id);
		return "success";
	}
	
	public String modifyCourseType()
	{
		coursetypeM.modifyCoursetype(coursetype);
		return "success";
	}
	
	public List<Coursetype> getAllCoursetypes(){
		return courses;
	}
	
}
