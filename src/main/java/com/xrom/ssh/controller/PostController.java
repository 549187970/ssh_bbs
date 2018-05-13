package com.xrom.ssh.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String getPost(Model m) {
		m.addAttribute("post",postDetailsService.getPostDetailsisMainPost());
        return "article";
    }
	
	@RequestMapping(value = "/articleDetail", method = RequestMethod.GET)
    public String getPostDetails(@RequestParam("id")Integer mainID,Model m) {
		m.addAttribute("post",postDetailsService.getPostDetailsMainID(mainID));
		List<PostDetails> Postlist=postDetailsService.getPostDetailsMainID(mainID);
		List<String> PostListName=new ArrayList<String>();
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
    public String postHandle(PostDetails p,Model m) {
		MostPostNum mpn=mostPostNumService.getNum(1);
		System.out.println(mpn.getId()+"------"+mpn.getMostPostNum());
		mpn.setMostPostNum(mpn.getMostPostNum()+1);
		System.out.println(mpn.getId()+"------"+mpn.getMostPostNum());
		p.setMainID(mpn.getMostPostNum());
		mostPostNumService.update(mpn);
//		Map<String,Object> m2=m.asMap();
//		p.setUserID((Integer)m2.get("UserID"));
		postDetailsService.addPost(p);
        return "index";
    }
	
	@RequestMapping(value = "/reply", method = RequestMethod.GET)
    public String reply(@RequestParam("id")Integer mainID,Model m) {
		m.addAttribute("mainID", mainID);
        return "reply";
    }

	@RequestMapping(value = "/replyDeal", method = RequestMethod.POST)
    public String toReplyDeal(Model m,PostDetails p) {
		p.setMainPost(false);
		postDetailsService.addPost(p);
        return "redirect:articleDetail?id="+p.getMainID();
    }
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(@RequestParam("postDid")Integer postID,Model m,@RequestParam("mainID")Integer mainID) {
		
		postDetailsService.deletePostDetailsfromMainID(postID, mainID);
        return "redirect:bbs";
    }

}
