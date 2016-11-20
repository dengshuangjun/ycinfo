package com.yc.handler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.entity.TempPage;
import com.yc.entity.UserRole;
import com.yc.service.UserRoleservice;


@Controller
@RequestMapping("/UserRole")
public class UserRoleHandler extends TreeHandler{
	
	@Autowired
	private UserRoleservice serRoleservice;
	
	//获取分页信息
	@RequestMapping("findUserRole.do")
	@ResponseBody
	public TempPage<UserRole> findUserRole(int page,int rows) {
		TempPage<UserRole> userRoles = serRoleservice.findUserRoles(page-1,rows);
		System.out.println("结果集"+userRoles);
		return userRoles;	
	}
	
	//删除数据
	@ResponseBody
	@RequestMapping("remove.do")
	public int remove(int id){
		System.out.println("要删除的id"+id);
		int result=serRoleservice.deleteById(id);
		return result;
	}
	
	//根据传来的uid获取该用户的角色信息
	@RequestMapping("findRoleByuid.do")
	@ResponseBody
	public List<UserRole> findRoleByuid(int user_id, Model model) {
		List<UserRole> userRoles = serRoleservice.findRoleByuid(user_id);
		System.out.println("结果集"+userRoles);
		return userRoles;	
	}

}
