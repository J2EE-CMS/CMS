package com.coursemanage.dao;

import com.coursemanage.entity.Course;

public interface ICourseDao {
	public void AddCourse(Course cos);
	public void modifyCourse(Course cos);
	public void deleteCourse(Course cos);
	public void queryCourse(Course cos);
}
