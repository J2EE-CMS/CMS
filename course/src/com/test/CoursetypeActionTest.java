package com.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.course.action.CoursetypeAction;
import com.course.dao.ICoursetypeDao;
import com.course.entity.Coursetype;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:/config/applicationContext-beans.xml",
		"classpath:/config/applicationContext-common.xml"})
public class CoursetypeActionTest {
	@Resource
	private  CoursetypeAction test;
	//private static ICoursetypeDao coursetypeDao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		//@SuppressWarnings("resource")
		//String[] configs = {"/config/applicationContext-beans.xml","/config/applicationContext-common.xml"};
		//ApplicationContext cxt = new ClassPathXmlApplicationContext(configs);
	//	coursetypeDao = (ICoursetypeDao) cxt.getBean("coursetypeDao");
	}

	/*  -----------------  π¶ƒ‹≤‚ ‘     --------------------  */
	/* ◊¢ ÕµÙ£¨±‹√‚≤‚ ‘ ±”∞œÏ∆‰À˚ ˝æ› */
	//@Test
	public void addCoursetype() {
		//test =  new CoursetypeAction();
		Coursetype temp = new Coursetype();
		temp.setId(3);
		temp.setTypecore("sd");
		temp.setQuality("d");
		temp.setType("sss");
		temp.setReexamine("false");
		temp.setRetake("true");
		test.setCoursetype(temp);
		test.addCoursetype();
	}
	 
	
	
	//@Test
	public void modifyCoursetype() {
		Coursetype temp = new Coursetype();
		temp.setId(1);
		temp.setTypecore("a");
		temp.setQuality("b");
		temp.setType("c");
		temp.setReexamine("true");
		temp.setRetake("false");
		test.setCoursetype(temp);
		test.modifyCoursetype();
	}
	
	
	//@Test
	public void getAllCoursetypes() {
		test.getAllCoursetypes();
		List<Coursetype> list = test.getCoursetypes();
		System.out.println(list.size());
		for(int i=0;i<list.size();i++){
			System.out.println( list.get(i).getId()+"\t"+list.get(i).getTypecore()+"\t"+list.get(i).getType()+
					"\t"+list.get(i).getQuality()+"\t"+list.get(i).getReexamine()+"\t"+list.get(i).getRetake()+"\n");
		}
	}
	
	
	//@Test
	public void deleteCoursetype() {
		Coursetype temp = new Coursetype();
		temp.setId(1);
		test.setCoursetype(temp);
		test.modifyCoursetype();
	}
	
	
	//@Test
	public void getExcel(){
		
	}
	
	/*  -----------------  π¶ƒ‹≤‚ ‘Ω· ¯     --------------------  */
	
	
	
	/*  -----------------  “Ï≥£≤‚ ‘ ‰»Î≤‚ ‘  [¥˝≤π]   --------------------  */
	/*  -----------------  “Ï≥£≤‚ ‘ ‰»Î≤‚ ‘Ω· ¯     --------------------  */

}
