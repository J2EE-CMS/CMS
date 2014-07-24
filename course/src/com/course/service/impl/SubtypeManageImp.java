package com.course.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.course.dao.ISubtypeDao;
import com.course.entity.Subtype;
import com.course.service.ISubtypeManage;

public class SubtypeManageImp implements ISubtypeManage {
	
	@Resource
	private ISubtypeDao subtypeDao;
	
	public ISubtypeDao getSubtypeDao() {
		return subtypeDao;
	}
	
	public void setSubtypeDao (ISubtypeDao subtypeDao) {
		this.subtypeDao = subtypeDao;
	}
	
	@Override
	public void addSubtype(Subtype subtype) {
		subtypeDao.addSubtype(subtype);
	}
	
	@Override
	public void deleteSubtype (Subtype subtype) {
		subtypeDao.deleteSubtype (subtype);
	}
	
	@Override
	public void modifySubtype (Subtype subtype) {
		subtypeDao.modifySubtype (subtype);
	}

	@Override
	public List<Subtype> querySubtypes(Subtype subtype){
		return subtypeDao.querySubtypes(subtype);
	}
	
	@Override
	public List<Subtype> getAllSubtypes(){
		return subtypeDao.getAllSubtypes();
	}
	
}
