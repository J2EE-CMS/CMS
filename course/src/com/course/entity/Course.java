package com.course.entity;

import java.util.Date;

public class Course {
	int id;
	String institute_course, c_course_name, e_course_name, brief_course_name,
			faculty;

	int credit;
	int sub_course_type_module, sub_course_type, course_type;
	String course_time, course_time_info;
	String course_info;
	String course_head;// ͨ课程负责人
	Date approval_time;
	boolean degree;// (是否学士学位，医科选填)
	int status;//
	String info;

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
		this.degree = cos.isDegree();
		this.status = cos.getStatus();
		this.info = cos.getInfo();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getInstitute_course() {
		return institute_course;
	}

	public void setInstitute_course(String institute_course) {
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

	public boolean isDegree() {
		return degree;
	}

	public void setDegree(boolean degree) {
		this.degree = degree;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

}
