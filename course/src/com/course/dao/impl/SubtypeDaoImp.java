package com.course.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
 

import com.course.dao.ISubtypeDao;
import com.course.entity.Subtype;

public class SubtypeDaoImp implements ISubtypeDao {

	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void addSubtype(Subtype subtype) {
		getSession().save(subtype);
	}
	
	@Override
	public void deleteSubtype(Subtype subtype){
		getSession().delete(subtype);
	}
	
	@Override
	public void modifySubtype(Subtype subtype) {
		//getSession().clear();
		getSession().update(subtype);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Subtype> getAllSubtypes(){
		String hql = "from Subtype";
		Query query = getSession().createQuery(hql);
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Subtype> querySubtypes(Subtype subtype){
		String hql = "from Subtype where subtypecode like ? and " + 
				"subtypename like ? and belongtotype like ? and " + 
				"ispublicsubtype like ? and department like ?";
		Query query = getSession().createQuery(hql);
		if(subtype.getSubtypecode() != null){
			query.setString(0, "%"+subtype.getSubtypecode()+"%");
		}else{
			query.setString(0, "");
		}
		if(subtype.getSubtypename() != null){
			query.setString(1, "%"+subtype.getSubtypename()+"%");
		}else{
			query.setString(1, "");
		}
		if(subtype.getBelongtotype() != null){
			query.setString(2, "%"+subtype.getBelongtotype()+"%");
		}else{
			query.setString(2, "");
		}
		if(subtype.getSubtypename() != null){
			query.setString(3, "%"+subtype.getIspublicsubtype()+"%");
		}else{
			query.setString(3, "");
		}
		if(subtype.getSubtypename() != null){
			query.setString(4, "%"+subtype.getDepartment()+"%");
		}else{
			query.setString(4, "");
		}
		
		List<Subtype> List = query.list();
		for(Subtype sub : List){
			System.out.println(sub.getId());
		}
		
		return query.list();
	}
}
