package com.xrom.ssh.service;

import com.xrom.ssh.entity.BBSUser;

import net.sf.json.JSONObject;

public interface BBSUserService {
	
	JSONObject saveUser(BBSUser user,String password2);
	
	BBSUser getUser(Integer id);
	
	Integer getId(String username);
	
	void updateUser(BBSUser user);
	
	void deleteUser(Integer id);
	
	BBSUser getUserfromName(String name);
}
