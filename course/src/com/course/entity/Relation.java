package com.course.entity;

public class Relation {
	private Integer id;
	private Integer grade;
	private String devtype;
	private int type;
	
	private Coursetype coursetype;
	
	/*
	public Relation(){
		
	}
	
	public Relation(Integer grade,String devtype,String type) {
		this.id = id;
		this.grade = grade;
		this.devtype = devtype;
		this.type = type;
	}
	*/
	
	public Coursetype getCoursetype() {
		return coursetype;
	}

	public void setCoursetype(Coursetype coursetype) {
		this.coursetype = coursetype;
	}

	public void setRelation (Relation temp) {
		//this.id = temp.id;
		this.grade = temp.grade;
		this.devtype = temp.devtype;
		this.type = temp.type;
	}
	
	public Integer getGrade() {
		return grade;
	}
	public void setGrade(Integer grade) {
		this.grade = grade;
	}
	
	
	public String getDevtype() {
		return devtype;
	}
	public void setDevtype(String devtype) {
		this.devtype = devtype;
	}
	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}

