package com.course.action;

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
		@SuppressWarnings("resource")
		ApplicationContext cxt=new ClassPathXmlApplicationContext("/config/applicationContext.xml");
		coursetypeDao = (ICoursetypeDao) cxt.getBean("coursetypeDao");
	}

	/*  -----------------  π¶ƒ‹≤‚ ‘     --------------------  */
	/*
	 * ◊¢ ÕµÙ£¨±‹√‚≤‚ ‘ ±”∞œÏ∆‰À˚ ˝æ›
	@Test
	public void addCoursetype() {
		coursetypeDao.addCoursetype(new Coursetype(null,"temp10", "temp20","temp30","temp40","temp50"));
	}
	 */
	
	
	@Test
	public void modifyCoursetype() {
		//coursetypeDao.modifyCoursetype(new Coursetype(1,"te","sda","c","k","sad"));
		System.out.println("modify success!");
	}
	
	
	@Test
	public void getAllCoursetypes() {
		List<Coursetype> list = coursetypeDao.getAllCoursetypes();
		System.out.println(list.size());
		for(int i=0;i<list.size();i++){
			System.out.println( list.get(i).getId()+"\t"+list.get(i).getTypecore()+"\t"+list.get(i).getType()+
					"\t"+list.get(i).getQuality()+"\t"+list.get(i).getReexamine()+"\t"+list.get(i).getRetake()+"\n");
		}
	}
	
	/*
	 * ◊¢ ÕµÙ£¨±‹√‚÷ÿ∏¥…æ≥˝Õ¨“ª◊÷∂Œ±®¥Ì
	@Test
	public void deleteCoursetype() {
		coursetypeDao.deleteCoursetype(12);
	}
	*/
	/*  -----------------  π¶ƒ‹≤‚ ‘Ω· ¯     --------------------  */
	
	
	
	/*  -----------------  “Ï≥£≤‚ ‘ ‰»Î≤‚ ‘  [¥˝≤π]   --------------------  */
	/*  -----------------  “Ï≥£≤‚ ‘ ‰»Î≤‚ ‘Ω· ¯     --------------------  */

}
