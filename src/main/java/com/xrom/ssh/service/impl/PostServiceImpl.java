package com.xrom.ssh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xrom.ssh.entity.Post;
import com.xrom.ssh.repository.PostRepository;
import com.xrom.ssh.service.PostService;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepository postRepositoryImpl;
	
	@Override
	public void addPost(Post p) {
		
		postRepositoryImpl.addPost(p);
	}

	@Override
	public Post getPost(Integer postID) {
		return postRepositoryImpl.getPost(postID);
	}

	@Override
	public void deletePost(Integer postID) {
		postRepositoryImpl.deletePost(postID);

	}

}
