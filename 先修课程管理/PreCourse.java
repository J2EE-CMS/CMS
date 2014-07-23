package com.coursemanage.entity;

public class PreCourse {
	private int id;
	private int course;
	private String pcos;
	int op;
	
	int sn;
	int group_number;
	int status;//0表示先修课程关系无效，1表示关系有效
	public int getOp() {
		return op;
	}
	public void setOp(int op) {
		this.op = op;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCourse() {
		return course;
	}
	public void setCourse(int course) {
		this.course = course;
	}
	public int getSn() {
		return sn;
	}
	public void setSn(int sn) {
		this.sn = sn;
	}
	public int getGroup_number() {
		return group_number;
	}
	public void setGroup_number(int group_number) {
		this.group_number = group_number;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}

	public String getPcos() {
		return pcos;
	}
	public void setPcos(String pcos) {
		this.pcos = pcos;
	}
}
