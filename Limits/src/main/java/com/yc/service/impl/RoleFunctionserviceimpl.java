package com.yc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.entity.RoleFunction;
import com.yc.mapper.RoleFunctionMapper;
import com.yc.mapper.RoleMapper;
import com.yc.service.RoleFunctionservice;
@Service("roleFunctionservice")
public class RoleFunctionserviceimpl implements RoleFunctionservice {
	
	@Autowired
	private RoleFunctionMapper roleFunctionMapper;
	
	@Override
	public RoleFunction findRoleFunctionById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RoleFunction> findRoleFunctionsByRoleId(int rid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteByRoleId(int rid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean saveRoleFunction(RoleFunction roleFunction) {
		// TODO Auto-generated method stub
//		return roleFunctionMapper.saveRoleFunction(roleFunction);
		return true;
	}

	@Override
	public int saveRoleFunction(List<RoleFunction> role_Function_list) {
		
		
		return roleFunctionMapper.saveRoleFunction(role_Function_list);
	}
	
	

}
