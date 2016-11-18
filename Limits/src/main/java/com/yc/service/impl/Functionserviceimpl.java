package com.yc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.entity.Function;
import com.yc.mapper.FunctionMapper;
import com.yc.mapper.RoleMapper;
import com.yc.service.Functionservice;
@Service("functionservice")
public class Functionserviceimpl implements Functionservice {
	
	@Autowired
	private FunctionMapper functionMapper;
	
	@Override
	public List<Function> findFunctionsById(String rName,int uid) {
		return functionMapper.findFunctionsById(rName,uid);
	}
	@Override
	public int updateUrl(int id, String url) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteById(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Function> findALlFunctions() {
		// TODO Auto-generated method stub
		return null;
	}


}
