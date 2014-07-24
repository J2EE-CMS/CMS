package com.course.service;

import java.util.List;

import com.course.entity.Subtype;

public interface ISubtypeManage {
	public void addSubtype(Subtype subtype);
	public void deleteSubtype(Subtype subtype);
	public void modifySubtype(Subtype subtype);
	public List<Subtype> querySubtypes(Subtype subtype);
	public List<Subtype> getAllSubtypes();
}

