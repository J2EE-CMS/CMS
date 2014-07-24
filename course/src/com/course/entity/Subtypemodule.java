package com.course.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "subtypemodule")
public class Subtypemodule {
	private int id;
	private String module_name;
	private String subtype_code;
	private String subtype_name;
	private String course_type;
	private String version;
	private String public_subtype;
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
	
	@Column(name="Module_name", length=30, nullable=false)
	public String getModule_name(){
		return module_name;
	}
	
	public void setModule_name(String module_name) {
		this.module_name = module_name;
	}
	
	@Column(name="subtype_code", length=30, nullable=false)
	public String getSubtype_code() {
		return subtype_code;
	}
	
	public void setSubtype_code(String subtype_code) {
		this.subtype_code = subtype_code;
	}
	
	@Column(name="subtype_name", length=30, nullable=false)
	public String getSubtype_name() {
		return subtype_name;
	}
	
	public void setSubtype_name(String subtype_name) {
		this.subtype_name = subtype_name;
	}
	
	@Column(name="course_type", length=30, nullable=false)
	public String getCourse_type() {
		return course_type;
	}
	
	public void setCourse_type(String course_type) {
			this.course_type = course_type;
	}
	
	@Column(name="version", length=10, nullable=false)
	public String getVersion() {
		return version;
	}
	
	public void setVersion(String version) {
			this.version = version;
	}
	
	
	@Column(name="public_subtype", length=10, nullable=false)
	public String getPublic_subtype() {
		return public_subtype;
	}
	
	public void setPublic_subtype(String public_subtype) {
			this.public_subtype = public_subtype;
	}
	

	@Id
	//采用数据库自增方式生成主键
	//@GeneratedValue(strategy=GenerationType.AUTO)
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
