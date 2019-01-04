package com.xrom.ssh.service;

import com.xrom.ssh.entity.BBSUser;
import com.xrom.ssh.entity.Post;

public interface PostService {
	void addPost(Post p);
	
	Post getPost(Integer postID);
	
	void deletePost(Integer postID);
}
