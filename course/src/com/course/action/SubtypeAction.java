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
	private Integer id;
	private List<Subtype> subtypeList;
	private List<Subtype> findBySubtypenameList;
	private List<Subtype> findByBelongtotypeList;
	private List<Subtype> findByDepartmentList;

	
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

	public List<Subtype> getFindBySubtypenameList() {
		return findBySubtypenameList;
	}

	public void setFindBySubtypenameList(List<Subtype> findBySubtypenameList) {
		this.findBySubtypenameList = findBySubtypenameList;
	}

	public List<Subtype> getFindByBelongtotypeList() {
		return findByBelongtotypeList;
	}

	public void setFindByBelongtotypeList(List<Subtype> findByBelongtotypeList) {
		this.findByBelongtotypeList = findByBelongtotypeList;
	}

	public List<Subtype> getFindByDepartmentList() {
		return findByDepartmentList;
	}

	public void setFindByDepartmentList(List<Subtype> findByDepartmentList) {
		this.findByDepartmentList = findByDepartmentList;
	}

	//·½·¨
	public String addSubtype()
	{		
		subtypeManage.addSubtype(subtype);
		return "success";
	}
	
	public String deleteSubtype()
	{
		subtypeManage.deleteSubtype(id);
		return "success";
	}
	
	public String modifySubtype()
	{
		subtypeManage.modifySubtype(subtype);
		return "success";
	}
	
	public String getAllSubtypes(){
		setSubtypeList(subtypeManage.getAllSubtypes());
		return "allsubtype";
	}
	
	public String findBySubtypename(String name){
		setFindBySubtypenameList(subtypeManage.findBySubtypename(name));
		return "success";
	}
	
	public String findByBelongtotype(String name){
		setFindByBelongtotypeList(subtypeManage.findByBelongtotype(name));
		return "success";
	}
	
	public String findByDepartment(String name){
		setFindByDepartmentList(subtypeManage.findByDepartment(name));
		return "success";
	}


}
