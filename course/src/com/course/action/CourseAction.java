package com.course.action;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.course.entity.Course;
import com.course.entity.Courseapply;
import com.course.service.ICourseManage;
import com.course.util.ExportExcelUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CourseAction extends ActionSupport {
	private Course cos;
	private Date begin_time, end_time;
	private List<Course> allCourse;

	@Resource
	private ICourseManage courseManage;

	public List<Course> getAllCourse() {
		return allCourse;
	}

	public void setAllCourse(List<Course> allCourse) {
		this.allCourse = allCourse;
	}

	public Date getBegin_time() {
		return begin_time;
	}

	public void setBegin_time(Date begin_time) {
		this.begin_time = begin_time;
	}

	public Date getEnd_time() {
		return end_time;
	}

	public void setEnd_time(Date end_time) {
		this.end_time = end_time;
	}

	public Course getCos() {
		return cos;
	}

	public void setCos(Course cos) {
		this.cos = cos;
	}

	public ICourseManage getCourseManage() {
		return courseManage;
	}

	public void setCourseManage(ICourseManage courseManage) {
		this.courseManage = courseManage;
	}

	public String addCourse() {
		System.out.println("-------CourseAction.addCourse------");
		courseManage.addCourse(cos);
		return "success";
	}

	public String modifyCourse() {
		System.out.println("-------CourseAction.modifyCourse------");
		courseManage.modifyCourse(cos);
		return "success";
	}

	public String deleteCourse() {
		System.out.println("-------CourseAction.deleteCourse------");
		courseManage.deleteCourse(cos);
		return "success";
	}

	public String queryCourse() {
		System.out.println("-------courseAction.queryCourse------");
		allCourse = courseManage.queryCourse(cos, begin_time, end_time);
		ActionContext.getContext().getSession().put("table",allCourse);
		return "success";
	}

	public String findAllCourse() {
		System.out.println("-------courseAction.findAllCourse------");
		allCourse = courseManage.findAllCourse();
		ActionContext.getContext().getSession().put("table",allCourse);
		return "allcourse";
	}
	
	public String QueryCourseapplyOutputToExcel(){
		List<Course> tem = (List<Course>)ActionContext.getContext().getSession().get("table");
		//courseapplys = new ArrayList<Courseapply>();
		//courseapplys = courseapplyManage.queryCourseapply(courseapply);
		
		ExportExcelUtil ex = new ExportExcelUtil();
		String title = "课程库管理";
		String[] headers = { "序号","课程中文名","院系课程号","课程英文名","课程简称","开设单位","学分","课程细类模块","课程细类","课程类别","总学时","总学时描述","简介","课程负责人","是否学位课","备注"};
        List<String[]> dataset = new ArrayList<String[]>(); 
        for(int i=0;i<tem.size();i++) {
        	Course temp = tem.get(i); 
        	dataset.add(new String[]{temp.getId() +"",temp.getC_course_name() + "",temp.getInstitute_course() + "",temp.getE_course_name()+ "",temp.getBrief_course_name()+ "",temp.getFaculty() + "",temp.getCredit() + "",temp.getSubtypemodule().getId() + "",temp.getSubtype().getId() + "",temp.getCoursetype().getId() +"",temp.getCourse_time() + "",temp.getCourse_time_info() + "",temp.getCourse_info() + "",temp.getCourse_head() + "",temp.returnDegree() +"",temp.getInfo()});
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
        HttpServletResponse response = null;//创建一个HttpServletResponse对象 
		OutputStream out = null;//创建一个输出流对象 
		try { 
			response = ServletActionContext.getResponse();//初始化HttpServletResponse对象 
			out = response.getOutputStream();//
			response.setHeader("Content-disposition","attachment; filename="+"Course.xls");//filename是下载的xls的名，建议最好用英文 
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
