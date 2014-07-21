package com.course.dao;

import java.util.List;

import com.course.entity.Course;

public interface ICourseDao {
	public void addCourse(Course cos);
	public void modifyCourse(Course cos);
	public void deleteCourse(Course cos);
	public void queryCourse(Course cos);
	public List<Course> findAllCourse();
}
