package com.course.dao;

import com.course.entity.Relation;

import java.util.List;

public interface IRelationDao {
	public void modifyRelation(Relation relation);
	

	public List<Relation> getAllRelations();
	public List<Relation> findByGrade(Integer grade);
	
	//test
	public void addRelation(Relation relation);
}
