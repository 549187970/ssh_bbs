package com.xrom.ssh.controller;

import com.xrom.ssh.entity.BBSUser;
import com.xrom.ssh.entity.Post;
import com.xrom.ssh.service.BBSUserService;
import com.xrom.ssh.service.PersonService;
import com.xrom.ssh.service.PostDetailsService;
import com.xrom.ssh.service.impl.BBSUserServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by XRom
 * On 11/16/2017.11:59 PM
 */
@Controller("/person")
public class TestController {
	


	@Autowired(required=true)
	private BBSUserServiceImpl userService;
	
    @Autowired(required=true)
    private PersonService personService;
    
    @Autowired
	private PostDetailsService postDetailsService;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        return "test";
    }
    
    @RequestMapping(value = "/bbsIndex", method = RequestMethod.GET)
    public String tobbsIndex() {
        return "mybbs";
    }
    
    
    
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String toindex(BBSUser u,Model m) {
    	BBSUser user=userService.getUserfromName(u.getUsername());
    	if(user==null)
    	{
    		return "test";
    	}else {
    		if(user.getPassword().equals(u.getPassword())) {
    			m.addAttribute("username", user.getUsername());
    			//m.addAttribute("post",postDetailsService.getPostDetailsisMainPost());
    			return "forward:bbs";
    		}
    		return "test";
    	}
    }
    
    @RequestMapping(value = "/index")
    public String goindex(Model m,@RequestParam("username")String username) {
    	m.addAttribute("username", username);
		m.addAttribute("post",postDetailsService.getPostDetailsisMainPost());
        return "article";
    }
    
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String toRegister() {
        return "register";
    }
    
    @RequestMapping(value = "/register_action", method = RequestMethod.POST)
    public String registerAction(BBSUser u,@RequestParam("password2")String password2,Model m) {
    	
    	if(userService.saveUser(u,password2)) {
	    	m.addAttribute("username",u.getUsername());
	        return "article";
    	}
    	return "register";
    }
    
}
