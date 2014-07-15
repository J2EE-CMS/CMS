package com.course.dao;

import com.course.entity.Course;

import java.util.List;

public interface ICourseDao {
	public void addCourse(Course course);
	public void modifyCourse(Course course);
	public void deleteCourse(Course course);
	public List<Course> findCourse(Course course);
	public List<Course> findAllCourse();
}
