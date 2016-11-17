package com.yc.mapper;

import java.util.List;

import com.yc.entity.Role;

public interface RoleMapper {

	List<Role> findRolesById(int uid);

}
