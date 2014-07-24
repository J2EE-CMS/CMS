package com.course.dao;

import java.util.List;

import com.course.entity.Courseapply;

public interface ICourseapplyDao {
	public void addCourseapply (Courseapply courseapply);
	public void modifyCourseapply(Courseapply courseapply);
	public void deleteCourseapply(Courseapply courseapply);
	public List<Courseapply> queryAllCourseapply();
	public void commitCourseapply(Courseapply courseapply);
	public List<Courseapply> queryCourseapply(Courseapply courseapply);
	
	public List<Courseapply> queryAllCourseapproval();
	public void approvalCourseapply(Courseapply courseapply);
	public List<Courseapply> queryCourseapproval(Courseapply courseapply);
}
