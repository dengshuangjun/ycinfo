package com.yc.service;

import com.yc.entity.Function;

import java.util.List;



public interface Functionservice{

    /**
     * 根据id更新Url
     * @param id
     * @param url
     */
    int updateUrl(int id,String url);
       

    /**
     * 根据parentId去查找功能 分页
     * @param page
     * @param size
     * @param parentId
     * @return
     */
    List<Function> findFunctions(int page,int size,int parentId);
       

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
