package com.yc.handler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.yc.entity.Function;
import com.yc.entity.User;
import com.yc.service.Functionservice;

@Controller
@RequestMapping("/function")
@SessionAttributes("user")
public class FunctionHandler{
	
	@Autowired
	private Functionservice functionservice;
	
	@RequestMapping("/Functions.do")
	@ResponseBody
	public List<Function> Functions(User user,String rName, Model model) {
		System.out.println(rName);
		List<Function> functions=functionservice.findFunctionsById(rName,user.getUid());
	
		return functions;		
	}
}
