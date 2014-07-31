package com.course.dao.impl;

import java.awt.image.RescaleOp;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.course.dao.IUserDao;
import com.course.entity.User;
import com.course.entity.User;

public class UserDaoImp implements IUserDao {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void addUser(User user) {
		System.out.println("-------UserDaoImp.addUser-----------"
				+ user.getName());
		getSession().save(user);
	}

	@Override
	public void modifyUser(User user) {
		System.out.println("-------UserDaoImp.modifyUser-----------"
				+ user.getName());
		getSession().update(user);
	}

	@Override
	public void deleteUser(User user) {
		System.out.println("-------UserDaoImp.deleteUser-----------"
				+ user.getName());
		getSession().delete(user);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUsers(){
		String hql = "from User";
		Query query = getSession().createQuery(hql);
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<User> queryUsers(User user){
		
		Criteria criteria = getSession().createCriteria(User.class);
		criteria.add(Restrictions.and(Restrictions.eq("name", user.getName()),Restrictions.eq("password", user.getPassword())));
		List list = criteria.list();
		return list;
	}

}
