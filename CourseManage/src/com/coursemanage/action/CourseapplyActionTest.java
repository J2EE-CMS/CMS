package com.coursemanage.action;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.coursemanage.dao.ICourseapplyDao;
import com.coursemanage.entity.Courseapply;

public class CourseapplyActionTest {

	private static ICourseapplyDao courseapplyDao;
	private static Courseapply courseapply;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		//ApplicationContext cxt=new ClassPathXmlApplicationContext("/config/applicationContext.xml");
		//courseapplyDao = (ICourseapplyDao) cxt.getBean("courseapplyDao");
		String[] configs = {"/config/applicationContext-beans.xml","/config/applicationContext-common.xml"};
		ApplicationContext cxt = new ClassPathXmlApplicationContext(configs);
		courseapplyDao = (ICourseapplyDao) cxt.getBean("courseapplyDao");
	}

	/*
	@Test
	public void addCourseapply() {
		courseapplyDao.addCourseapply(new Courseapply(5,2,null,null,1,"q","w","e","r",1,1,1,1,"t","Y","u","i",false));
	}
	*/
	
	/*
	@Test
	public void queryAllCourseapply() {
		List<Courseapply> list = courseapplyDao.queryAllCourseapply();
		System.out.println(list.size());
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i).getId() + "\t" + list.get(i).getStatus() + "\n");
		}
	}
	*/
	
	
	@Test
	public void queryAllCourseapproval(){
		List<Courseapply> list = courseapplyDao.queryAllCourseapproval();
		System.out.println(list.size());
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i).getId() + "\t" + list.get(i).getStatus() + "\n");
		}
	}
	
	
	/*
	@Test 
	public void approvalCourseapply(){
		
	}
	*/
}
