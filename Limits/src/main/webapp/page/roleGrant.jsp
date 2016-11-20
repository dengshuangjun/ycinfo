<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<div id="dg" style="padding:5px;height:auto" ></div>
	
	<script type="text/javascript">
		var userObj;
		userObj=$('#dg').datagrid({
			singleSelect:true,
			url:'UserRole/findUserRole.do',
			striped:true,
			loadMsg:"正在加载中...",
			pagination:true,
			pageNumber:1,
			pageSize:10,
			pageList:[10,20,30,40,50],
			remoteSort:false,
			columns:[[
			  		{field:'id',sortable:true,align:'center',title:'编号'},
			  		{field:'uname',title:'用户名',width:200,align:'center'},
			  		{field:'rname',title:'角色名称',width:180,align:'center'},
			  		{field:'_operate',title:'操作',width:100,align:'center',
			        	  formatter:function(value,rowData,index){
			        		  return '<a class="remove" onclick="removeUser('+rowData.id+')"></a>';
			        	  }
			          }
			  		]],
			  		onLoadSuccess:function(data){  //为格式化列添加样式，变成有图标的按钮
			  			$('.remove').linkbutton({text:'删除',plain:true,iconCls:'icon-remove'});
					}
			
		}); 
		
		//删除
		function removeUser(id){  
			alert(id);
			$.post("UserRole/remove.do",{id:id},function(data){
				if(data=1){
					$.messager.show({
						title:'成功提示',
						msg:'删除成功...',
						timeout:2000,
						showType:'slide'
					});
					$("#dg").datagrid("reload");//页面刷新
				}else{
					$.messager.alert('失败提示','删除失败...','error');
				}
			});  
		}
	</script>