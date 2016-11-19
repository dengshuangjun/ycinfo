package com.yc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.entity.Role;
import com.yc.mapper.RoleMapper;
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
		return roleMapper.saveRole(role);
	}

	@Override
	public int deleteRoleById(int rid) {
		return roleMapper.deleteRoleById(rid);
	}

	@Override
	public int updateRole(Role role) {
		return roleMapper.updateRole(role);
	}

	@Override
	public List<Role> findRolesByPages(int page, int size) {
		return roleMapper.findRolesByPages(page,size);
	}

}
