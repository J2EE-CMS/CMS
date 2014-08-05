package com.course.entity;

public class Subtypemodule {
	private int id;
	private String module_name;
	private String subtype_code;
	private int subtype_name;
	private int course_type;
	private String version;
	private String public_subtype;
	
	private Coursetype coursetype;
	
	private Subtype subtype;
	
	/*
	public Subtypemodule(){
		
	}
	
	public Subtypemodule(Integer id,String module_name,String subtype_code,String subtype_name,String course_type,String version,String public_subtype){
		this.id = id;	
		this.module_name = module_name;
		this.subtype_code = subtype_code;
		this.subtype_name = subtype_name;
		this.course_type = course_type;
		this.version = version;
		this.public_subtype = public_subtype;
	}
	*/
	
	public void setSubtypemodule(Subtypemodule temp){
		//this.id = temp.getId();	
		this.module_name = temp.getModule_name();
		this.subtype_code = temp.getSubtype_code();
		this.subtype_name = temp.getSubtype_name();
		this.course_type = temp.getCourse_type();
		this.version = temp.getVersion();
		this.public_subtype = temp.getPublic_subtype();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getModule_name() {
		return module_name;
	}

	public void setModule_name(String module_name) {
		this.module_name = module_name;
	}

	public String getSubtype_code() {
		return subtype_code;
	}

	public void setSubtype_code(String subtype_code) {
		this.subtype_code = subtype_code;
	}

	public int getSubtype_name() {
		return subtype_name;
	}

	public void setSubtype_name(int subtype_name) {
		this.subtype_name = subtype_name;
	}

	public int getCourse_type() {
		return course_type;
	}

	public void setCourse_type(int course_type) {
		this.course_type = course_type;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}	

	public String getPublic_subtype() {
		return public_subtype;
	}

	public void setPublic_subtype(String public_subtype) {
		this.public_subtype = public_subtype;
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
	
	
	
}
