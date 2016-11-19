package com.yc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.entity.Function;
import com.yc.entity.FunctionT;
import com.yc.entity.FunctionTree;
import com.yc.entity.User;
import com.yc.mapper.FunctionMapper;
import com.yc.service.Functionservice;
@Service("functionservice")
public class Functionserviceimpl implements Functionservice {
	
	@Autowired
	private FunctionMapper functionMapper;
	
	@Override
	public List<Function> findnextFunction(String rName,int uid) {
		return functionMapper.findnextFunction(rName,uid);
	}
	@Override
	public int update(Function function) {
		return functionMapper.update(function);
	}

	@Override
	public int deleteById(int fid) {
		return functionMapper.deleteById(fid);
	}

	@Override
	public FunctionTree<FunctionT> functionTree(User user) {
		return functionMapper.functionTree(user);
	}

}
