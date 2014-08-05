package com.course.entity;

import java.util.Date;

public class Courseapply {
	
	int id;
	String status;//¡°´ýÉóÅú¡±
	Date apply_time;
	Date approval_time;
	int institute_course;
	String c_course_name, e_course_name, brief_course_name;
	String faculty;
	int credit;
	int sub_course_type_module, sub_course_type, course_type;
	String course_time, course_time_info;
	String course_info;
	String course_head;
	String degree;
	String info;
	
	
	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	private Coursetype coursetype;
	private Subtype subtype;
	private Subtypemodule subtypemodule;
	
	
	public Coursetype getCoursetype() {
		return coursetype;
	}

	public void setCoursetype(Coursetype coursetype) {
		this.coursetype = coursetype;
	}

	public Subtype getSubtype() {
		return subtype;
	}

	public void setSubtype(Subtype subtype) {
		this.subtype = subtype;
	}

	public Subtypemodule getSubtypemodule() {
		return subtypemodule;
	}

	public void setSubtypemodule(Subtypemodule subtypemodule) {
		this.subtypemodule = subtypemodule;
	}

	public Courseapply(){
		
	}
	
	public Courseapply(int id,String status,Date apply_time,Date approval_time,int institute_course,String c_course_name,String e_course_name,String brief_course_name,String faculty,int credit,int sub_course_type_module,int sub_course_type,int course_type,String course_time,String course_time_info,String course_info,String course_head,String degree) {
		this.id = id;
		this.status = status;
		this.apply_time = apply_time;
		this.approval_time = approval_time;
		this.institute_course = institute_course;
		this.c_course_name = c_course_name;
		this.e_course_name = e_course_name;
		this.brief_course_name = brief_course_name;
		this.faculty = faculty;
		this.credit = credit;
		this.sub_course_type_module = sub_course_type_module;
		this.sub_course_type = sub_course_type;
		this.course_type = course_type;
		this.course_time = course_time;
		this.course_time_info = course_time_info;
		this.course_info = course_info;
		this.course_head = course_head;
		this.degree = degree;
	}
	
	
	public void setCourseapply(Courseapply courseapp){
		//this.id = courseapp.getId();
		this.status = courseapp.getStatus();
		this.apply_time = courseapp.getApply_time();
		this.approval_time = courseapp.getApproval_time();
		this.institute_course = courseapp.getInstitute_course();
		this.c_course_name = courseapp.getC_course_name();
		this.e_course_name = courseapp.getE_course_name();
		this.brief_course_name = courseapp.getBrief_course_name();
		this.faculty = courseapp.getFaculty();
		this.credit = courseapp.getCredit();
		this.sub_course_type_module = courseapp.getSub_course_type_module();
		this.sub_course_type = courseapp.getSub_course_type();
		this.course_type = courseapp.getCourse_type();
		this.course_time = courseapp.getCourse_time();
		this.course_time_info = courseapp.getCourse_time_info();
		this.course_info = courseapp.getCourse_info();
		this.course_head = courseapp.getCourse_head();
		this.degree = courseapp.getDegree();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getApply_time() {
		return apply_time;
	}
	public void setApply_time(Date apply_time) {
		this.apply_time = apply_time;
	}
	public Date getApproval_time() {
		return approval_time;
	}
	public void setApproval_time(Date approval_time) {
		this.approval_time = approval_time;
	}
	
	public int getInstitute_course() {
		return institute_course;
	}

	public void setInstitute_course(int institute_course) {
		this.institute_course = institute_course;
	}

	public String getC_course_name() {
		return c_course_name;
	}
	public void setC_course_name(String c_course_name) {
		this.c_course_name = c_course_name;
	}
	public String getE_course_name() {
		return e_course_name;
	}
	public void setE_course_name(String e_course_name) {
		this.e_course_name = e_course_name;
	}
	public String getBrief_course_name() {
		return brief_course_name;
	}
	public void setBrief_course_name(String brief_course_name) {
		this.brief_course_name = brief_course_name;
	}
	public String getFaculty() {
		return faculty;
	}
	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	public int getSub_course_type_module() {
		return sub_course_type_module;
	}
	public void setSub_course_type_module(int sub_course_type_module) {
		this.sub_course_type_module = sub_course_type_module;
	}
	public int getSub_course_type() {
		return sub_course_type;
	}
	public void setSub_course_type(int sub_course_type) {
		this.sub_course_type = sub_course_type;
	}
	public int getCourse_type() {
		return course_type;
	}
	public void setCourse_type(int course_type) {
		this.course_type = course_type;
	}
	public String getCourse_time() {
		return course_time;
	}
	public void setCourse_time(String course_time) {
		this.course_time = course_time;
	}
	public String getCourse_time_info() {
		return course_time_info;
	}
	public void setCourse_time_info(String course_time_info) {
		this.course_time_info = course_time_info;
	}
	public String getCourse_info() {
		return course_info;
	}
	public void setCourse_info(String course_info) {
		this.course_info = course_info;
	}
	public String getCourse_head() {
		return course_head;
	}
	public void setCourse_head(String course_head) {
		this.course_head = course_head;
	}
	
	
	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}
	
	/*
	public String returnDegree(){
		if(isDegree() == true)
			return "true";
		return "false";
	}
	*/
}
