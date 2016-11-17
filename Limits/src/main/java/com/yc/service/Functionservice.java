package com.yc.service;

import com.yc.entity.Function;

import java.util.List;



public interface Functionservice{
	/**
     * 根据rname去查找功能
     * @param rName
     * @return
     */
    List<Function> findFunctionsById(String rName);

    /**
     * 根据id更新Url
     * @param id
     * @param url
     */
    int updateUrl(int id,String url);
       

    /**
     * 根据id删除functions
     * @param id
     */
    int deleteById(int id);

    /**
     * 查询全部功能
     * @return 返回功能链表
     */
    List<Function> findALlFunctions();


    

}
