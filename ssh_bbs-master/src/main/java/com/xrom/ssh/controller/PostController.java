package com.xrom.ssh.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.xrom.ssh.entity.BBSUser;
import com.xrom.ssh.entity.MostPostNum;
import com.xrom.ssh.entity.Post;
import com.xrom.ssh.entity.PostDetails;
import com.xrom.ssh.service.BBSUserService;
import com.xrom.ssh.service.MostPostNumService;
import com.xrom.ssh.service.PostDetailsService;
import com.xrom.ssh.service.impl.BBSUserServiceImpl;
import com.xrom.ssh.service.impl.PostServiceImpl;

@Controller
public class PostController {
	
	@Autowired
	private PostServiceImpl PostService;
	
	@Autowired(required=true)
	private MostPostNumService mostPostNumService;
	
	@Autowired
	private PostDetailsService postDetailsService;
	
	@Autowired(required=true)
	private BBSUserService BBSUserServiceImpl;
	
	@RequestMapping(value = "/bbs")
    public String getPost(Model m,BBSUser u,HttpServletRequest request) {
		List list=postDetailsService.getPostDetailsisMainPost();
		m.addAttribute("post",list);
		m.addAttribute("postnum", list.size());
		HttpSession hs=request.getSession();
		if(u.getUsername()!=null) {
			hs.setAttribute("username", u.getUsername());
			if(u.getId()==null) {
				BBSUser bu=BBSUserServiceImpl.getUserfromName(u.getUsername());
				hs.setAttribute("userid", bu.getId());
			}
		}
        return "article";
    }
	
	@RequestMapping(value = "/articleDetail", method = RequestMethod.GET)
    public String getPostDetails(@RequestParam("id")Integer mainID,Model m) {	
		List<PostDetails> Postlist=postDetailsService.getPostDetailsMainID(mainID);
		m.addAttribute("post",Postlist);
		List<String> PostListName=new ArrayList<String>();
		m.addAttribute("mainid",mainID);
		int i=0;
		for(PostDetails p:Postlist) {
			if(p.getUserID()!=null) {
			PostListName.set(i,BBSUserServiceImpl.getUser(p.getUserID()).getUsername());
			}else {
				PostListName.add(i, "游客");
			}
			i++;
		}
		m.addAttribute("postUsername",PostListName);
        return "articleDetailFlat";
    }
	
	@RequestMapping(value = "/post", method = RequestMethod.GET)
    public String goPost(@RequestParam("postid")Integer postID,Model m) {
		
		Post p=PostService.getPost(postID);
		m.addAttribute("username",p.getWhoposted());
        return "index";
    }
	
	@RequestMapping(value = "/toPost", method = RequestMethod.GET)
    public String newPost() {
        return "post";
    }
	
	@RequestMapping(value = "/createPost", method = RequestMethod.POST)
    public String postHandle(PostDetails p,Model m,HttpServletRequest request) {
		Map<String,Object> m2=m.asMap();
		p.setUserID((Integer)m2.get("UserID"));
		postDetailsService.addPost(p);
        return "redirect:bbs";
    }
	
	@RequestMapping(value = "/reply", method = RequestMethod.GET)
    public String reply(@RequestParam("id")Integer mainid,Model m,HttpServletRequest request) {
		Integer userid=(Integer)request.getSession().getAttribute("userid");
		String name=(String)request.getSession().getAttribute("username");
		if((name!=null&&!name.equals(""))&&BBSUserServiceImpl.getId(name).equals(userid)) {
			if(mainid!=null&&!"".equals(mainid)) {
				m.addAttribute("replytitle", "发布新帖子");
				return "reply";
			}
			m.addAttribute("replytitle", "回复帖子");
			m.addAttribute("mainID", mainid);
	        return "reply";
		}else {
			m.addAttribute("title", "登陆提醒");
			m.addAttribute("msg", "你没有登陆不能回复帖子。");
			return "message";
		}
        
    }
	
	@RequestMapping(value = "/publish", method = RequestMethod.GET)
    public String mainReply(Model m,HttpServletRequest request) {
		Integer userid=(Integer)request.getSession().getAttribute("userid");
		String name=(String)request.getSession().getAttribute("username");
		System.out.println("userid:"+userid+";"+"name:"+name);
		if((name!=null&&!name.equals(""))&&(userid.equals(BBSUserServiceImpl.getId(name)))) {
				m.addAttribute("replytitle", "发布新帖子");
				return "reply";
			
		}else {
			m.addAttribute("title", "登陆提醒");
			m.addAttribute("msg", "你没有登陆不能回复帖子。");
			return "message";
		}
        
    }

	@RequestMapping(value = "/replyDeal", method = RequestMethod.POST)
    public String toReplyDeal(Model m,PostDetails p,HttpServletRequest request) {
		Integer userid=(Integer)request.getSession().getAttribute("userid");
		p.setUserID(userid);
		if(p.getMainID()!=null&&!"".equals(p.getMainID())) {
			p.setMainPost(true);
			postDetailsService.addMainPost(p);
			return "bbs";
		}else {
			p.setMainPost(false);
			postDetailsService.addPost(p);
	        return "redirect:articleDetail?id="+p.getMainID();
		}
    }
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(@RequestParam("postDid")Integer postDid,@RequestParam("userID")Integer userID,Model m,@RequestParam("mainID")Integer mainID,HttpServletRequest request) {
		System.out.println(mainID+"");
		String name=(String)request.getSession().getAttribute("username");
		System.out.println(name+"");
		if(name!=null&&mainID!=null) 
		{
			BBSUser u=BBSUserServiceImpl.getUser(userID);
			System.out.println(u.getUsername()+"---"+u.getPassword()+"---"+u.getAge());
			if(!(name.equals("admin")||name.equals(u.getUsername()))) {
				m.addAttribute("title", "权限受制");
				m.addAttribute("msg", "你不是管理员和该帖楼主，你没有权限删除帖子。");
				return "message";
			}
			postDetailsService.deletePostDetailsfromMainID(postDid, mainID);
	        return "redirect:bbs";
		}
		else{
			m.addAttribute("title", "权限受制");
			m.addAttribute("msg", "你没有登陆无权删除帖子。");
			return "message";
		}
		
    }

}
