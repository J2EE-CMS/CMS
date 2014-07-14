package com.course.service;

import java.util.List;

import javax.annotation.Resource;

import com.course.dao.ICoursetypeDao;
import com.course.entity.Coursetype;

public class CoursetypeManageImp implements ICoursetypeManage {
	
	@Resource
	private ICoursetypeDao coursetypeDao;
	
	public ICoursetypeDao getCoursetypeDao() {
		return coursetypeDao;
	}
	
	public void setCoursetypeDao (ICoursetypeDao coursetypeDao) {
		this.coursetypeDao = coursetypeDao;
	}
	
	@Override
	public void addCoursetype (Coursetype coursetype) {
		coursetypeDao.addCoursetype (coursetype);
	}
	
	@Override
	public void deleteCoursetype (Integer id) {
		coursetypeDao.deleteCoursetype (id);
	}
	
	@Override
	public void modifyCoursetype (Coursetype coursetype) {
		coursetypeDao.modifyCoursetype (coursetype);
	}
	
	@Override
	public List<Coursetype> getAllCoursetypes(){
		return coursetypeDao.getAllCoursetypes();
	}
	
}
