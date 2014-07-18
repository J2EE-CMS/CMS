package com.course.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.course.entity.Coursetype;
import com.course.entity.Relation;

public class RelationDaoImp implements IRelationDao {
	
	private SessionFactory sessionFactory;
	//private Relation relation;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	
	/*   -----------------------   */
	@Override
	public void modifyRelation(Relation relation) {
		//getSession().clear();
		//essionFactory.getCurrentSession().update(relation);
		Query query = sessionFactory.getCurrentSession().createQuery("from Relation where id=?");
		query.setInteger(0, relation.getId());
		Relation costype = (Relation )query.uniqueResult();
		costype.setRelation(relation);	
	}
	
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Relation> getAllRelations() {
		//return this.sessionFactory.getCurrentSession().createQuery( "from Relation" ).list();	
		Query query = sessionFactory.getCurrentSession().createQuery("from Relation"); 
		return query.list();
	}
	
	
	public List<Relation> findByGrade(Integer grade) {
		Query query = sessionFactory.getCurrentSession().createQuery("from Relation where grade=?");
		query.setInteger(0, grade);
		return query.list();
	}
	
	/*   -----------------------   */
	
	//test
	@Override
	public void addRelation(Relation relation){
		//getSession().save(relation);
		sessionFactory.getCurrentSession().persist(relation);
	}
}
