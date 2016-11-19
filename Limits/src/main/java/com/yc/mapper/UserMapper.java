package com.yc.mapper;

import java.util.List;

import com.yc.entity.TempPage;
import com.yc.entity.User;

public interface UserMapper {

	User login(String name, String pwd);

	TempPage<User> findPage(int page,int size);

	int save(User user);

	User findById(int uid);

	int update(User user);

	int deleteById(int uid);



}
