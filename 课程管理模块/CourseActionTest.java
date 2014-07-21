package com.coursemanage.action;

import static org.junit.Assert.*;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.coursemanage.entity.Course;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:/config/applicationContext-beans.xml",
		"classpath:/config/applicationContext-common.xml"})
public class CourseActionTest {
	@Resource
	private CourseAction courseAction;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	//@Test
	public void testAddCourse() {
		Course cos = new Course();
		cos.setC_course_name("cname");
		courseAction.setCos(cos);		
		courseAction.addCourse();
	}

//	@Test
	public void testModifyCourse() {
		Course cos = new Course();
		cos.setId(3);
		cos.setC_course_name("CNAMEFORSE305");
		courseAction.setCos(cos);	
		courseAction.modifyCourse();
	}

	@Test
	public void testDeleteCourse() {
		Course cos = new Course();
		cos.setC_course_name("cname");
		courseAction.setCos(cos);	
		courseAction.deleteCourse();
	}

//	@Test
	public void testQueryCourse() {
		Course cos = new Course();
		courseAction.setCos(cos);	
		courseAction.setBegin_time(new Date());
		courseAction.setEnd_time(new Date());
		//courseAction.getCos().setInstitute_course("institute_course");
		
		courseAction.queryCourse();
	}

}
