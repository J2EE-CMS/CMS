package com.coursemanage.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.coursemanage.entity.User;

public class UserDaoImp implements IUserDao {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void AddUser(User user) {
		System.out.println("-------UserDaoImp.AddUser-----------"
				+ user.getName());
		getSession().save(user);
	}

	@Override
	public void modifyUser(User user) {
		System.out.println("-------UserDaoImp.modifyUser-----------"
				+ user.getName());
		String hql = "from User as user where user.name=?";
		Query query = getSession().createQuery(hql);
		query.setString(0, user.getName());
		List<User> list = query.list();
		for(User u:list){
			u.setPassword(user.getPassword());
			u.setAge(user.getAge());
	     	getSession().update(u);
		}
	}

	@Override
	public void deleteUser(User user) {
		System.out.println("-------UserDaoImp.deleteUser-----------"
				+ user.getName());
		String hql = "from User as user where user.name=?";
		Query query = getSession().createQuery(hql);
		query.setString(0, user.getName());
		List<User> list = query.list();
		for(User u:list){
	     	getSession().delete(u);
		}
	}

	@Override
	public void queryUser(User user) {
		
		System.out.println("-------UserDaoImp.queryUser-----------"
				+ user.getName());
		String hql = "from User as user where user.name=?";
		Query query = getSession().createQuery(hql);
		query.setString(0, user.getName());
		List<User> list = query.list();
		for(User u : list){
			System.out.println(u.getId()+" "+u.getAge()+" "+u.getName()+" "+u.getPassword());
		}
	}

}
