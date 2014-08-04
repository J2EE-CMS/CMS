package com.course.entity;

import java.util.Set;

public class Coursetype {
	private int id;
	private String typecore;
	private String type;
	private String quality;
	private String reexamine;//
	private String retake;//
	
	private Set<Subtype> subtype;
	/*
	public Coursetype(){
		
	}
	
	public Coursetype(Integer id,String typecore,String type,String quality,String reexamine,String retake){
		this.id = id;
		this.typecore = typecore;
		this.type = type;
		this.quality = quality;
		this.reexamine = reexamine;
		this.retake = retake;
	}
	*/
	

	public void setCoursetype(Coursetype cos){
		this.type = cos.type;
		this.typecore = cos.typecore;
		this.quality = cos.quality;
		this.reexamine = cos.reexamine;
		this.retake = cos.retake;
	}
	
	public Set<Subtype> getSubtype() {
		return subtype;
	}

	public void setSubtype(Set<Subtype> subtype) {
		this.subtype = subtype;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getTypecore (){
		return typecore;
	}
	
	public void setTypecore (String typecore) {
		this.typecore = typecore;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType (String type) {
		this.type = type;
	}
	
	public String getQuality () {
		return quality;
	}
	
	public void setQuality (String quality) {
		this.quality = quality;
	}
	
	public String getReexamine () {
		return reexamine;
	}
	
	public void setReexamine(String reexamine) {
			this.reexamine = reexamine;
	}
	
	public String getRetake () {
		return retake;
	}
	
	public void setRetake(String retake) {
			this.retake = retake;
	}
	
	
}
