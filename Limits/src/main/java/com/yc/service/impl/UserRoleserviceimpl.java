package com.yc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.entity.TempPage;
import com.yc.entity.UserRole;
import com.yc.mapper.UserMapper;
import com.yc.mapper.UserRoleMapper;
import com.yc.service.UserRoleservice;
@Service("userRoleservice")
public class UserRoleserviceimpl implements UserRoleservice {
	@Autowired
	private UserRoleMapper userRoleMapper;

	@Override
	public int updateUserRole(UserRole userRole) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public UserRole findUserRoleById(int id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<UserRole> findUserRoleByUserId(int uid) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean saveUserRole(UserRole userRole) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean saveUserRole(UserRole userRole, int[] role_id) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public TempPage<UserRole> findUserRoles(int page, int size) {
		return userRoleMapper.findUserRoles(page,size);
	}


	@Override
	public int deleteById(int id) {
		return userRoleMapper.deleteById(id);
	}


	@Override
	public List<UserRole> findRoleByuid(int user_id) {
		return userRoleMapper.findRoleByuid(user_id);
	}

}
