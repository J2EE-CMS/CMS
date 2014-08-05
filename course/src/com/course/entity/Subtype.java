package com.course.entity;

public class Subtype {
	private int id;					//ÐòºÅ
	private String subtypecode;		//¿Î³ÌÏ¸ÀàÂë
	private String subtypename;		//¿Î³ÌÏ¸ÀàÃû
	private int belongtotype;	//ËùÊô¿Î³ÌÀà±ð
	private String ispublicsubtype;	//ÊÇ·ñ¹«¹²Ï¸Àà
	private String department;		//ÉèÁ¢µ¥Î»
	

	public int getBelongtotype() {
		return belongtotype;
	}

	public void setBelongtotype(int belongtotype) {
		this.belongtotype = belongtotype;
	}

	

	private Coursetype coursetype;
	
	//subtype.subtypecode
	//subtype.
	/*
	public Subtype(Integer id,String subtypecode,String subtypename,String belongtotype,String ispublicsubtype,String department){
		this.id = id;
		this.subtypecode = subtypecode;
		this.subtypename = subtypename;
		this.belongtotype = belongtotype;
		this.ispublicsubtype = ispublicsubtype;
		this.department = department;
	}
	*/
	
	public int getId() {
		return id;
	}
	
	public Coursetype getCoursetype() {
		return coursetype;
	}

	public void setCoursetype(Coursetype coursetype) {
		this.coursetype = coursetype;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getSubtypecode(){
		return subtypecode;
	}
	
	public void setSubtypecode(String subtypecode) {
		this.subtypecode = subtypecode;
	}
	
	public String getSubtypename() {
		return subtypename;
	}
	
	public void setSubtypename(String subtypename) {
		this.subtypename = subtypename;
	}

	public String getIspublicsubtype() {
		return ispublicsubtype;
	}

	public void setIspublicsubtype(String ispublicsubtype) {
		this.ispublicsubtype = ispublicsubtype;
	}

	public String getDepartment() {
		return department;
	}
	
	public void setDepartment(String department) {
		this.department = department;
	}
	
}
