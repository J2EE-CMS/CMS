package com.course.action;

import java.util.*;

import javax.annotation.Resource;

import java.io.*;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import java.util.List;

import com.course.entity.Coursetype;
import com.course.service.ICoursetypeManage;
import com.course.util.ExportExcelUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


public class CoursetypeAction extends ActionSupport  {
	
	private Coursetype coursetype;
	private List<Coursetype> coursetypes;
	
	@Resource
	private ICoursetypeManage coursetypeManage;
		
	public Coursetype getCoursetype() {
		return coursetype;
	}

	public void setCoursetype(Coursetype coursetype) {
		this.coursetype = coursetype;
	}

	public List<Coursetype> getCoursetypes() {
		return coursetypes;
	}

	public void setCoursetypes(List<Coursetype> coursetypes) {
		this.coursetypes = coursetypes;
	}

	public ICoursetypeManage getCoursetypeManage() {
		return coursetypeManage;
	}

	public void setCoursetypeManage(ICoursetypeManage coursetypeManage) {
		this.coursetypeManage = coursetypeManage;
	}
	

	public String addCoursetype()
	{
		System.out.println("-------CoursetypeAction add------");
		if((coursetype.getId() == 0) || (coursetype.getType() == null)  || (coursetype.getQuality() == null)  ||  (coursetype.getSubtype() == null)  || (coursetype.getTypecore() == null))
			System.out.println("error input");
		coursetypeManage.addCoursetype(coursetype);
			
		return "success";
	}
	
	public String deleteCoursetype()
	{
		System.out.println("-------CoursetypeAction delete------");
		if(coursetype.getId() == 0)
			System.out.println("null input");
		coursetypeManage.deleteCoursetype(coursetype);
		return "success";
	}
	
	public String modifyCoursetype()
	{
		System.out.println("-------CoursetypeAction modify------");
		if((coursetype.getId() == 0) || (coursetype.getType() == null)  || (coursetype.getQuality() == null)  ||  (coursetype.getSubtype() == null)  || (coursetype.getTypecore() == null))
			System.out.println("error input");
		coursetypeManage.modifyCoursetype(coursetype);
		
		return "success";
	}
	
	public String getAllCoursetypes(){
		System.out.println("-------CoursetypeAction getAll------");
		coursetypes = coursetypeManage.getAllCoursetypes();
		ActionContext.getContext().getSession().put("table",coursetypes);
		if(coursetypes.isEmpty())
			System.out.println("return is null");
		return "allcoursetype";
	}
	
	
	public String QueryCoursetypeOutputToExcel(){
		System.out.println("-------CoursetypeAction output------");
		List<Coursetype> tem = (List<Coursetype>)ActionContext.getContext().getSession().get("table");
		//coursetypes = new ArrayList<Coursetype>();
		//coursetypes = coursetypeManage.getAllCoursetypes();
		
		ExportExcelUtil ex = new ExportExcelUtil();
        String title = "课程类别"; 
        String[] headers = { "序号","课程类别码","课程类别","课程性质","是否需要重考","是否需要重修"};
        List<String[]> dataset = new ArrayList<String[]>(); 
        for(int i=0;i<tem.size();i++) {
        	Coursetype temp = tem.get(i); 
        	dataset.add(new String[]{temp.getId() + "",temp.getTypecore()+ "",temp.getType()+ "",temp.getQuality()+ "",temp.getReexamine()+ "",temp.getRetake()});
        }
       
        HttpServletResponse response = null;//创建一个HttpServletResponse对象 
		OutputStream out = null;//创建一个输出流对象 
		try { 
			response = ServletActionContext.getResponse();//初始化HttpServletResponse对象 
			out = response.getOutputStream();//
			response.setHeader("Content-disposition","attachment; filename="+"Coursetype.xls");//filename是下载的xls的名，建议最好用英文 
			response.setContentType("application/msexcel;charset=UTF-8");//设置类型 
			response.setHeader("Pragma","No-cache");//设置头 
			response.setHeader("Cache-Control","no-cache");//设置头 
			response.setDateHeader("Expires", 0);//设置日期头  
			String rootPath = ServletActionContext.getServletContext().getRealPath("/");
			ex.exportExcel(rootPath,title,headers, dataset, out);
			out.flush();
		} catch (IOException e) { 
			e.printStackTrace(); 
		}finally{
			try{
				if(out!=null){ 
					out.close(); 
				}
			}catch(IOException e){ 
				e.printStackTrace(); 
			} 
		}
		return null;
	}
}
