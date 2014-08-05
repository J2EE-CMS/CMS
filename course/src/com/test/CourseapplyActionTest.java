package com.test;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.course.action.CourseapplyAction;
import com.course.entity.Course;
import com.course.entity.Courseapply;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:/config/applicationContext-beans.xml",
		"classpath:/config/applicationContext-common.xml"})

public class CourseapplyActionTest {

	@Resource
	CourseapplyAction test;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	
	}
	

	
	//@Test
	public void addCourseapply() {
		Courseapply temp = new Courseapply();
		temp.setStatus("´ýÉóÅú");
		temp.setC_course_name("e");
		temp.setBrief_course_name("ck");
		test.setCourseapply(temp);
		test.addCourseapply();
	}
	
	
	//@Test
	public void modifyCourseapply(){
		Courseapply temp = new Courseapply();
		//temp.setCourseapply(new Courseapply(4,0,null,null,0,"q","w","e","r",0,0,0,0,"t","Y","u","i","false"));
		test.setCourseapply(temp);
		test.modifyCourseapply();
	}
	
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
	
	/*
	@Test
	public void queryAllCourseapproval(){
		List<Courseapply> list = courseapplyDao.queryAllCourseapproval();
		System.out.println(list.size());
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i).getId() + "\t" + list.get(i).getStatus() + "\n");
		}
	}
	*/
	
	/*
	@Test 
	public void approvalCourseapply(){
		
	}
	*/
	
	
	//@Test
	public void queryCourseapply(){
		Courseapply temp = new Courseapply();
		//temp.setCourseapply(new Courseapply(0,0,null,null,0,"","","e","",0,0,0,0,"","","","",false));
		System.out.println("courseapply ename " + temp.getE_course_name());
		temp.setC_course_name("1");
		test.setCourseapply(temp);
	    test.queryCourseapply();
	    List<Courseapply> list = test.getCourseapplys();
	    for(Courseapply capp : list){
	      System.out.println(capp.getC_course_name()+' '+capp.getCourse_info());
	    }
	}
	
	@Test
		public void commitCourseapply(){
			Courseapply temp = new Courseapply();
			temp.setC_course_name("e");
			test.setCourseapply(temp);
			test.modifycommitCourseapply();
		}
	
	//@Test
	public void queryCourseapproval(){
		Courseapply temp = new Courseapply();
		temp.setC_course_name("test1");
		test.setCourseapply(temp);
		test.queryCourseapproval();
		List<Courseapply> list = test.getCourseapplys();
		for(Courseapply cappr : list){
			System.out.println(cappr.getC_course_name() + " " + cappr.getStatus());
		}
	}
	
}
