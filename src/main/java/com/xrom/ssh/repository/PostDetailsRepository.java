package com.xrom.ssh.repository;



import java.util.List;

import com.xrom.ssh.entity.PostDetails;

public interface PostDetailsRepository {
	void addPost(PostDetails p);
	 
	PostDetails getPostDetails(Integer id);
	
	List<PostDetails> getPostDetailsList();
	
	List<PostDetails> getPostDetailsMainID(Integer mainID);
	 
	void deletePostDetails(Integer id);
	
	void update(PostDetails p);
	
	List<PostDetails> getPostDetailsisMainPost();
	
	void deletePostDetailsfromMainID(Integer mainID);
}
