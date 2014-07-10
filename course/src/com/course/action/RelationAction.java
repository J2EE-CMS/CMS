package com.course.action;

import javax.annotation.Resource;

import com.course.entity.Relation;
import com.course.service.IRelationManage;
import com.opensymphony.xwork2.ActionSupport;

public class RelationAction extends ActionSupport {
	
	private Relation relation;
	
	@Resource
	private IRelationManage relationManage;

	public Relation getRelation() {
		return relation;
	}

	public void setRelation(Relation relation) {
		this.relation = relation;
	}

	public IRelationManage getRelationManage() {
		return relationManage;
	}

	public void setRelationManage(IRelationManage relationManage) {
		this.relationManage = relationManage;
	}
	
	public String midifyRelation() {
		relationManage.modifyRelation(relation);
		return "success";
	}
	/*
	public String findRelation() {
		relationManage.findRelation(relation);
	}
	*/
	
	
	
	
	//test
	public String addRelation() {
		relationManage.addRelation(relation);
		return "success";
	}
		
}
