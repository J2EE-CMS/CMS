package com.course.dao;

import java.util.List;

import com.course.entity.Coursetype;
import com.course.entity.Subtypemodule;

public interface ISubtypemoduleDao {
	public void addSubtypemodule(Subtypemodule subtypemodule);
	public void deleteSubtypemodule(Subtypemodule subtypemodule);
	public void modifySubtypemodule(Subtypemodule subtypemodule);
	public List<Subtypemodule> getAllSubtypemodules();
}

