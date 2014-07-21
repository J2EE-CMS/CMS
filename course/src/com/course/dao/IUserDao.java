package com.course.dao;

import com.course.entity.User;

public interface IUserDao {
	public void AddUser(User user);
	public void modifyUser(User user);
	public void deleteUser(User user);
}
