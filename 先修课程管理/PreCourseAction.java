package com.coursemanage.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.coursemanage.entity.Course;
import com.coursemanage.entity.PreCourse;
import com.coursemanage.service.IPreCourseManage;

public class PreCourseAction {
	private String relationString;
	private String op;
	private Course cos;
	List<PreCourse> pcoslist;
	@Resource
	private IPreCourseManage pcourseManage;
	public List<PreCourse> getPcos() {
		return pcoslist;
	}

	public void setPcos(List<PreCourse> pcoslist) {
		this.pcoslist = pcoslist;
	}
	
	public String getOp() {
		return op;
	}

	public void setOp(String op) {
		this.op = op;
	}

	public Course getCos() {
		return cos;
	}

	public void setCos(Course cos) {
		this.cos = cos;
	}
	
	public String getRelationString() {
		return relationString;
	}

	public void setRelationString(String relationString) {
		this.relationString = relationString;
	}

	public IPreCourseManage getPcourseManage() {
		return pcourseManage;
	}

	public void setPcourseManage(IPreCourseManage pcourseManage) {
		this.pcourseManage = pcourseManage;
	}

	private void string2list(){
		String[] relationsGroup;
		relationsGroup=relationString.split("!");
		pcoslist = new ArrayList<PreCourse>();
		for(int j=0;relationsGroup!=null && j<relationsGroup.length;j++){
			String[] preCourseName;//用于记录每组课程的名字
			StringBuffer optemp = new StringBuffer();//用于保存每组课程间的操作符，&或者|
			int sn=1;//每组的顺序号
			//提取每组的课程之间的操作符
			for(int i=0;i<relationsGroup[j].length();i++){
			if(relationsGroup[j].charAt(i)=='&'||relationsGroup[j].charAt(i)=='|'){
				optemp.append(relationsGroup[j].charAt(i));
				}
			}
		//提取每组课程的名字
		    preCourseName = relationsGroup[j].split("\\&|\\|");
		   
		  //添加组与组之间的操作符，最后一组不用无操作符
		    if(op!=null && j<op.length()){
		    	optemp.append(op.charAt(j));
		    }
		    //将内容转成PreCourse的内容
		 
		       PreCourse pcos = new PreCourse();
		   for(int i=0; i< optemp.length();i++){
			   pcos = new PreCourse();
			//pcos.add("THISCOURSE"+'\t'+course[i]+'\t'+optemp.charAt(i)+'\t'+(sn++)+ '\t'+(j+1)+'\t'+"active");
			   pcos.setCourse(cos.getId());
			   pcos.setGroup_number(j+1);
			   pcos.setPcos(preCourseName[i]);
			   pcos.setSn(sn);
			   sn++;
			   pcos.setStatus(1);
			   pcos.setOp((optemp.charAt(i)=='&')?1:0);
			   pcoslist.add(pcos);
			  // System.out.println(pcos.getPrecourse() + pcos.getOp()+pcos.getStatus());
		   }
		   if(j==relationsGroup.length-1){
			//pcos.add("THISCOURSE"+'\t'+course[course.length-1]+'\t'+"null"+'\t'+(sn++)+ '\t'+(j+1)+'\t'+"active");
			   pcos = new PreCourse();
			//   System.out.println("The last preCourse");
			   pcos.setCourse(cos.getId());
			   pcos.setGroup_number(j+1);
			   pcos.setPcos(preCourseName[preCourseName.length-1]);
			   pcos.setSn(sn);
			   sn++;
			   pcos.setStatus(1);
			   pcos.setOp(-1);
			   pcoslist.add(pcos);
			  // System.out.println(pcos.getPrecourse() + pcos.getOp()+pcos.getStatus());
		   }
		 
		   
		}
		
	}
	public void addPreCourse(){
	    System.out.println("------addPreCourseAction------");
	    this.string2list();
	    for(int i=0;i<pcoslist.size();i++){
	    	pcourseManage.addPreCourse(pcoslist.get(i));
	    }
	}
	public void queryPreCourse(){
		System.out.println("------queryPerCourseAction------");
		pcoslist = new ArrayList<PreCourse>();
		pcoslist = pcourseManage.queryPreCourse(cos);
		for(int i=0;i<pcoslist.size();i++){
			System.out.println(pcoslist.get(i).getPcos()+' '+pcoslist.get(i).getOp());
		}
	}
	public void deletePreCourse(){
		System.out.println("------deletePreCourseAction------");
		pcourseManage.deletePreCourse(cos);
	}
	public void modifyPreCourse(){
		System.out.println("------modifyPreCourse------");
		pcourseManage.deletePreCourse(cos);
		this.addPreCourse();
	}
}
