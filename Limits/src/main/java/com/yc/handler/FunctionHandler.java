package com.yc.handler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.entity.Function;
import com.yc.service.Functionservice;

@Controller
@RequestMapping("/list")
public class FunctionHandler{
	
	@Autowired
	private Functionservice functionservice;
	
	@RequestMapping("/Functions.do")
	@ResponseBody
	public List<Function> Functions(String rName, Model model) {
		List<Function> functions=functionservice.findFunctionsById(rName);		
		return functions;		
	}
}
