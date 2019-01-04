package com.xrom.ssh.repository;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.xrom.ssh.entity.BBSUser;

public interface BBSUserRepository {

	 void add(BBSUser u);
	 
	 BBSUser get(Integer id);
	 
	 Integer getId(String username);
	 
	 void update(BBSUser u);
	 
	 void delete(Integer id);
	 
	 BBSUser getUserfromName(String name);
}
