package com.course.dao;

import java.io.InputStream;
import java.util.List;

import com.course.entity.Coursetype;

public interface ICoursetypeDao {
	public void addCoursetype(Coursetype coursetype);
	public void deleteCoursetype(Coursetype coursetype);
	public void modifyCoursetype(Coursetype coursetype);
	public List<Coursetype> getAllCoursetypes();
	//public InputStream getInputStream();
}

