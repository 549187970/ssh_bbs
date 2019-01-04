package com.xrom.ssh.repository.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xrom.ssh.entity.PostDetails;
import com.xrom.ssh.repository.PostDetailsRepository;

@Repository
public class PostDetailsRepositoryImpl implements PostDetailsRepository {

	@Autowired
	private SessionFactory sessionFactory; 
	
	private Session getSession() {
		return sessionFactory.openSession();
	}
	
	@Override
	public void addPost(PostDetails p) {
		this.getSession().save(p);
		
	}

	@Override
	public void addMainPost(PostDetails p) {
		this.getSession().save(p);
		p.setMainID(p.getPostDid());
		this.update(p);
	}
	
	@Override
	public PostDetails getPostDetails(Integer id) {
		return (PostDetails)this.getSession().createQuery("from PostDetails where id= ?")
				 .setParameter(0, id).uniqueResult();
	}

	@Override
	public void deletePostDetails(Integer postDid) {
		this.getSession().createQuery("delete PostDetails where postDid= ?")
		 .setParameter(0, postDid).executeUpdate();
	}

	@Override
	public void update(PostDetails p) {
		this.getSession().update(p);
		
	}

	@Override
	public List<PostDetails> getPostDetailsList() {
		return this.getSession().createCriteria(PostDetails.class).list();
	}

	@Override
	public List<PostDetails> getPostDetailsMainID(Integer mainID) {
		return (List<PostDetails>)this.getSession().createQuery("from PostDetails where mainID =? order by postDid")
				 .setParameter(0, mainID).list();
	}

	@Override
	public List<PostDetails> getPostDetailsisMainPost() {
		return (List<PostDetails>)this.getSession().createQuery("from PostDetails where isMainPost= ?")
				 .setParameter(0, true).list();
	}

	@Override
	public void deletePostDetailsfromMainID(Integer mainID) {
		this.getSession().createQuery("delete PostDetails where mainID= ?")
		 .setParameter(0, mainID).executeUpdate();
	}


}
