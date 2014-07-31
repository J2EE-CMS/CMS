package com.course.service;

import java.util.List;

import com.course.entity.User;

public interface IUserManage {
	public void addUser(User user);
	public void modifyUser(User user);
	public void deleteUser(User user);
	public List<User> getAllUsers();
	public List<User> queryUsers(User user);
}
