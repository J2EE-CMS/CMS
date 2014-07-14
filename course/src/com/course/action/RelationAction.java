package com.course.action;

import javax.annotation.Resource;

import com.course.entity.Relation;
import com.course.service.IRelationManage;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

public class RelationAction extends ActionSupport {
	
	private Relation relation;
	
	private List<Relation> relations;
	
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
	
	/*   -----------------     分割线          -----------------------*/
	
	public List<Relation> getAllRelations() {
		//relationManage.getAllRelations(relation);
		return relations;
	}

	
	/*   -----------------     分割线          -----------------------*/
	//test
	public String addRelation() {
		relationManage.addRelation(relation);
		return "success";
	}
		
}
