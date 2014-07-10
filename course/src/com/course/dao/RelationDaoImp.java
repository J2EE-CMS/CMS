package com.course.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.course.entity.Relation;

public class RelationDaoImp implements IRelationDao {
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void modifyRelation(Relation relation) {
		getSession().update(relation);
	}
	/*
	@Override
	public void findRelation(Relation relation) {
		
	}*/
	
	
	
	//test
	public void addRelation(Relation relation){
		getSession().save(relation);
	}
}
