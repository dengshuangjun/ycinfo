package com.yc.mapper;

import java.util.List;

import com.yc.entity.TempPage;
import com.yc.entity.UserRole;

public interface UserRoleMapper {

	TempPage<UserRole> findUserRoles(int page, int size);

	int deleteById(int id);

	List<UserRole> findRoleByuid(int user_id);

}
