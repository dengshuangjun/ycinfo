package com.yc.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.yc.entity.User;
import com.yc.service.Userservice;
import com.yc.utils.SessionAttributeKey;

@Controller
@RequestMapping("/front")
@SessionAttributes("user")
public class UserHandler{
	
	@Autowired
	private Userservice userservice;

	@RequestMapping("login.do")
	public String Login(User user, Model model) {
		System.out.println("登陆");
		if(user.getUid()!=0){
			model.addAttribute(SessionAttributeKey.LOGIN_ADMIN, user);
			System.out.println(user);
			return "page/list";
		}else{
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
	}
}
