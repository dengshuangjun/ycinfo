<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
 	<head>
 		<base href="/Limits/">
	   	<meta charset="utf-8">
	   	<title>用户权限管理系统</title>
	   	<link rel="stylesheet" type="text/css" href="easyui/css/easyui.css">
		<link rel="stylesheet" type="text/css" href="easyui/css/icon.css">
		<link rel="stylesheet" type="text/css" href="easyui/css/demo.css">
		<script type="text/javascript" src="js/jquery-1.11.3.js"></script>
		<script type="text/javascript" src="easyui/js/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="easyui/js/easyui-lang-zh_CN.js"></script>
		<script type="text/javascript" src="js/ajaxfileupload.js"></script>
 	</head>
 			
	<body class="easyui-layout">
		<div data-options="region:'north',border:false" style="height:60px;background:#B3DFDA;padding:10px">north region</div>
		<div data-options="region:'west',split:true,title:'导航'" style="width:180px;height:450px; id="aa" class="easyui-accordion"">
			<%-- <c:forEach items="${roles }" var="item">
        		<div title=${roles.rname }>  
		        	<ul class="easyui-tree" id="menu-tree">
						
					</ul>  
		    	</div> 
        	</c:forEach> --%>
        	<div title="昨天">  
		        	<ul class="easyui-tree" id="menu-tree">
						
					</ul>  
		    	</div>
		</div>
		<div data-options="region:'south',border:false" style="height:50px;background:#A9FACD;">
					<p style="text-align: center ;">&copy;版权所有：源辰信息有限公司</p>
		</div>
		<div data-options="region:'center',title:'Center'">
				
		</div>
	</body>
</html>