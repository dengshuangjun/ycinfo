package com.yc.mapper;

import java.util.List;

import com.yc.entity.Function;

public interface FunctionMapper {


	int update(Function function);

	int deleteById(int fid);
	
	List<Function> findFunctionsById(String rName,int uid);

}
