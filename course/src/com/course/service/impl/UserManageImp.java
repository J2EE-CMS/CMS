package com.course.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.course.dao.IUserDao;
import com.course.entity.User;
import com.course.service.IUserManage;

public class UserManageImp implements IUserManage {
	
	@Resource  
	private IUserDao userDao;
	
	public IUserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void addUser(User user) {
		System.out.println("------UserManageImp.adddUser--------"+user.getName());
		userDao.addUser(user);
		
	}

	@Override
	public void modifyUser(User user) {
		System.out.println("------UserManageImp.modifyUser--------"+user.getName());
		userDao.modifyUser(user);

	}

	@Override
	public void deleteUser(User user) {
		System.out.println("------UserManageImp.deleteUser--------"+user.getName());
		userDao.deleteUser(user);
	}

	@Override
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}
	
	@Override
	public List<User> queryUsers(User user) {
		return userDao.queryUsers(user);
	}
}
