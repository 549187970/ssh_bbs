package com.xrom.ssh.repository;

import com.xrom.ssh.entity.BBSUser;
import com.xrom.ssh.entity.Post;

public interface PostRepository {
	 void addPost(Post post);
	 
	 Post getPost(Integer id);
	 
	 void deletePost(Integer id);
	 
	 
}
