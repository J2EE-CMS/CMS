package com.course.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.course.entity.User;
import com.course.service.IUserManage;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user = new User();
	
	@Resource
	private IUserManage userManage;

	List<User> list;
	
	@SuppressWarnings("unchecked")
	@Override
	public String execute() throws Exception {
		
		HttpServletRequest request=ServletActionContext.getRequest();
		
		System.out.println(request.getCharacterEncoding());
		
		list = userManage.queryUsers(user);
		if(list.size() != 0){
			Map session=ActionContext.getContext().getSession();
			session.put("user.id", list.get(0).getId());
			session.put("user.name", user.getName());
			session.put("user.password", user.getPassword());
			session.put("user.role", list.get(0).getRole());
			
			System.out.println("登录成功,用户ID = "+list.get(0).getId() + " " + 
					"用户名 = "+list.get(0).getName() + " " + 
					"密码 = "+list.get(0).getPassword() + " " + 
					"角色 = "+list.get(0).getRole());
			return "success";
		}
		
		System.out.println("登录失败，用户名="+user.getName());
		return "fail";
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public IUserManage getUsermanage() {
		return userManage;
	}

	public void setUsermanage(IUserManage usermanage) {
		this.userManage = usermanage;
	}
}
