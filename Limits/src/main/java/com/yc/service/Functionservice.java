package com.yc.service;

import com.yc.entity.Function;
import com.yc.entity.FunctionT;
import com.yc.entity.FunctionTree;
import com.yc.entity.User;

import java.util.List;



public interface Functionservice{
	/**
     * 根据rname去查找功能
     * @param rName
     * @return
     */

    List<Function> findnextFunction(String rName,int uid);

    /**
     * 根据id更新function
     * @param function
     */
    int update(Function function);
       

    /**
     * 根据id删除function
     * @param id
     */
    int deleteById(int fid);

	FunctionTree<FunctionT> functionTree(User user);
 
}
