package com.course.service;

import java.util.List;

import com.course.entity.Subtypemodule;

public interface ISubtypemoduleManage {
	public void addSubtypemodule(Subtypemodule subtypemodule);
	public void deleteSubtypemodule(Subtypemodule subtypemodule);
	public void modifySubtypemodule(Subtypemodule subtypemodule);
	public List<Subtypemodule> getAllSubtypemodules();
}

