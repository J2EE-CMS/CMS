package com.course.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;




import com.course.entity.Subtype;
import com.course.service.ISubtypeManage;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class SubtypeAction extends ActionSupport  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Subtype subtype;
	private List<Subtype> subtypeList;
	
	@Resource
	private ISubtypeManage subtypeManage;
	
	public void setISubtypeManage (ISubtypeManage subtypeManage) {
		this.subtypeManage = subtypeManage;
	}
	
	public ISubtypeManage getISubtypeManage() {
		return subtypeManage;
	}
	
	public Subtype getSubtype() {
		return subtype;
	}

	public void setSubtype(Subtype subtype) {
		this.subtype = subtype;
	}

	
	public List<Subtype> getSubtypeList() {
		return subtypeList;
	}

	public void setSubtypeList(List<Subtype> subtypeList) {
		this.subtypeList = subtypeList;
	}

	//Methods
	public String addSubtype()
	{		
		subtypeManage.addSubtype(subtype);
		return "success";
	}
	
	public String deleteSubtype()
	{
		subtypeManage.deleteSubtype(subtype);
		return "success";
	}
	
	public String modifySubtype()
	{
		subtypeManage.modifySubtype(subtype);
		return "success";
	}

	public String querySubtypes(){
		setSubtypeList(subtypeManage.querySubtypes(subtype));
		return "querySubtypes";
	}
	
	public String getAllSubtypes(){
		setSubtypeList(subtypeManage.getAllSubtypes());
		return "allsubtype";
	}

}
