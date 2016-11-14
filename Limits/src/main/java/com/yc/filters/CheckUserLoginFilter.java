package com.yc.filters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yc.utils.SessionAttributeKey;



public class CheckUserLoginFilter implements Filter {
	
	private String errorPage="index.jsp";//错误页面
	//销毁方法
	public void destroy() {

	}
	/**
	 * 过滤方法
	 */
	public void doFilter(ServletRequest arg0, ServletResponse arg1,FilterChain arg2) throws IOException, ServletException {
		//检验该用户是否登入
		HttpServletRequest request=(HttpServletRequest) arg0;
		HttpServletResponse response=(HttpServletResponse) arg1;
		HttpSession session=request.getSession();
		System.out.println(session.getAttribute(SessionAttributeKey.LOGIN_USER));
		if(SessionAttributeKey.LOGIN_USER==null){
			System.out.println(SessionAttributeKey.LOGIN_USER);
			PrintWriter out=response.getWriter();
			//获取基址路径，即webroot下
			String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
			out.print("<script>alert('请先登入.......');location.href='"+basePath+errorPage+"';</script>");
			out.flush();
			out.close();
		}else{
			//说明已经登入
			arg2.doFilter(arg0, arg1);
		}
	}
	/**
	 * 初始化方法
	 */
	public void init(FilterConfig arg0) throws ServletException {
		String temp=arg0.getInitParameter("errorPage");
		if(temp!=null){//说明配置了初始化页面信息
			errorPage=temp;
		}

	}

}
