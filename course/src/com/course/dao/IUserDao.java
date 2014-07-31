package com.course.dao;

import java.util.List;

import com.course.entity.User;

public interface IUserDao {
	public void addUser(User user);
	public void modifyUser(User user);
	public void deleteUser(User user);
	public List<User> getAllUsers();
	public List<User> queryUsers(User user);
	
}
