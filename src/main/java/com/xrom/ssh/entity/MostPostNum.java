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
@Table(name = "MostPostNum")
public class MostPostNum {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "mostPostNum",length=10)
	private Integer mostPostNum;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getMostPostNum() {
		return mostPostNum;
	}

	public void setMostPostNum(Integer mostPostNum) {
		this.mostPostNum = mostPostNum;
	}

	public MostPostNum(Integer id, Integer mostPostNum) {
		super();
		this.id = id;
		this.mostPostNum = mostPostNum;
	}
	public MostPostNum() {
		
	}
}
