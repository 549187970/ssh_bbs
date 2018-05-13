package com.xrom.ssh.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "PostDetails")
public class PostDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer postDid;
	
	
	@Column(name = "mainID",length=10)
	private Integer mainID;
	
	@Column(name = "title",length=25)
	private String title;
	
	@Column(name = "cont",length=100)
	private String cont;
	
	@Column(name = "userID",length=10)
	private Integer userID;

	@Column(name = "isMainPost")
	private boolean isMainPost;
	
	public boolean isMainPost() {
		return isMainPost;
	}

	public void setMainPost(boolean isMainPost) {
		this.isMainPost = isMainPost;
	}

	public Integer getPostDid() {
		return postDid;
	}

	public void setPostDid(Integer postDid) {
		this.postDid = postDid;
	}

	public Integer getMainID() {
		return mainID;
	}

	public void setMainID(Integer mainID) {
		this.mainID = mainID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCont() {
		return cont;
	}

	public void setCont(String cont) {
		this.cont = cont;
	}

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public PostDetails() {
		
	}

	public PostDetails(Integer postDid, Integer mainID, String title, String cont, Integer userID, boolean isMainPost) {
		super();
		this.postDid = postDid;
		this.mainID = mainID;
		this.title = title;
		this.cont = cont;
		this.userID = userID;
		this.isMainPost = isMainPost;
	}
	
	
}
