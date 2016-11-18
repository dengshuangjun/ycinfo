package com.yc.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 用来处理点击左子树跳转的url
 * @author shuang
 *
 */
@Controller
public class TreeHandler {
	
	@RequestMapping("/{url}.do{arg}")
	public String userGrid(@PathVariable String url,String _){
		System.out.println(url);
		if(url==""||url==null){
			return "404";
		}
		return "page/"+url+".jsp?_="+_;
	}
}
