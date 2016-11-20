package com.yc.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.yc.entity.RoleFunction;
import com.yc.entity.UserRole;

@Repository
public interface RoleFunctionservice{
	
	/**
     * 根据id查找RoleFunctions
     * @param id id
     * @return 返回值
     */
	RoleFunction findRoleFunctionById(int id);
	
	/**
     * 根据RoleId查找RoleFunctions实体类
     * @param roleId    角色id
     */
    List<RoleFunction> findRoleFunctionsByRoleId(int rid);
    

    /**
     * 根据角色roleid删除auth_role_function记录
     * @param roleid 角色id
     */
    int deleteByRoleId(int rid);
    
    /**
     * 保存RoleFunction对象
     * @param roleFunctions
     */
    boolean saveRoleFunction(RoleFunction roleFunction);

    /**
     * 批量保存角色功能对应关系
     * @param userRoles 用户角色对应关系集合
     */
    boolean saveRoleFunction(RoleFunction roleFunction,int[] function_id);

}
