package com.yc.mapper;

import java.util.List;

import com.yc.entity.Role;

public interface RoleMapper {

	List<Role> findRolesById(int uid);

	int saveRole(Role role);

	int deleteRoleById(int rid);

	int updateRole(Role role);

	List<Role> findRolesByPages(int page, int size);

}
