package com.yc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.entity.Role;
import com.yc.mapper.RoleMapper;
import com.yc.mapper.UserMapper;
import com.yc.service.Roleservice;
@Service("roleservice")
public class Roleserviceimpl implements Roleservice {
	@Autowired
	private RoleMapper roleMapper;
	
	
	@Override
	public List<Role> findRolesById(int uid) {
		return roleMapper.findRolesById(uid);
	}

	@Override
	public int saveRole(Role role) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteRoleById(int rid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateRole(Role role) {
		// TODO Auto-generated method stub
		return 0;
	}




}
