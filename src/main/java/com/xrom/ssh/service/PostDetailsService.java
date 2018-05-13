package com.xrom.ssh.service;

import java.util.List;

import com.xrom.ssh.entity.PostDetails;

public interface PostDetailsService {
	void addPost(PostDetails p);
	 
	PostDetails getPostDetails(Integer id);
	 
	void deletePostDetails(Integer id);
	
	void update(PostDetails p);
	
	List<PostDetails> getPostDetailsList();
	
	List<PostDetails> getPostDetailsMainID(Integer mainID);
	
	List<PostDetails> getPostDetailsisMainPost();
	
	void deletePostDetailsfromMainID(Integer postID,Integer mainID);
}
