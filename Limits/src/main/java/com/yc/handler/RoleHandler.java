package com.yc.handler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.yc.entity.Role;
import com.yc.entity.User;
import com.yc.service.Roleservice;

@Controller
@RequestMapping("/list")
@SessionAttributes("user")
public class RoleHandler extends TreeHandler{
	
	@Autowired
	private Roleservice roleservice;
	
	@RequestMapping("/Roles.do")
	@ResponseBody
	public List<Role> Roles(User user, Model model) {
		List<Role> roles=roleservice.findRolesById(user.getUid());		
		return roles;		
	}
	@RequestMapping("/findRolesByPages.do")
	@ResponseBody
	public List<Role> findRolesByPages(int page, int rows){
		return roleservice.findRolesByPages(page-1,rows);
	}
	@RequestMapping("/delRole.do")
	@ResponseBody
	public int delRole(int rid){
		return roleservice.deleteRoleById(rid);
	}
	@RequestMapping("/addRole.do")
	@ResponseBody
	public boolean addRole(String fids,String rname){
		System.out.println(fids);
		boolean result1= roleservice.addRole(fids,rname);
		
		return result1;
	}
}
