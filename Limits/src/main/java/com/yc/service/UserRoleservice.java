package com.yc.service;

import java.util.List;

import com.yc.entity.TempPage;
import com.yc.entity.User;
import com.yc.entity.UserRole;

public interface UserRoleservice {

    /**
     * 根据userRole 来更新
     * @param userRole 用户角色
     */
    int updateUserRole(UserRole userRole);


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
    TempPage<UserRole> findUserRoles(int page,int size);

    /**
     * 根据userId查询用户角色
     * @param uid
     * @return
     */
    List<UserRole> findUserRoleByUserId(int uid);
    
    /**
     * 保存UserRole对象
     * @param userRole
     */
    boolean saveUserRole(UserRole userRole);

    /**
     * 批量保存用户角色对应关系
     * @param userRoles 用户角色对应关系集合
     */
    boolean saveUserRole(UserRole userRole,int[] role_id);

    /**
     * 根据id删除用户角色关系
     * @param id
     * @return
     */
	int deleteById(int id);

	/**
	 * 根据uid来查询该用户的角色信息
	 * @param user_id
	 * @return
	 */
	List<UserRole> findRoleByuid(int user_id);
}
