package com.coursemanage.dao;

import java.util.Date;
import java.util.List;

import com.coursemanage.entity.Course;

public interface ICourseDao {
	public void addCourse(Course cos);
	public void modifyCourse(Course cos);
	public void deleteCourse(Course cos);
	public List<Course> queryCourse(Course cos, Date begin_time, Date end_time);
}
