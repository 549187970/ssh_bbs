package com.xrom.ssh.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "Post")
public class Post {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer postID;
	
	@Column(name = "postTheme",length=25)
	private String postTheme;
	
	@Column(name = "postNumber",length=25)
	private Integer postNumber;
	
	@Column(name = "whoposted",length=10)
	private String whoposted;
	
	@Column(name = "lastPost",length=25)
	private Date lastPost;

	public Post() {
		
	}
	
	public Post(Integer postID, String postTheme, Integer postNumber, String whoposted, Date lastPost) {
		super();
		this.postID = postID;
		this.postTheme = postTheme;
		this.postNumber = postNumber;
		this.whoposted = whoposted;
		this.lastPost = lastPost;
	}

	public Integer getPostID() {
		return postID;
	}

	public void setPostID(Integer postID) {
		this.postID = postID;
	}

	public String getPostTheme() {
		return postTheme;
	}

	public void setPostTheme(String postTheme) {
		this.postTheme = postTheme;
	}

	public Integer getPostNumber() {
		return postNumber;
	}

	public void setPostNumber(Integer postNumber) {
		this.postNumber = postNumber;
	}

	public String getWhoposted() {
		return whoposted;
	}

	public void setWhoposted(String whoposted) {
		this.whoposted = whoposted;
	}

	public Date getLastPost() {
		return lastPost;
	}

	public void setLastPost(Date lastPost) {
		this.lastPost = lastPost;
	}
	
	
}
