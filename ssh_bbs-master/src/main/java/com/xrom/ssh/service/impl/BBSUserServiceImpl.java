package com.xrom.ssh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xrom.ssh.entity.BBSUser;
import com.xrom.ssh.repository.impl.BBSUserRepositoryImpl;
import com.xrom.ssh.service.BBSUserService;

import net.sf.json.JSONObject;

@Service
public class BBSUserServiceImpl implements BBSUserService {

	@Autowired(required=true)
	private BBSUserRepositoryImpl ServiceImpl;
	
	@Override
	public JSONObject saveUser(BBSUser user ,String password2) {
		JSONObject jo=new JSONObject();
		if(user.getUsername()==null&&user.getUsername().equals(""))
		{
			jo.put("errormsg", "名字不能为空！");
			jo.put("sure", false);
			return jo;
		}
		if(user.getPassword()==null&&user.getPassword().equals(""))
		{
			jo.put("errormsg", "密码不能为空！");
			jo.put("sure", false);
			return jo;
		}
		if(!user.getPassword().toString().equals(password2)) {
			jo.put("errormsg","两次密码不一致！");
			jo.put("sure", false);
			return jo;
		}
		if(user.getPhone()==null&&user.getPhone().equals(""))
		{
			jo.put("errormsg", "手机号码不能为空！");
			jo.put("sure", false);
			return jo;
		}
		if(user.getAge()==0)
		{
			jo.put("errormsg", "年龄不能为空！");
			jo.put("sure", false);
			return jo;
		}
		if(user.getEmail()==null&&user.getEmail().equals(""))
		{
			jo.put("errormsg", "邮箱不能为空！");
			jo.put("sure", false);
			return jo;
		}
		
		ServiceImpl.add(user);
		Integer userid=this.getId(user.getUsername());
		jo.put("sure", true);
		jo.put("userid", userid);
		return jo;
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

	@Override
	public Integer getId(String username) {	
		return ServiceImpl.getId(username);
	}




}
