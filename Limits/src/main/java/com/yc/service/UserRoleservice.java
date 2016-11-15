package com.yc.service;

import java.util.List;

import com.yc.entity.UserRole;

public interface UserRoleservice {

    /**
     * 根据userRole 来更新
     * @param userRole 用户角色
     */
    int updateUserRole(UserRole userRole);

    /**
     * 保存UserRole对象
     * @param userRole
     */
    int saveUserRole(UserRole userRole);

    /**
     * 根据id查找UserRole对象
     * @param id
     * @return
     */
    UserRole findUserRoleById(int id);
    

    /**
     * 分页查询用户角色关系
     * @param page
     * @param size
     * @return
     */
    List<UserRole> findUserRoles(int page,int size);

    /**
     * 根据userId查询用户角色
     * @param uid
     * @return
     */
    List<UserRole> findUserRoleByUserId(int uid);

    /**
     * 批量保存用户角色对应关系
     * @param userRoles 用户角色对应关系集合
     */

}
