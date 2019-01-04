package com.xrom.ssh.service;

import com.xrom.ssh.entity.MostPostNum;

public interface MostPostNumService {

	void add(MostPostNum m);
	 
	MostPostNum getNum(Integer id);
	 
	void update(MostPostNum m);
}
