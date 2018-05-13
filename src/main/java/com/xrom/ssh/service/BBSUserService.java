package com.xrom.ssh.service;

import com.xrom.ssh.entity.BBSUser;

public interface BBSUserService {
	
	Boolean saveUser(BBSUser user,String password2);
	
	BBSUser getUser(Integer id);
	
	void updateUser(BBSUser user);
	
	void deleteUser(Integer id);
	
	BBSUser getUserfromName(String name);
}
