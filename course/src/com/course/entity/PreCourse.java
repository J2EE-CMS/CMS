package com.course.entity;

public class PreCourse {
	private int id;
	private int course;
	private String pcos;
	int op;
	
	int sn;
	int group_number;
	
	int status;//0琛ㄧず鍏堜慨璇剧▼鍏崇郴鏃犳晥锛�琛ㄧず鍏崇郴鏈夋晥
	
	private Course cos;
	public Course getCos() {
		return cos;
	}
	public void setCos(Course cos) {
		this.cos = cos;
	}
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
	
	public int compareTo(PreCourse pcos){
		return (this.getId() < pcos.getId())?1:0;
	}
}
