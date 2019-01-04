package com.xrom.ssh.repository.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xrom.ssh.entity.BBSUser;
import com.xrom.ssh.entity.MostPostNum;
import com.xrom.ssh.repository.MostPostNumRepository;

@Repository
public class MostPostNumRepositoryImpl implements MostPostNumRepository {

	@Autowired(required=true)
	private SessionFactory sessionFactory; 
	
	private Session getSession() {
		return sessionFactory.openSession();
	}
	
	@Override
	public void add(MostPostNum m) {
		this.getSession().save(m);
	}

	@Override
	public MostPostNum getNum(Integer id) {
		return (MostPostNum)this.getSession().createQuery("from MostPostNum where id= ?")
				 .setParameter(0, id).uniqueResult();
	}

	@Override
	public void update(MostPostNum m) {
		System.out.println("update");
		this.getSession().createQuery("update mostpostnum set MostPostNum=? where id=1").setParameter(0, m.getMostPostNum()).executeUpdate();
	}

}
