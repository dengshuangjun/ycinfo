package com.yc.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/**")
public class BasicHandler {
		private static String  URL="404";
		
		@RequestMapping("/*")
		public String error404(){
			System.out.println("进入404了...");
			return URL;
		}
}
