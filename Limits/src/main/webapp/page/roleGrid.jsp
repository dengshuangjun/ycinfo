<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<table id="roleData"></table> 



<script type="text/javascript">
roleData=$('#roleData').datagrid({
	singleSelect:true,
	url:'list/findRolesByPages.do',
	striped:true,
	loadMsg:"正在加载中...",
	pagination:true,
	pageNumber:1,
	pageSize:10,
	pageList:[10,20,30,40,50],
	remoteSort:false,
	columns:[[
	  		{field:'rid',sortable:true,align:'center',checkbox:true},
	  		{field:'rname',title:'角色名',width:200,align:'center'},
	  		{field:'addtime',title:'注册时间',width:180,align:'center'},
	  		{field:'updatetime',title:'上次修改时间',width:180,align:'center'}]]
	
}); 
</script>
	