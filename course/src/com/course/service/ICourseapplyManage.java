package com.course.service;

import java.util.List;

import com.course.entity.Courseapply;

public interface ICourseapplyManage {
	public void addCourseapply(Courseapply courseapply);
	public void modifyCourseapply(Courseapply courseapply);
	public void deleteCourseapply(Courseapply courseapply);
	public List<Courseapply> queryAllCourseapply();
	public void modifycommitCourseapply(Courseapply courseapply);
	public List<Courseapply> queryCourseapply(Courseapply courseapply);
	
	public List<Courseapply> queryAllCourseapproval();
	public void modifyapprovalCourseapply(Courseapply courseapply);
	public List<Courseapply> queryCourseapproval(Courseapply courseapply);
}
