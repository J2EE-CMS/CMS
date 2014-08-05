package com.course.action;

import javax.annotation.Resource;

import com.course.entity.Relation;
import com.course.service.IRelationManage;
import com.opensymphony.xwork2.ActionSupport;

import java.util.ArrayList;
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

	public List<Relation> getRelations() {
		return relations;
	}

	public void setRelations(List<Relation> relations) {
		this.relations = relations;
	}

	public IRelationManage getRelationManage() {
		return relationManage;
	}

	public void setRelationManage(IRelationManage relationManage) {
		this.relationManage = relationManage;
	}
	
	
	/*   -----------------     ·Ö¸îÏß          -----------------------*/
	
	

	public String getAllRelations() {
		//relationManage.getAllRelations(relation);
		relations = new ArrayList<Relation>();
		relations = relationManage.getAllRelations();
		if(relations.isEmpty())
			System.out.println("return is null");
		return "allrelation";
	}

	public String modifyRelation() {
		if((relation.getId()==0) || (relation.getType() == 0) || (relation.getGrade() == 0) || (relation.getDevtype() == null))
			System.out.println("error input");
		relationManage.modifyRelation(relation);
		return "success";
	}
	
	public String addRelation() {
		if((relation.getId()==0) || (relation.getType() == 0) || (relation.getGrade() == 0) || (relation.getDevtype() == null))
			System.out.println("error input");
		relationManage.addRelation(relation);
		return "success";
	}
		
	public String findByGrade() {
		relations = new ArrayList<Relation>();
		relations = relationManage.findByGrade(relation);
		if(relations.isEmpty())
			System.out.println("return is null");
		return "queryrelation";
	}
}
