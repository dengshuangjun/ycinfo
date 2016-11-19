package com.yc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.entity.TempPage;
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
		return userMapper.save(user);
	}

	@Override
	public int deleteById(int uid) {
		return userMapper.deleteById(uid);
	}

	@Override
	public int update(User user) {
		return userMapper.update(user);
	}

	@Override
	public User fingById(int uid) {
		return userMapper.findById(uid);
	}

	@Override
	public TempPage<User> findPage(int page,int size) {
		return userMapper.findPage(page,size);
	}



}
