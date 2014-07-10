package com.course.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "p_user")
public class User {
	private int id;
	private String name;
	private String password;
	private int age;
	

	@Column(name="name", length=30, nullable=false, unique=true)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="password", length=20, nullable=false, unique=true)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name="age", length=10)
	public int getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = 0;
		if (age != null) {
			this.age = age;
		}
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
