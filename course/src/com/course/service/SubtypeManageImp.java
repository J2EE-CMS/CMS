package com.course.service;

import java.util.List;

import javax.annotation.Resource;

import com.course.dao.ISubtypeDao;
import com.course.entity.Subtype;

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
	public void deleteSubtype (Integer id) {
		subtypeDao.deleteSubtype (id);
	}
	
	@Override
	public void modifySubtype (Subtype subtype) {
		subtypeDao.modifySubtype (subtype);
	}
	
	@Override
	public List<Subtype> getAllSubtypes(){
		return subtypeDao.getAllSubtypes();
	}
	
	@Override
	public List<Subtype> findBySubtypename(String name){
		return subtypeDao.findBySubtypename(name);
	}
	
	@Override
	public List<Subtype> findByBelongtotype(String name){
		return subtypeDao.findByBelongtotype(name);
	}
	
	@Override
	public List<Subtype> findByDepartment(String name){
		return subtypeDao.findByDepartment(name);
	}
	
	
}
