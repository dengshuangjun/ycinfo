package com.yc.mapper;

import java.util.List;

import com.yc.entity.Function;

public interface FunctionMapper {

	List<Function> findFunctionsById(String rName,int uid);

}
