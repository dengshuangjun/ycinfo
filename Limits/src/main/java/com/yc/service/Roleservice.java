package com.yc.service;

import java.util.List;

import com.yc.entity.Role;
public interface Roleservice{
	
    /**
     * 根据用户id查找属于他角色
     * @param id id
     * @return
     */
	List<Role> findRolesById(int uid);

 

    /**
     *  保存角色 
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
	 * 分页查询
	 * @param page
	 * @param size
	 * @return
	 */
    List<Role> findRolesByPages(int page,int size);


    /**
     * 添加角色，同时给角色赋予指定的权限
     * @param fids
     * @param rname
     * @return
     */
	boolean addRole(String fids, String rname);

}
