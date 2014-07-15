package com.course.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "course")
public class Course {
	private int id;
	private String name;
	private String place;
	private int time;
	private String isDegree;
	
	@Column(name="name", length=30, nullable=false, unique=true)
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	@Column(name="place", length=30, nullable=false)
	public String getPlace(){
		return place;
	}
	
	public void setPlace(String place){
		this.place = place;
	}
	
	@Column(name="time", length=4, nullable=false)
	public int getTime(){
		return time;
	}
	
	public void setTime(int time){
		this.time = time;
	}
	
	@Column(name="isdegree", length=10, nullable=false)
	public String getIsDegree(){
		return isDegree;
	}
	
	public void setIsDegree(String isDegree){
		this.isDegree = isDegree;
	}
	
	@Id
	@GeneratedValue
	public int getId(){
		return id;
	}
	
	public void setId(int id){
		this.id=id;
	}
}
