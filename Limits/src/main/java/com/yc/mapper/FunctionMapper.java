package com.yc.mapper;

import java.util.List;

import com.yc.entity.Function;

public interface FunctionMapper {

	List<Function> findFunctionsByrName(String rName);

	int update(Function function);

	int deleteById(int fid);

}
