package com.course.service;

import java.util.List;

import javax.annotation.Resource;

import com.course.dao.ISubtypemoduleDao;
import com.course.entity.Subtypemodule;

public class SubtypemoduleManageImp implements ISubtypemoduleManage {
	
	@Resource
	private ISubtypemoduleDao subtypemoduleDao;
	
	public ISubtypemoduleDao getSubtypemoduleDao() {
		return subtypemoduleDao;
	}
	
	public void setSubtypemoduleDao (ISubtypemoduleDao subtypemoduleDao) {
		this.subtypemoduleDao = subtypemoduleDao;
	}
	
	@Override
	public void addSubtypemodule (Subtypemodule subtypemodule) {
		subtypemoduleDao.addSubtypemodule (subtypemodule);
	}
	
	@Override
	public void deleteSubtypemodule (Integer id) {
		subtypemoduleDao.deleteSubtypemodule (id);
	}
	
	@Override
	public void modifySubtypemodule (Subtypemodule subtypemodule) {
		subtypemoduleDao.modifySubtypemodule (subtypemodule);
	}
	
	@Override
	public List<Subtypemodule> getAllSubtypemodules(){
		return subtypemoduleDao.getAllSubtypemodules();
	}
	
}
