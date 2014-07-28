package com.course.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.course.entity.Course;
import com.course.entity.PreCourse;
import com.course.service.IPreCourseManage;

public class PreCourseAction {
	private String relationString;
	private String op;
	private int cosid;
	private Course cos;
	private int isApprove;
	List<PreCourse> pcoslist;
	private String res;

	@Resource
	private IPreCourseManage pcourseManage;

	public String getRes() {
		return res;
	}

	public void setRes(String res) {
		this.res = res;
	}

	public int getIsApprove() {
		return isApprove;
	}

	public void setIsApprove(int isApprove) {
		this.isApprove = isApprove;
	}

	public int getCosid() {
		return cosid;
	}

	public void setCosid(int cosid) {
		this.cosid = cosid;
	}

	public void setCos(Course cos) {
		this.cos = cos;
	}

	public Course getCos() {
		return cos;
	}

	public List<PreCourse> getPcoslist() {
		return pcoslist;
	}

	public void setPcoslist(List<PreCourse> pcoslist) {
		this.pcoslist = pcoslist;
	}

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

	private void string2list(int isapply) {// 0表示申请，1表示申请通过，-1申请不通过
		String[] relationsGroup;
		if (relationString == null) {
			relationString = "";
			op = "";
		}

		relationsGroup = relationString.split("!");
		pcoslist = new ArrayList<PreCourse>();
		for (int j = 0; relationsGroup != null && j < relationsGroup.length; j++) {
			String[] preCourseName;// 用于记录每组课程的名字
			StringBuffer optemp = new StringBuffer();// 用于保存每组课程间的操作符，&或者|
			int sn = 1;// 每组的顺序号
			// 提取每组的课程之间的操作符
			for (int i = 0; i < relationsGroup[j].length(); i++) {
				if (relationsGroup[j].charAt(i) == '&' || relationsGroup[j].charAt(i) == '|') {
					optemp.append(relationsGroup[j].charAt(i));
				}
			}
			// 提取每组课程的名字
			preCourseName = relationsGroup[j].split("\\&|\\|");

			// 添加组与组之间的操作符，最后一组不用无操作符
			if (op != null && j < op.length()) {
				optemp.append(op.charAt(j));
			}
			// 将内容转成PreCourse的内容

			PreCourse pcos = new PreCourse();
			for (int i = 0; i < optemp.length(); i++) {
				pcos = new PreCourse();
				// pcos.add("THISCOURSE"+'\t'+course[i]+'\t'+optemp.charAt(i)+'\t'+(sn++)+
				// '\t'+(j+1)+'\t'+"active");
				pcos.setCourse(cosid);
				pcos.setGroup_number(j + 1);
				pcos.setPcos(preCourseName[i]);
				pcos.setSn(sn);
				sn++;
				pcos.setStatus(isapply);
				pcos.setOp((optemp.charAt(i) == '&') ? 1 : 0);
				pcoslist.add(pcos);
				// System.out.println(pcos.getPrecourse() +
				// pcos.getOp()+pcos.getStatus());
			}
			if (j == relationsGroup.length - 1) {
				// pcos.add("THISCOURSE"+'\t'+course[course.length-1]+'\t'+"null"+'\t'+(sn++)+
				// '\t'+(j+1)+'\t'+"active");
				pcos = new PreCourse();
				// System.out.println("The last preCourse");
				pcos.setCourse(cosid);
				pcos.setGroup_number(j + 1);
				pcos.setPcos(preCourseName[preCourseName.length - 1]);
				pcos.setSn(sn);
				sn++;
				pcos.setStatus(isapply);
				pcos.setOp(-1);
				pcoslist.add(pcos);
				// System.out.println(pcos.getPrecourse() +
				// pcos.getOp()+pcos.getStatus());
			}

		}

	}

	public void addPreCourse() {
		System.out.println("------addPreCourseAction------");
		this.string2list(1);
		for (int i = 0; i < pcoslist.size() && !relationString.equals(""); i++) {
			pcourseManage.addPreCourse(pcoslist.get(i));
		}
	}

	public void applyPreCourse() {
		System.out.println("------applyPreCourseAction------");
		this.string2list(0);
		for (int i = 0; i < pcoslist.size(); i++) {
			pcourseManage.addPreCourse(pcoslist.get(i));
		}
	}

	public void approvePreCourse() {
		System.out.println("------approvePreCourseAction------");

		pcoslist = new ArrayList<PreCourse>();
		cos = new Course();
		cos.setId(cosid);
		pcoslist = pcourseManage.queryPreCourse(cos);
		for (int i = 0; i < pcoslist.size(); i++) {
			System.out.println(pcoslist.get(i).getPcos() + ' ' + pcoslist.get(i).getOp());
		}

		pcourseManage.deletePreCourse(cos);
		for (PreCourse pcos : pcoslist) {
			pcos.setStatus(isApprove);
			pcourseManage.addPreCourse(pcos);
		}
	}

	public String queryPreCourse() {
		System.out.println("------queryPreCourseAction------");
		pcoslist = new ArrayList<PreCourse>();
		cos = new Course();
		cos.setId(cosid);
		pcoslist = pcourseManage.queryPreCourse(cos);
		// System.out.println(pcoslist.size());
		/*
		 * for (int i = 0; i < pcoslist.size(); i++) {
		 * System.out.println(pcoslist.get(i).getPcos() + ' ' +
		 * pcoslist.get(i).getOp()); }
		 */
		queryPreCourseResultString();
		return "success";
	}

	public void queryPreCourseResultString() {
		if (pcoslist.isEmpty())
			return;

		PreCourse lastrecord = new PreCourse();
		lastrecord.setGroup_number(-1);
		;
		PreCourse currentrecord = new PreCourse();
		res = "";

		for (int i = 0; i < pcoslist.size(); i++) {

			if (lastrecord.getGroup_number() == -1) {
				currentrecord = pcoslist.get(i);
				res += "Course " + currentrecord.getCourse() + ": ( " + currentrecord.getPcos() + " ";
				lastrecord = pcoslist.get(i);
			} else {
				currentrecord = pcoslist.get(i);
				if (currentrecord.getGroup_number() != lastrecord.getGroup_number()) {
					res += ") " + ((lastrecord.getOp() == 1) ? "and" : "or") + " ( " + currentrecord.getPcos() + " ";
				} else {
					res += ((lastrecord.getOp() == 1) ? "and" : "or") + " " + currentrecord.getPcos() + " ";
				}

			}
			lastrecord = currentrecord;
			if (lastrecord.getOp() == -1) {
				res += ")\n";
				lastrecord.setGroup_number(-1);
			}
		}
		// res += ")";
		System.out.println(res);

	}

	public void deletePreCourse() {
		System.out.println("------deletePreCourseAction------");
		cos = new Course();
		cos.setId(cosid);
		pcourseManage.deletePreCourse(cos);
	}

	public void modifyPreCourse() {
		System.out.println("------modifyPreCourse------");
		cos = new Course();
		cos.setId(cosid);
		pcourseManage.deletePreCourse(cos);
		this.addPreCourse();
	}

	public String queryAllPreCourseRelations() {
		System.out.println("------queryAllPreCourse------");
		pcoslist = pcourseManage.queryAllPreCourseRelations();
		queryPreCourseResultString();
		return "success";
	}
}
