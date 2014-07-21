package com.course.dao;

import java.util.List;

import com.course.entity.Coursetype;
import com.course.entity.Subtypemodule;

public interface ISubtypemoduleDao {
	public void addSubtypemodule(Subtypemodule subtypemodule);
	public void deleteSubtypemodule(Integer id);
	public void modifySubtypemodule(Subtypemodule subtypemodule);
	public List<Subtypemodule> getAllSubtypemodules();
}

