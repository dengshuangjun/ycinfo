package com.yc.handler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.yc.entity.User;
import com.yc.utils.SessionAttributeKey;

@Controller
@RequestMapping("/front")
@SessionAttributes("user")
public class UserHandler extends BasicHandler{
	
	   @RequestMapping("login.do")
		public String Login(User user,Model model){
		   if(user.getUid()==0){
			   model.addAttribute(SessionAttributeKey.LOGIN_ADMIN, user);
			   System.out.println(user);
				return "page/list";
		   }else{
			   return "index";
		   }
		
		}
}
