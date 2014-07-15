package com.coursemanage.service;

import com.coursemanage.entity.User;

public interface IUserManage {
	public void addUser(User user);
	public void modifyUser(User user);
	public void deleteUser(User user);
	public void queryUser(User user);
}
