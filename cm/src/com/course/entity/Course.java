package com.course.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "fcourse")
public class Course {
	private int id;
	private String name;
	private String place;
	private int time;
	private String isDegree;
	
	private String enName;
	private String sName;
	private int score;
	private String timeDesc;
	private String type;
	private int wTime;
	private String category;
	private String introduce;
	private String prerequisite;
	private String manager;
	
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
	
	@Column(name="isDegree", length=10, nullable=false)
	public String getIsDegree(){
		return isDegree;
	}
	
	public void setIsDegree(String isDegree){
		this.isDegree = isDegree;
	}
	
	@Column(name="enName", length=30, nullable=false)
	public String getEnName(){
		return enName;
	}
	
	public void setEnName(String enName){
		this.enName = enName;
	}

	@Column(name="sName", length=30, nullable=false, unique=true)
	public String getSName(){
		return sName;
	}
	
	public void setSName(String sName){
		this.sName = sName;
	}
	
	@Column(name="score", length=4, nullable=false)
	public int getScore(){
		return score;
	}
	
	public void setScore(int score){
		this.score = score;
	}

	@Column(name="timeDesc", length=30, nullable=false)
	public String getTimeDesc(){
		return timeDesc;
	}
	
	public void setTimeDesc(String timeDesc){
		this.timeDesc = timeDesc;
	}
	
	@Column(name="type", length=30, nullable=false)
	public String getType(){
		return type;
	}
	
	public void setType(String type){
		this.type = type;
	}
	
	@Column(name="wTime", length=4, nullable=false)
	public int getWTime(){
		return wTime;
	}
	
	public void setWTime(int wTime){
		this.wTime = wTime;
	}
	
	@Column(name="category", length=30, nullable=false)
	public String getCategory(){
		return category;
	}
	
	public void setCategory(String category){
		this.category = category;
	}
	
	@Column(name="introduce", length=30, nullable=false)
	public String getIntroduce(){
		return introduce;
	}
	
	public void setIntroduce(String introduce){
		this.introduce = introduce;
	}

	@Column(name="prerequisite", length=30, nullable=false)
	public String getPrerequisite(){
		return prerequisite;
	}
	
	public void setPrerequisite(String prerequisite){
		this.prerequisite = prerequisite;
	}
	
	@Column(name="manager", length=30, nullable=false)
	public String getManager(){
		return manager;
	}
	
	public void setManager(String manager){
		this.manager = manager;
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
