package com.test;

import javax.annotation.Resource;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.course.action.PreCourseAction;
import com.course.entity.Course;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:/config/applicationContext-beans.xml",
		"classpath:/config/applicationContext-common.xml" })
public class PreCourseActionTest {

	@Resource
	PreCourseAction preCourseAction;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	// @Test
	public void testAddPreCourse() {
		preCourseAction.setRelationString("A!B!C&D");
		preCourseAction.setOp("&&");
		Course cos = new Course();
		cos.setId(9);
		preCourseAction.setCos(cos);
		preCourseAction.addPreCourse();
	}

	// @Test
	public void queryPreCourseResultString() {
		Course cos = new Course();
		cos.setId(9);
		preCourseAction.setCos(cos);
		System.out.println(preCourseAction.queryPreCourseResultString());
	}

	// @Test
	public void testQueryPreCourse() {
		Course cos = new Course();
		cos.setId(3);
		preCourseAction.setCos(cos);
		preCourseAction.queryPreCourse();
	}

	// @Test
	public void testDeletePreCourse() {
		Course cos = new Course();
		cos.setId(3);
		preCourseAction.setCos(cos);
		preCourseAction.deletePreCourse();
	}

	// @Test
	public void testModifyPreCourse() {
		preCourseAction.setRelationString("aa&bb!cc&cd");
		preCourseAction.setOp("|");
		Course cos = new Course();
		cos.setId(4);
		preCourseAction.setCos(cos);
		preCourseAction.modifyPreCourse();
	}

	// @Test
	public void testApplyPreCourse() {
		System.out.println("applyTest");
		preCourseAction.setRelationString("A!B!C|D");
		preCourseAction.setOp("&&");
		Course cos = new Course();
		cos.setId(2);
		preCourseAction.setCos(cos);
		preCourseAction.applyPreCourse();
	}

	@Test
	public void testApprovePreCourse() {
		System.out.println("approveTest");
		Course cos = new Course();
		cos.setId(2);
		preCourseAction.setIsApprove(-1);
		preCourseAction.setCos(cos);
		preCourseAction.approvePreCourse();

	}
}
