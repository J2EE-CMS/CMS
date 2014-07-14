package com.course.action;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.course.dao.ICoursetypeDao;
import com.course.entity.Coursetype;

public class CoursetypeActionTest {

	private static ICoursetypeDao coursetypeDao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ApplicationContext cxt=new ClassPathXmlApplicationContext("/config/applicationContext.xml");
		coursetypeDao = (ICoursetypeDao) cxt.getBean("coursetypeDao");
	}

	/*
	 * 注释掉，避免重复定义造成冲突
	@Test
	public void addRelation() {
		coursetypeDao.addCoursetype(new Coursetype("temp1", "temp2","temp3","temp4","temp5"));
	}
	*/
	
	@Test
	public void getAllCoursetypes() {
		List<Coursetype> list = coursetypeDao.getAllCoursetypes();
		System.out.println(list.size());
		for(int i=0;i<list.size();i++){
			System.out.println( list.get(i).getId()+"\t"+list.get(i).getTypecore()+"\t"+list.get(i).getType()+
					"\t"+list.get(i).getQuality()+"\t"+list.get(i).getReexamine()+"\t"+list.get(i).getRetake()+"\n");
		}
	}
	
	
	@Test
	public void modifyCoursetype() {
		coursetypeDao.modifyCoursetype(new Coursetype(2,"f","u","c","k","!"));
		System.out.println("test");
	}
	
	@Test
	public void deleteCoursetype() {
		coursetypeDao.deleteCoursetype(3);
	}
	

}
