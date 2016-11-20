package com.yc.mapper;

import java.util.List;

import com.yc.entity.Function;
import com.yc.entity.FunctionTree;
import com.yc.entity.User;

public interface FunctionMapper {


	int update(Function function);

	int deleteById(int fid);
	
	List<Function> findnextFunction(String rName,int uid);

	FunctionTree functionTree(User user);

}
