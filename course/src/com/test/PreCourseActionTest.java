package com.test;

import javax.annotation.Resource;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.course.action.PreCourseAction;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/config/applicationContext-beans.xml",
		"classpath:/config/applicationContext-common.xml" })
public class PreCourseActionTest {

	@Resource
	PreCourseAction preCourseAction;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	// @Test
	public void testAddPreCourse() {
		preCourseAction.setRelationString("A&B");
		preCourseAction.setOp("");
		preCourseAction.setCosid(7);
		preCourseAction.addPreCourse();
	}

	 @Test
	public void testQueryPreCourse() {
		preCourseAction.setCosid(5);
		preCourseAction.queryPreCourse();
		// System.out.println(preCourseAction.getPcoslist().size());
	}

	@Test
	public void testqueryAllPreCourseRelations() {
		preCourseAction.queryAllPreCourseRelations();
	}

	// @Test

	public void testDeletePreCourse() {
		preCourseAction.setCosid(5);
		preCourseAction.deletePreCourse();
	}

	//@Test
	public void testModifyPreCourse() {
		preCourseAction.setRelationString("aa&bb!cc&cd");
		preCourseAction.setOp("|");
		preCourseAction.setCosid(3);
		preCourseAction.modifyPreCourse();
	}

	// @Test
	public void testApplyPreCourse() {
		System.out.println("applyTest");
		preCourseAction.setRelationString("courseX");
		preCourseAction.setOp("");

		preCourseAction.setCosid(3);
		preCourseAction.applyPreCourse();
	}

	// @Test
	public void testApprovePreCourse() {
		preCourseAction.setIsApprove(1);
		preCourseAction.setCosid(1);
		preCourseAction.approvePreCourse();

	}
}
