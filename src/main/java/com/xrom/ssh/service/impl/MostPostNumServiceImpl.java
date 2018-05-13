package com.xrom.ssh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xrom.ssh.entity.MostPostNum;
import com.xrom.ssh.repository.MostPostNumRepository;
import com.xrom.ssh.repository.PostRepository;
import com.xrom.ssh.service.MostPostNumService;

@Service
public class MostPostNumServiceImpl implements MostPostNumService {

	@Autowired(required=true)
	private MostPostNumRepository MostPostNumRepositoryImpl;
	
	@Override
	public void add(MostPostNum m) {
		MostPostNumRepositoryImpl.add(m);
	}

	@Override
	public MostPostNum getNum(Integer id) {
		return MostPostNumRepositoryImpl.getNum(id);
	}

	@Override
	public void update(MostPostNum m) {
		MostPostNumRepositoryImpl.update(m);
	}

}
