package com.xrom.ssh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xrom.ssh.entity.PostDetails;
import com.xrom.ssh.repository.PostDetailsRepository;
import com.xrom.ssh.service.PostDetailsService;

@Service
public class PostDetailsServiceImpl implements PostDetailsService{

	@Autowired
	private PostDetailsRepository PostDetailsRepositoryImpl;
	
	@Override
	public void addPost(PostDetails p) {
		PostDetailsRepositoryImpl.addPost(p);
	}
	

	@Override
	public void addMainPost(PostDetails p) {
		PostDetailsRepositoryImpl.addMainPost(p);
	}


	@Override
	public PostDetails getPostDetails(Integer id) {
		return PostDetailsRepositoryImpl.getPostDetails(id);
	}

	@Override
	public void deletePostDetails(Integer id) {
		PostDetailsRepositoryImpl.deletePostDetails(id);
	}

	@Override
	public void update(PostDetails p) {
		PostDetailsRepositoryImpl.update(p);
	}

	@Override
	public List<PostDetails> getPostDetailsList() {
		return PostDetailsRepositoryImpl.getPostDetailsList();
	}

	@Override
	public List<PostDetails> getPostDetailsMainID(Integer mainID) {
		return PostDetailsRepositoryImpl.getPostDetailsMainID(mainID);
	}

	@Override
	public List<PostDetails> getPostDetailsisMainPost() {
		return PostDetailsRepositoryImpl.getPostDetailsisMainPost();
	}

	@Override
	public void deletePostDetailsfromMainID(Integer postID,Integer mainID) {
		PostDetails pd=PostDetailsRepositoryImpl.getPostDetails(postID);
		if(pd.isMainPost()) {
			PostDetailsRepositoryImpl.deletePostDetailsfromMainID(mainID);
		}else {
			PostDetailsRepositoryImpl.deletePostDetails(postID);
		}
		
	}

}
