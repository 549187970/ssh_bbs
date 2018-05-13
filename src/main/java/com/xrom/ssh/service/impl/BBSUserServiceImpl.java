package com.xrom.ssh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xrom.ssh.entity.BBSUser;
import com.xrom.ssh.repository.impl.BBSUserRepositoryImpl;
import com.xrom.ssh.service.BBSUserService;

@Service
public class BBSUserServiceImpl implements BBSUserService {

	@Autowired(required=true)
	private BBSUserRepositoryImpl ServiceImpl;
	
	@Override
	public Boolean saveUser(BBSUser user ,String password2) {
		if(user.getPassword().toString().equals(password2)) {
			ServiceImpl.add(user);
			return true;
		}
		return false;
	}

	@Override
	public BBSUser getUser(Integer id) {
		return ServiceImpl.get(id);
	}

	@Override
	public void updateUser(BBSUser user) {
		ServiceImpl.update(user);
	}

	@Override
	public void deleteUser(Integer id) {
		ServiceImpl.delete(id);
	}

	@Override
	public BBSUser getUserfromName(String name) {
		return ServiceImpl.getUserfromName(name);
	}




}
