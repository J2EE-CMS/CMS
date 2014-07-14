package com.course.service;

import java.util.List;

import com.course.entity.Coursetype;

public interface ICoursetypeManage {
	public void addCoursetype(Coursetype coursetype);
	public void deleteCoursetype(Integer id);
	public void modifyCoursetype(Coursetype coursetype);
	public List<Coursetype> getAllCoursetypes();
}

