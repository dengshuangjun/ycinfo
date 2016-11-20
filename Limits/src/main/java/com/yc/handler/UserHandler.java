package com.yc.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.yc.entity.TempPage;
import com.yc.entity.User;
import com.yc.service.Userservice;
import com.yc.utils.SessionAttributeKey;

@Controller
@RequestMapping("/front")
@SessionAttributes("user")
public class UserHandler extends TreeHandler{
	
	@Autowired
	private Userservice userservice;
	
	//验证登入
	@RequestMapping("login.do")
	public String Login(User user, Model model) {
		System.out.println("登陆");
		if(user.getUname()==null&&user.getUpwd()==null){
			model.addAttribute("errorMsg", "用户名或密码不能为空...");
			return "index";
		}
			user = userservice.getUser(user.getUname(), user.getUpwd());
			if (user!=null) {
				model.addAttribute(SessionAttributeKey.LOGIN_ADMIN, user);
				System.out.println(user);
				return "page/list";
			} else {
				model.addAttribute("errorMsg", "用户名或密码错误...");
				return "index";
			}
	}
	
	//获取分页信息
	@RequestMapping("findUser.do")
	@ResponseBody
	public TempPage<User> findUser(int page,int rows) {
		TempPage<User> users = userservice.findPage(page-1,rows);
		return users;	
	}
	
	//添加数据
	@RequestMapping("addUser.do")
	@ResponseBody
	public int addUser(User user) {
		int result = userservice.save(user);
		return result;	
	}
	
	//删除数据
	@ResponseBody
	@RequestMapping("removeUser.do")
	public int removeUser(int uid){
		System.out.println("要删除的id"+uid);
		int result=userservice.deleteById(uid);
		return result;
	}
	
	//修改数据
	@ResponseBody
	@RequestMapping(value= "/updataUser",method=RequestMethod.POST)
	public int updataUser(User user) {
		int result=userservice.update(user);
		return result;
	}
	
	//获取某一个用户
	@ResponseBody
	@RequestMapping(value= "/fingById",method=RequestMethod.POST)
	public User fingById(int uid) {
		User user=userservice.fingById(uid);
		return user;
	}
	
}
