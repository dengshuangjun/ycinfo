package com.yc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.entity.Function;
import com.yc.mapper.FunctionMapper;
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
	public int update(Function function) {
		return functionMapper.update(function);
	}

	@Override
	public int deleteById(int fid) {
		return functionMapper.deleteById(fid);
	}

}
