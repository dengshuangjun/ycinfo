<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<base href="/Ssm2/">
    <title>登录页面</title>
    <meta charset="utf-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	
</head>
<body>
	<form action="front/login.do" method="post" style="text-align: center; margin: 80px auto; width: 360px;">
		<table>
			<tr>
				<td>用户编号：</td>
				<td><input type="text" name="id" value=""/></td>
			</tr>
			<tr>
				<td>用户名称：</td>
				<td><input type="password" name="name" value="" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="登录" /></td>
			</tr>
		</table>
	</form>
	<div class="input-group">
		<!--   显示登陆出错信息 -->
		<p class="input-group-btn"
			style="text-align: center; color: red;">${errorMsg}</p>
	</div>
</body>
</html>