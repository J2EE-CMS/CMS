package com.course.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "course_type")
public class Coursetype {
	private Integer id;
	private String typecore;
	private String type;
	private String quality;
	private String reexamine;
	private String retake;
	
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
	public void setCoursetype(Coursetype cos){
		this.type = cos.type;
		this.typecore = cos.typecore;
		this.quality = cos.quality;
		this.reexamine = cos.reexamine;
		this.retake = cos.retake;
	}
	
	@Column(name="typecore", length=10, nullable=false)
	public String getTypecore (){
		return typecore;
	}
	
	public void setTypecore (String typecore) {
		this.typecore = typecore;
	}
	
	@Column(name="type", length=30, nullable=false)
	public String getType() {
		return type;
	}
	
	public void setType (String type) {
		this.type = type;
	}
	
	@Column(name="quality", length=30, nullable=false)
	public String getQuality () {
		return quality;
	}
	
	public void setQuality (String quality) {
		this.quality = quality;
	}
	
	@Column(name="reexamine", length=10, nullable=false)
	public String getReexamine () {
		return reexamine;
	}
	
	public void setReexamine(String reexamine) {
			this.reexamine = reexamine;
	}
	
	@Column(name="retake", length=10, nullable=false)
	public String getRetake () {
		return retake;
	}
	
	public void setRetake(String retake) {
			this.retake = retake;
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
