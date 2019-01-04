package com.xrom.ssh.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;

@Data
@Entity
@Table(name = "BBSUser",uniqueConstraints ={@UniqueConstraint(columnNames="username")})
public class BBSUser {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "username",length=10)
	private String username;
	
	@Column(name = "password",length=15)
	private String password;
	
	@Column(name = "age",length=3)
	private int age;
	
	@Column(name = "phone",length=11)
	private String phone;
	
	@Column(name = "email",length=20)
	private String Email;
	
	public BBSUser() {
		
	}
	
	public BBSUser(Integer id,String username, String password, int age, String phone, String email) {
		super();
		this.id=id;
		this.username = username;
		this.password = password;
		this.age = age;
		this.phone = phone;
		Email = email;
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	
}
