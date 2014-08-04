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
	List<Course> reslist;
	private String res;
	@Resource
	private IPreCourseManage pcourseManage;

	public List<Course> getReslist() {
		return reslist;
	}

	public void setReslist(List<Course> reslist) {
		this.reslist = reslist;
	}

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

	private void string2list(int isapply) {// 0琛ㄧず鐢宠锛�琛ㄧず鐢宠閫氳繃锛�1鐢宠涓嶉�杩�
		String[] relationsGroup;
		if (relationString == null) {
			relationString = "";
			op = "";
		}
		int sn = 1;
		relationsGroup = relationString.split("!");
		pcoslist = new ArrayList<PreCourse>();
		for (int j = 0; relationsGroup != null && j < relationsGroup.length; j++) {
			String[] preCourseName;// 鐢ㄤ簬璁板綍姣忕粍璇剧▼鐨勫悕瀛�
			StringBuffer optemp = new StringBuffer();// 鐢ㄤ簬淇濆瓨姣忕粍璇剧▼闂寸殑鎿嶄綔绗︼紝&鎴栬�|

			// 鎻愬彇姣忕粍鐨勮绋嬩箣闂寸殑鎿嶄綔绗�
			for (int i = 0; i < relationsGroup[j].length(); i++) {
				if (relationsGroup[j].charAt(i) == '&' || relationsGroup[j].charAt(i) == '|') {
					optemp.append(relationsGroup[j].charAt(i));
				}
			}
			// 鎻愬彇姣忕粍璇剧▼鐨勫悕瀛�
			preCourseName = relationsGroup[j].split("\\&|\\|");

			// 娣诲姞缁勪笌缁勪箣闂寸殑鎿嶄綔绗︼紝鏈�悗涓�粍涓嶇敤鏃犳搷浣滅
			if (op != null && j < op.length()) {
				optemp.append(op.charAt(j));
			}
			// 灏嗗唴瀹硅浆鎴怭reCourse鐨勫唴瀹�

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
		this.string2list(0);
		for (int i = 0; i < pcoslist.size() && !relationString.equals(""); i++) {
			pcourseManage.addPreCourse(pcoslist.get(i));
		}
	}

	public void applyPreCourse() {
		System.out.println("------applyPreCourseAction------");
		this.string2list(0);
		Course cos = new Course();
		cos.setId(cosid);
		if (pcourseManage.queryPreCourse(cos).size() != 0)
			return;
		for (int i = 0; i < pcoslist.size(); i++) {
			pcourseManage.addPreCourse(pcoslist.get(i));
		}
	}

	public void approvePreCourse() {
		System.out.println("------approvePreCourseAction------");

		pcoslist = new ArrayList<PreCourse>();
		cos = new Course();
		cos.setId(cosid);
		pcourseManage.approvePreCourse(cos, isApprove);
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
		PreCourse currentrecord = new PreCourse();
		res = "";
		StringBuffer resbuff = new StringBuffer();
		for (int i = 0; i < pcoslist.size(); i++) {

			if (lastrecord.getGroup_number() == -1) {
				currentrecord = pcoslist.get(i);
				// res += "Course " + currentrecord.getCourse() + ": ( " +
				// currentrecord.getPcos() + " ";
				resbuff.append("Course ").append(currentrecord.getCos().getId()).append(": ( ")
						.append(currentrecord.getPcos()).append(" ");
				lastrecord = pcoslist.get(i);
			} else {
				currentrecord = pcoslist.get(i);
				if (currentrecord.getGroup_number() != lastrecord.getGroup_number()) {
					// res += ") " + ((lastrecord.getOp() == 1) ? "and" : "or")
					// + " ( " + currentrecord.getPcos() + " ";
					resbuff.append(") ").append((lastrecord.getOp() == 1) ? "and" : "or").append(" ( ")
							.append(currentrecord.getPcos()).append(" ");
				} else {
					// res += ((lastrecord.getOp() == 1) ? "and" : "or") + " " +
					// currentrecord.getPcos() + " ";
					resbuff.append((lastrecord.getOp() == 1) ? "and" : "or").append(" ")
							.append(currentrecord.getPcos()).append(" ");
				}

			}
			lastrecord = currentrecord;
			if (lastrecord.getOp() == -1) {
				// res += ")\n";
				resbuff.append(")\n");
				lastrecord.setGroup_number(-1);
			}
		}
		// res += ")";
		res = resbuff.toString();
		System.out.println(res);

	}

	public void queryPreCourseResultList() {
		if (pcoslist.isEmpty())
			return;
		Course tmpcos;
		reslist = new ArrayList<Course>();
		PreCourse lastrecord = new PreCourse();
		lastrecord.setOp(-1);
		PreCourse currentrecord = new PreCourse();
		StringBuffer resbuff = new StringBuffer();
		for (int i = 0; i < pcoslist.size(); i++) {

			currentrecord = pcoslist.get(i);
			if (lastrecord.getOp() == -1) {
				resbuff.append(" ( ").append(currentrecord.getPcos()).append(" ");
				lastrecord.setGroup_number(currentrecord.getGroup_number());
			} else {
				if (currentrecord.getGroup_number() != lastrecord.getGroup_number()) {

					resbuff.append(") ").append((lastrecord.getOp() == 1) ? "and" : "or").append(" ( ")
							.append(currentrecord.getPcos()).append(" ");
				} else {
					resbuff.append((lastrecord.getOp() == 1) ? "and" : "or").append(" ")
							.append(currentrecord.getPcos()).append(" ");
				}
			}

			if (currentrecord.getOp() == -1) {
				tmpcos = new Course();
				tmpcos.setId(currentrecord.getCos().getId());
				tmpcos.setC_course_name(currentrecord.getCos().getC_course_name());
				resbuff.append(")");
				tmpcos.setInfo(resbuff.toString());
				reslist.add(tmpcos);
				resbuff.delete(0, resbuff.length());
			}
			lastrecord = currentrecord;

		}
		System.out.println("This is querylist:\n");
		for (Course ctmp : reslist) {
			System.out.println("" + ctmp.getId() + " " + ctmp.getC_course_name() + " " + ctmp.getInfo());
		}

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
		queryPreCourseResultList();
		return "success";
	}

}
