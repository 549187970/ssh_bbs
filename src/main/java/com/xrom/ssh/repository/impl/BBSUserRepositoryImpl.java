package com.xrom.ssh.repository.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xrom.ssh.entity.BBSUser;
import com.xrom.ssh.repository.BBSUserRepository;

@Repository
public class BBSUserRepositoryImpl implements BBSUserRepository{
	
	@Autowired(required=true)
	private SessionFactory sessionFactory; 
	
	private Session getSession() {
		return sessionFactory.openSession();
	}
	
	@Override
	public void add(BBSUser u) {
		this.getSession().save(u);
	}

	@Override
	public BBSUser get(Integer id) {
		 return (BBSUser)this.getSession().createQuery("from BBSUser where id= ?")
				 .setParameter(0, id).uniqueResult();
	}

	@Override
	public void update(BBSUser u) {
		this.getSession().update(u);
		
	}

	@Override
	public void delete(Integer id) {
		this.getSession().createQuery("delete BBSUser where id= ?")
				 .setParameter(0, id).executeUpdate();
	}

	@Override
	public BBSUser getUserfromName(String name) {
		return (BBSUser)this.getSession().createQuery("from BBSUser where username= ?")
				 .setParameter(0, name).uniqueResult();
	}

}
