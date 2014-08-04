package com.test;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.course.action.RelationAction;
import com.course.entity.Relation;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:/config/applicationContext-beans.xml",
		"classpath:/config/applicationContext-common.xml"})

public class RelationActionTest {

	//private static IRelationDao relationDao;
	
	@Resource
	private RelationAction test;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		//ApplicationContext cxt=new ClassPathXmlApplicationContext("/config/applicationContext.xml");
		//relationDao = (IRelationDao) cxt.getBean("relationDao");
	}

	
	//@Test
	public void addRelation() {
		Relation temp = new Relation();
		temp.setGrade(3);
		temp.setDevtype("1");
		temp.setType(2);
		
		test.setRelation(temp);
		test.addRelation();
	}

	
	
	//@Test
	public void getAllRelations() {
		test.getAllRelations();
		List<Relation> list = test.getRelations();
		
		System.out.println("size of the list: " + list.size());
		for(int i=0;i<list.size();i++){
			System.out.println( list.get(i).getId()+"\t"+list.get(i).getGrade()+"\t"+list.get(i).getDevtype()+
					"\t"+list.get(i).getType()+"\n");
		}
	}
	
	
	
	//@Test
	public void modifyRelation() {
		Relation temp = new Relation();
		temp.setGrade(3);
		temp.setDevtype("3");
		temp.setId(3);
		test.setRelation(temp);
		test.modifyRelation();
	}
	
	
	
	//@Test
	public void findByGrade() {
		Relation temp = new Relation();
		temp.setGrade(2);
		test.setRelation(temp);
		test.findByGrade();
		
		List<Relation> list = test.getRelations();
		for(int i=0;i<list.size();i++){
			System.out.println( list.get(i).getId()+"\t"+list.get(i).getGrade()+"\t"+list.get(i).getDevtype()+
					"\t"+list.get(i).getType()+"\n");
		}
		
	}
	
}
