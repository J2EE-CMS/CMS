package com.course.service;

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
		coursetypeDao.AddCoursetype (coursetype);
	}
	
	@Override
	public void deleteCoursetype (Coursetype coursetype) {
		coursetypeDao.deleteCoursetype (coursetype);
	}
	
	@Override
	public void modifyCoursetype (Coursetype coursetype) {
		coursetypeDao.modifyCoursetype (coursetype);
	}
	
}
