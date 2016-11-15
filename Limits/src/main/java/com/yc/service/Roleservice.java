package com.yc.service;

import java.util.List;

import com.yc.entity.Role;
public interface Roleservice{
	
    /**
     * 根据id查找用户角色
     * @param id id
     * @return
     */
   Role findRoleById(int id);
 

    /**
     *  保存角色 目的可以将主键带出来。
     * @param role role角色
     */
    int saveRole(Role role);


    /**
     * 根据id删除角色
     * @param roleid    角色的id
     */
    int deleteRoleById(int rid);
     

    /**
     * 根据role对象来更新Role
     * @param role role对象
     */
    int updateRole(Role role);
     

    /**
     * 根据分页查询Roles
     * @param page 页码
     * @param size 每页的大小
     * @return 返回Role的链表
     */
    List<Role> findRolesByPages(int page,int size);

}
