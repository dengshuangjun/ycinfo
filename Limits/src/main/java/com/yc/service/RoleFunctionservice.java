package com.yc.service;

import java.util.List;
import org.springframework.stereotype.Repository;

import com.yc.entity.RoleFunction;

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

}
