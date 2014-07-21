package com.course.service;

import java.util.List;

import com.course.entity.Subtype;

public interface ISubtypeManage {
	public void addSubtype(Subtype subtype);
	public void deleteSubtype(Integer id);
	public void modifySubtype(Subtype subtype);
	public List<Subtype> getAllSubtypes();
	public List<Subtype> findBySubtypename(String name);
	public List<Subtype> findByBelongtotype(String name);
	public List<Subtype> findByDepartment(String name);
}

