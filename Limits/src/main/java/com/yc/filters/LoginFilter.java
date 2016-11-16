package com.yc.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yc.utils.SessionAttributeKey;

public class LoginFilter implements Filter {
	private static String mainPage="/index.jsp";
	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		System.out.println("过滤器");
			String path=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
			response.getWriter().print("<script>location.href='"+path+mainPage+"'</script>");
			return;
		
	
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		mainPage=arg0.getInitParameter("MainPage");
	}

}
