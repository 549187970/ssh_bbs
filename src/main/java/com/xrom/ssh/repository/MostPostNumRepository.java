package com.xrom.ssh.repository;


import com.xrom.ssh.entity.MostPostNum;

public interface MostPostNumRepository {

	void add(MostPostNum m);
	 
	MostPostNum getNum(Integer id);
	 
	void update(MostPostNum m);
	 
}
