package com.yc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.entity.User;
import com.yc.mapper.UserMapper;
import com.yc.service.Userservice;
@Service("userservice")
public class Userserviceimpl implements Userservice {
	
	@Autowired
	private UserMapper userMapper;
	@Override
	public User getUser(String name, String pwd) {
		return 	userMapper.login(name,pwd);
	}

	@Override
	public int save(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteById(int uid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User fingById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findPage(int page, int size) {
		// TODO Auto-generated method stub
		return null;
	}

}
