package com.yc.mapper;

import com.yc.entity.User;

public interface UserMapper {

	User login(String name, String pwd);

}
