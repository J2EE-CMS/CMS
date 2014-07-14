package com.course.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.course.entity.Relation;

public class RelationDaoImp implements IRelationDao {
	
	private SessionFactory sessionFactory;
	private Relation relation;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	
	/*   -----------------------   */
	@Override
	public void modifyRelation(Relation relation) {
		getSession().clear();
		sessionFactory.getCurrentSession().update(relation);
		//Relation old = (Relation)sessionFactory.getCurrentSession().get(Relation.class, id);
	}
	
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Relation> getAllRelations() {
		//return this.sessionFactory.getCurrentSession().createQuery( "from Relation" ).list();	
		Query query = sessionFactory.getCurrentSession().createQuery("from Relation"); 
		return query.list();
	}
	
	/*
	public List<Relation> findByGrade(Integer grade) {
		Query query = sessionFactory.getCurrentSession().createQuery("from Relation where id=1");  		
		 List<Relation> list = query.list();
		 for(Relation relation :list){
		 	System.out.println(relation.getGrade());
		 }
	}*/
	
	/*
	public void delete(Integer id) {
		Relation relation = (Relation)sessionFactory.getCurrentSession().get(Relation.class, id);
		sessionFactory.getCurrentSession().delete(relation);
	}*/
	
	/*   -----------------------   */
	
	//test
	@Override
	public void addRelation(Relation relation){
		//getSession().save(relation);
		sessionFactory.getCurrentSession().persist(relation);
	}
}
