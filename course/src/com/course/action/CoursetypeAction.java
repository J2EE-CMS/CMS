package com.course.action;

import java.util.*;

import javax.annotation.Resource;

import com.course.entity.Coursetype;
import com.course.service.ICoursetypeManage;
import com.opensymphony.xwork2.ActionSupport;

public class CoursetypeAction extends ActionSupport  {
	
	private Coursetype coursetype;
	private List<Coursetype> coursetypes;
	
	@Resource
	private ICoursetypeManage coursetypeManage;
		
	public Coursetype getCoursetype() {
		return coursetype;
	}

	public void setCoursetype(Coursetype coursetype) {
		this.coursetype = coursetype;
	}

	public List<Coursetype> getCoursetypes() {
		return coursetypes;
	}

	public void setCoursetypes(List<Coursetype> coursetypes) {
		this.coursetypes = coursetypes;
	}

	public ICoursetypeManage getCoursetypeManage() {
		return coursetypeManage;
	}

	public void setCoursetypeManage(ICoursetypeManage coursetypeManage) {
		this.coursetypeManage = coursetypeManage;
	}
	

	public String addCoursetype()
	{
		System.out.println("-------CoursetypeAction add------");
		if(coursetypeManage!=null){
			coursetypeManage.addCoursetype(coursetype);
		}
		else{
			System.out.println("coursetypeManage is null");
		}
		return "success";
	}
	
	public String deleteCoursetype()
	{
		coursetypeManage.deleteCoursetype(coursetype);
		return "success";
	}
	
	public String modifyCoursetype()
	{
		coursetypeManage.modifyCoursetype(coursetype);
		return "success";
	}
	
	public String getAllCoursetypes(){
		coursetypes = coursetypeManage.getAllCoursetypes();
		return "allcoursetype";
	}

	
}
