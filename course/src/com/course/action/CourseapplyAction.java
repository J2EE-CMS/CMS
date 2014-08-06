package com.course.action;

import java.io.IOException;
import java.io.OutputStream;
import java.util.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.course.entity.Courseapply;
import com.course.entity.Coursetype;
import com.course.service.ICourseapplyManage;
import com.course.util.ExportExcelUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CourseapplyAction extends ActionSupport{
	private Courseapply courseapply;
	List<Courseapply> courseapplys;
	
	private String Cname;
	
	public String getCname() {
		return Cname;
	}

	public void setCname(String cname) {
		Cname = cname;
	}

	@Resource
	private ICourseapplyManage courseapplyManage;
	

	public Courseapply getCourseapply() {
		return courseapply;
	}

	public void setCourseapply(Courseapply courseapply) {
		this.courseapply = courseapply;
	}

	public ICourseapplyManage getCourseapplyManage() {
		return courseapplyManage;
	}

	public void setCourseapplyManage(ICourseapplyManage courseapplyManage) {
		this.courseapplyManage = courseapplyManage;
	}
	
	public List<Courseapply> getCourseapplys() {
		return courseapplys;
	}

	public void setCourseapplys(List<Courseapply> courseapplys) {
		this.courseapplys = courseapplys;
	}
	
	
	public String addCourseapply(){
		courseapplyManage.addCourseapply(courseapply);
		
		return "success";
	}
	
	public String modifyCourseapply(){
		courseapplyManage.modifyCourseapply(courseapply);
		return "success";
	}
	
	public String deleteCourseapply(){
		courseapplyManage.deleteCourseapply(courseapply);
		return "success";
	}
	
	public String queryAllCourseapply(){
		courseapplys = new ArrayList<Courseapply>();
		courseapplys = courseapplyManage.queryAllCourseapply();
	
		ActionContext.getContext().getSession().put("table",courseapplys);
		//Courseapply temp;
		
		return "allcourseapply";
	}

	
	public String modifycommitCourseapply(){
		courseapplyManage.modifycommitCourseapply(courseapply);
		return "success";
	}
	
	public String queryCourseapply(){
		courseapplys = new ArrayList<Courseapply>();
		courseapplys = courseapplyManage.queryCourseapply(courseapply);
		ActionContext.getContext().getSession().put("table",courseapplys);
		return "queryCourseapply";
	}
	
	public String QueryCourseapplyOutputToExcel(){
		List<Courseapply> tem = (List<Courseapply>)ActionContext.getContext().getSession().get("table");
		//courseapplys = new ArrayList<Courseapply>();
		//courseapplys = courseapplyManage.queryCourseapply(courseapply);
		
		ExportExcelUtil ex = new ExportExcelUtil();
		String title = "�γ̿�����";
		String[] headers = { "���","�γ�������","Ժϵ�γ̺�","�γ�Ӣ����","�γ̼��","���赥λ","ѧ��","�γ�ϸ��ģ��","�γ�ϸ��","�γ����","��ѧʱ","��ѧʱ����","���","�γ̸�����","�Ƿ�ѧλ��"};
        List<String[]> dataset = new ArrayList<String[]>(); 
        for(int i=0;i<tem.size();i++) {
        	Courseapply temp = tem.get(i); 
        	dataset.add(new String[]{temp.getId() +"",temp.getC_course_name() + "",temp.getInstitute_course() + "",temp.getE_course_name()+ "",temp.getBrief_course_name()+ "",temp.getFaculty() + "",temp.getCredit() + "",temp.getSubtypemodule().getId() + "",temp.getSubtype().getId() + "",temp.getCoursetype().getId() +"",temp.getCourse_time() + "",temp.getCourse_time_info() + "",temp.getCourse_info() + "",temp.getCourse_head() + "",temp.getDegree()});
        }
        /*
        OutputStream out = null;
		try {
			out = new FileOutputStream("C://output.xls");
			ex.exportExcel(title,headers, dataset, out);
		    out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		*/
        HttpServletResponse response = null;//����һ��HttpServletResponse���� 
		OutputStream out = null;//����һ����������� 
		try { 
			response = ServletActionContext.getResponse();//��ʼ��HttpServletResponse���� 
			out = response.getOutputStream();//
			response.setHeader("Content-disposition","attachment; filename="+"Courseapply.xls");//filename�����ص�xls���������������Ӣ�� 
			response.setContentType("application/msexcel;charset=UTF-8");//�������� 
			response.setHeader("Pragma","No-cache");//����ͷ 
			response.setHeader("Cache-Control","no-cache");//����ͷ 
			response.setDateHeader("Expires", 0);//��������ͷ  
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
	
	/*  ========  ��������    ========  */
	public String queryAllCourseapproval(){
		courseapplys = new ArrayList<Courseapply>();
		courseapplys = courseapplyManage.queryAllCourseapproval();
		ActionContext.getContext().getSession().put("table",courseapplys);
		return "success";
	}
	
	public String modifyapprovalCourseapply(){
		courseapplyManage.modifyapprovalCourseapply(courseapply);
		return "success";
	}
	
	public String queryCourseapproval(){
		courseapplys = new ArrayList<Courseapply>();
		courseapplys = courseapplyManage.queryCourseapproval(courseapply);
		ActionContext.getContext().getSession().put("table",courseapplys);
		return "queryCourseapproval";
	}
	
	public String QueryCourseapprovalOutputToExcel(){
		List<Courseapply> tem = (List<Courseapply>)ActionContext.getContext().getSession().get("table");
		
		ExportExcelUtil ex = new ExportExcelUtil();
		String title = "�γ̿�����";
		String[] headers = { "���","�γ�������","Ժϵ�γ̺�","�γ�Ӣ����","�γ̼��","���赥λ","ѧ��","�γ�ϸ��ģ��","�γ�ϸ��","�γ����","��ѧʱ","��ѧʱ����","���","�γ̸�����","�Ƿ�ѧλ��"};
        List<String[]> dataset = new ArrayList<String[]>(); 
        for(int i=0;i<tem.size();i++) {
        	Courseapply temp = tem.get(i); 
        	dataset.add(new String[]{temp.getId() +"",temp.getC_course_name() + "",temp.getInstitute_course() + "",temp.getE_course_name()+ "",temp.getBrief_course_name()+ "",temp.getFaculty() + "",temp.getCredit() + "",temp.getSubtypemodule().getId() + "",temp.getSubtype().getId() + "",temp.getCoursetype().getId() +"",temp.getCourse_time() + "",temp.getCourse_time_info() + "",temp.getCourse_info() + "",temp.getCourse_head() + "",temp.getDegree()});
        }
        /*
        OutputStream out = null;
		try {
			out = new FileOutputStream("C://output.xls");
			ex.exportExcel(title,headers, dataset, out);
		    out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		*/
        HttpServletResponse response = null;//����һ��HttpServletResponse���� 
		OutputStream out = null;//����һ����������� 
		try { 
			response = ServletActionContext.getResponse();//��ʼ��HttpServletResponse���� 
			out = response.getOutputStream();//
			response.setHeader("Content-disposition","attachment; filename="+"Courseapproval.xls");//filename�����ص�xls���������������Ӣ�� 
			response.setContentType("application/msexcel;charset=UTF-8");//�������� 
			response.setHeader("Pragma","No-cache");//����ͷ 
			response.setHeader("Cache-Control","no-cache");//����ͷ 
			response.setDateHeader("Expires", 0);//��������ͷ  
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
