package com.yc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.entity.Role;
import com.yc.entity.RoleFunction;
import com.yc.mapper.RoleMapper;
import com.yc.service.RoleFunctionservice;
import com.yc.service.Roleservice;
@Service("roleservice")
public class Roleserviceimpl implements Roleservice {
	@Autowired
	private RoleMapper roleMapper;
	
	@Autowired
	private RoleFunctionservice roleFunctionservice;
	
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
/**
 * 这里要做事务处理
 */
	@Override
	public boolean addRole(String fids, String rname) {
		Role role = new Role();
		role.setRname(rname);
		int result = roleMapper.saveRole(role);
		if(result>0){
			List<RoleFunction> list=new ArrayList<RoleFunction>();
			int role_id = role.getRid();
			RoleFunction roleFunction=null;
			String[] strs = fids.split(",");
			int j=strs.length;
			for(int i=0;i<j;i++){
				roleFunction=new RoleFunction();
				roleFunction.setRole_id(role_id);
				roleFunction.setFunction_id(Integer.parseInt( strs[i]));
				list.add(roleFunction);
			}
			
		    int result2 = roleFunctionservice.saveRoleFunction(list);
			if(j==result2){
				return true;
			}
		}
		
		
		return false;
	}

}
