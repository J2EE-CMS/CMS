package com.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.course.dao.IRelationDao;
import com.course.entity.Relation;

public class RelationActionTest {

	private static IRelationDao relationDao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ApplicationContext cxt=new ClassPathXmlApplicationContext("/config/applicationContext.xml");
		relationDao = (IRelationDao) cxt.getBean("relationDao");
	}

	/*
	 * ‘› ±◊¢ ÕµÙ£¨±‹√‚÷ÿ∏¥≤Â»Î ˝æ›, µº÷¬≥ÂÕª
	@Test
	public void addRelation() {
		relationDao.addRelation(new Relation(22, "temp3", "temp3"));
	}*/
	
	/*
	@Test
	public void getAllRelations() {
		List<Relation> list = relationDao.getAllRelations();
		System.out.println(list.size());
		for(int i=0;i<list.size();i++){
			System.out.println( list.get(i).getId()+"\t"+list.get(i).getGrade()+"\t"+list.get(i).getDevtype()+
					"\t"+list.get(i).getType()+"\n");
		}
	}
	*/
	
	/*
	@Test
	public void modifyRelation() {
		relationDao.modifyRelation(new Relation(4,666,"fu","ck"));
		System.out.println("test");
	}
	*/
	
	@Test
	public void findByGrade() {
		List<Relation> list = relationDao.findByGrade(22);
		System.out.println(list.size());
		for(int i=0;i<list.size();i++){
			System.out.println( list.get(i).getId()+"\t"+list.get(i).getGrade()+"\t"+list.get(i).getDevtype()+
					"\t"+list.get(i).getType()+"\n");
		}
	}
}
