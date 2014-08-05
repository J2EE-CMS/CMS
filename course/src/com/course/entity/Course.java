package com.course.entity;

import java.util.Date;

public class Course {
	int institute_course, id;
	String  c_course_name, e_course_name, brief_course_name,
			faculty;

	int credit;
	int sub_course_type_module, sub_course_type, course_type;
	String course_time, course_time_info;
	String course_info;
	String course_head;// 通璇剧▼璐熻矗浜�
	Date approval_time;
	String degree;// (鏄惁瀛﹀＋瀛︿綅锛屽尰绉戦�濉�
	String status;//
	//开设单位:sis_comm_yxxx
	String info;

	private Coursetype coursetype;
	private Subtype subtype;
	private Subtypemodule subtypemodule;
	
	
	public void setCourse(Courseapply cosapp) {
		this.id = cosapp.getId();
		//this.status = cosapp.getStatus();
		this.status = "待审批";
		this.approval_time = cosapp.getApproval_time();
		this.institute_course = cosapp.getInstitute_course();
		this.c_course_name = cosapp.getC_course_name();
		this.e_course_name = cosapp.getE_course_name();
		this.brief_course_name = cosapp.getBrief_course_name();
		this.faculty = cosapp.getFaculty();
		this.credit = cosapp.getCredit();
		this.sub_course_type_module = cosapp.sub_course_type_module;
		this.sub_course_type = cosapp.getSub_course_type();
		this.course_type = cosapp.getCourse_type();
		this.course_time = cosapp.getCourse_time();
		this.course_time_info = cosapp.getCourse_time_info();
		this.course_info = cosapp.getCourse_info();
		this.course_head = cosapp.getCourse_head();
		this.degree = cosapp.getDegree();
		this.info = cosapp.getInfo();
	}
	
	
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

	void setCourse(Course cos) {
		this.id = cos.getId();
		this.institute_course = cos.getInstitute_course();
		this.c_course_name = cos.getC_course_name();
		this.e_course_name = cos.getE_course_name();
		this.brief_course_name = cos.getBrief_course_name();
		this.faculty = cos.getFaculty();
		this.credit = cos.getCredit();
		this.sub_course_type_module = cos.getSub_course_type_module();
		this.sub_course_type = cos.getSub_course_type();
		this.course_type = cos.getCourse_type();
		this.course_time = cos.getCourse_time();
		this.course_time_info = cos.getCourse_time_info();
		this.course_info = cos.getCourse_info();
		this.course_head = cos.getCourse_head();
		this.approval_time = cos.getApproval_time();
		this.degree = cos.getDegree();
		this.status = cos.getStatus();
		this.info = cos.getInfo();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Date getApproval_time() {
		return approval_time;
	}

	public void setApproval_time(Date approval_time) {
		this.approval_time = approval_time;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	

	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
	/*
	public String returnDegree(){
		if(isDegree() == true)
			return "true";
		return "false";
	}
	*/
}
