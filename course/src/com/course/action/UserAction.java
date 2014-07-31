package com.course.action;

import java.util.List;

import javax.annotation.Resource;

import com.course.entity.User;
import com.course.service.IUserManage;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Resource  
	private IUserManage userManage;
	private User user;
	private List<User> userList;
	
	public String addUser()
	{
		System.out.println("-------userAction.addUser--------"+user.getName());
		
		userManage.addUser(user);
		return "success";
	}
	
	public String modifyUser()
	{
		System.out.println("-------userAction.modifyUser--------"+user.getName());
		userManage.modifyUser(user);
		return "success";
	}
	
	public String deleteUser()
	{
		System.out.println("-------userAction.deleteUser--------"+user.getName());
		userManage.deleteUser(user);
		return "success";
	}
	
	public String getAllUsers(){
		setUserList(userManage.getAllUsers());
		return "alluser";
	}
	
	public String queryUsers(){
		setUserList(userManage.queryUsers(user));
		return "queryUsers";
	}
	
	
	
	public void setUserManage(IUserManage userManage) {
		this.userManage = userManage;
	}
	
	public IUserManage getUserManage() {
		return userManage;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	
}
