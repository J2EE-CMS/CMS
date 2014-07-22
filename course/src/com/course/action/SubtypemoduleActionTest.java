package com.course.action;

import java.util.List;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.course.dao.ISubtypemoduleDao;
import com.course.entity.Subtypemodule;

public class SubtypemoduleActionTest {

	private static ISubtypemoduleDao subtypemoduleDao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		@SuppressWarnings("resource")
		ApplicationContext cxt=new ClassPathXmlApplicationContext("/config/applicationContext.xml");
		subtypemoduleDao = (ISubtypemoduleDao) cxt.getBean("subtypemoduleDao");
	}

	
	@Test
	public void addSubtypemodule() {
	//	subtypemoduleDao.addSubtypemodule(new Subtypemodule(null, "temp1", "temp2","temp3","temp4","temp5","temp6"));
	}
	
	
//	@Test
	public void getAllSubtypemodules() {
		List<Subtypemodule> list = subtypemoduleDao.getAllSubtypemodules();
		System.out.println(list.size());
		for(int i=0;i<list.size();i++){
			System.out.println( list.get(i).getId()+"\t"+list.get(i).getModule_name()+"\t"+list.get(i).getSubtype_code()+
					"\t"+list.get(i).getSubtype_name()+"\t"+list.get(i).getCourse_type()+"\t"+list.get(i).getVersion()+"\t"+list.get(i).getPublic_subtype()+"\n");
		}
	}
	
	/*
	@Test
	public void modifySubtypemodule() {
		subtypemoduleDao.modifySubtypemodule(new Subtypemodule(2,"f","u","c","k","!", null));
		System.out.println("test");
	}
	*/
	/*
	@Test
	public void deleteSubtypemodule() {
		subtypemoduleDao.deleteSubtypemodule(3);
	}
	*/

}
