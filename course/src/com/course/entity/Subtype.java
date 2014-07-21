package com.course.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sub_type")
public class Subtype {
	private Integer id;				//序号
	private String subtypecode;		//课程细类码
	private String subtypename;		//课程细类名
	private String belongtotype;	//所属课程类别
	private String ispublicsubtype;	//是否公共细类
	private String department;		//设立单位
	
	public Subtype(){
		
	}
	
	public Subtype(Integer id,String subtypecode,String subtypename,String belongtotype,String ispublicsubtype,String department){
		this.id = id;
		this.subtypecode = subtypecode;
		this.subtypename = subtypename;
		this.belongtotype = belongtotype;
		this.ispublicsubtype = ispublicsubtype;
		this.department = department;
	}
	
	@Column(name="subtypecode", length=10, nullable=false)
	public String getSubtypecode (){
		return subtypecode;
	}
	
	public void setSubtypecode (String subtypecode) {
		this.subtypecode = subtypecode;
	}
	
	@Column(name="subtypename", length=30, nullable=false)
	public String getSubtypename() {
		return subtypename;
	}
	
	public void setSubtypename (String subtypename) {
		this.subtypename = subtypename;
	}
	
	@Column(name="belongtotype", length=30, nullable=false)
	public String getBelongtotype () {
		return belongtotype;
	}
	
	public void setBelongtotype (String belongtotype) {
		this.belongtotype = belongtotype;
	}
	
	@Column(name="ispublicsubtype", length=10, nullable=false)
	public String getIspublicsubtype () {
		return ispublicsubtype;
	}
	
	public void setIspublicsubtype(String ispublicsubtype) {
		this.ispublicsubtype = ispublicsubtype;
	}
	
	@Column(name="department", length=10, nullable=false)
	public String getDepartment () {
		return department;
	}
	
	public void setDepartment(String department) {
		this.department = department;
	}
	
	@Id
	//采用数据库自增方式生成主键
	//@GeneratedValue(strategy=GenerationType.AUTO)
	@GeneratedValue
	public Integer getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
