package com.xrom.ssh.repository.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xrom.ssh.entity.BBSUser;
import com.xrom.ssh.entity.Post;
import com.xrom.ssh.repository.PostRepository;

@Repository
public class PostRepositoryImpl implements PostRepository {

	@Autowired(required=true)
	private SessionFactory sessionFactory; 
	
	private Session getSession() {
		return sessionFactory.openSession();
	}
	
	@Override
	public void addPost(Post post) {
		this.getSession().save(post);
	}

	@Override
	public Post getPost(Integer id) {
		 return (Post)this.getSession().createQuery("from Post where postID= ?")
				 .setParameter(0, id).uniqueResult();
		
	}

	@Override
	public void deletePost(Integer id) {
		this.getSession().createQuery("delete Post where postID= ?")
				 .setParameter(0, id).executeUpdate();
	}

	

}
