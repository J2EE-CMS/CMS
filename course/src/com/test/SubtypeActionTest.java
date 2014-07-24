package com.test;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.course.dao.ISubtypeDao;
import com.course.entity.Subtype;

public class SubtypeActionTest {

	private static ISubtypeDao subtypeDao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		@SuppressWarnings("resource")
		ApplicationContext ctx=new ClassPathXmlApplicationContext("/config/applicationContext.xml");
		subtypeDao = (ISubtypeDao) ctx.getBean("subtypeDao");
	}

	
	@Test
	public void addSubtype() {
		//subtypeDao.addSubtype(new Subtype(null, "课程类别细类码5", "核心通识","公选","是","管院"));
	}
	
	
	/*
	@Test
	public void modifySubtype() {
		subtypeDao.modifySubtype(new Subtype(2,"类别细类码9", "一般通识","公选","否","管院"));
		System.out.println("test");
	}
	*/
	
	/*
	@Test
	public void deleteSubtype() {
		subtypeDao.deleteSubtype(97);
	}
	*/
	
	@Test
	public void getAllSubtypes() {
		List<Subtype> list = subtypeDao.getAllSubtypes();
		System.out.println("<-- getAllSubtypes() -->");
		System.out.println(list.size());
		for(int i=0;i<list.size();i++){
			System.out.println( list.get(i).getId()+"\t"+list.get(i).getSubtypecode()+"\t"+list.get(i).getSubtypename()+
					"\t"+list.get(i).getBelongtotype()+"\t"+list.get(i).getIspublicsubtype()+"\t"+list.get(i).getDepartment()+"\n");
		}
	}
	
	
	@Test
	public void findBySubtypename(){
		List<Subtype> list = subtypeDao.findBySubtypename(new String("通识"));
		System.out.println("<-- findBySubtypename() -->");
		System.out.println(list.size());
        for(Subtype subtype:list){  
            System.out.println(subtype.getId()+"\t"+subtype.getSubtypecode()+"\t"+subtype.getSubtypename()+
					"\t"+subtype.getBelongtotype()+"\t"+subtype.getIspublicsubtype()+"\t"+subtype.getDepartment()+"\n");  
        } 
	}

	
	@Test
	public void findByBelongtotype(){
		List<Subtype> list = subtypeDao.findByBelongtotype(new String("专选"));
		System.out.println("<-- findByBelongtotype() -->");
		System.out.println(list.size());
        for(Subtype subtype:list){  
            System.out.println(subtype.getId()+"\t"+subtype.getSubtypecode()+"\t"+subtype.getSubtypename()+
					"\t"+subtype.getBelongtotype()+"\t"+subtype.getIspublicsubtype()+"\t"+subtype.getDepartment()+"\n");  
        } 
	}
	
	@Test
	public void findByDepartment(){
		List<Subtype> list = subtypeDao.findByDepartment(new String("软院"));
		System.out.println("<-- findByDepartment() -->");
		System.out.println(list.size());
        for(Subtype subtype:list){  
            System.out.println(subtype.getId()+"\t"+subtype.getSubtypecode()+"\t"+subtype.getSubtypename()+
					"\t"+subtype.getBelongtotype()+"\t"+subtype.getIspublicsubtype()+"\t"+subtype.getDepartment()+"\n");  
        } 
	}
}
