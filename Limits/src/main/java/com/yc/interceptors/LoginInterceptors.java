package com.yc.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.yc.utils.SessionAttributeKey;

public class LoginInterceptors implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object arg2) throws Exception {
		System.out.println(request.getSession().getAttribute(SessionAttributeKey.LOGIN_ADMIN));
		if(request.getSession().getAttribute(SessionAttributeKey.LOGIN_ADMIN)!=null){
			String path=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
			response.getWriter().print("<script>location.href='"+path+"/page/list.jsp'</script>");
			return false;
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {

	}
}
