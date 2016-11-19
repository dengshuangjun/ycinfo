<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<!-- 以下是用来显示添加用户信息的面板 -->
	<div id="userGridwin">
			<table cellpadding="5">
			<tr>
				<td>用户名:</td>
				<td><input class="easyui-validatebox textbox" data-options="required:true,validType:'length[3,10]'"></td>
			</tr>
			<tr>
				<td>密码:</td>
				<td><input type="password" class="easyui-validatebox textbox" data-options="required:true,validType:'length[3,10]'"></td>
			</tr>
			</table>
			<div class="easyui-panel" style="padding:5px">
				<ul id="addUserPanl" ></ul>
			</div>
	</div>  

<!-- 以下是用来显示用户信息的数据表格 -->
<table id="userData"></table>  
		<div id="userGrid_bar" style="padding:5px;height:auto">
				<a href="javascript:void(0)" onclick="delUsers()" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">删除</a>
				<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="append()">添加</a>
		</div>
		<script type="text/javascript">
		$('#userGridwin').window({ 
			title:"添加",
		    width:450,  
		    height:400,  
		    modal:false,
		    closed:true,
		    top:200,
		    left:800
		   
		});
		//var options=$('#center_content').panel('options');
		var editIndex = undefined;
		 var userObj;
		userObj=$('#userData').datagrid({
			singleSelect:true,
			url:'front/findUser.do',
			striped:true,
			loadMsg:"正在加载中...",
			pagination:true,
			pageNumber:1,
			pageSize:10,
			pageList:[10,20,30,40,50],
			remoteSort:false,
			toolbar:"#userGrid_bar",
			columns:[[
			  		{field:'uid',sortable:true,align:'center',checkbox:true},
			  		{field:'uname',title:'用户名',width:200,align:'center'},
			  		{field:'registertime',title:'注册时间',width:180,align:'center'},
			  		{field:'updatetime',title:'上次修改时间',width:180,align:'center'}]]
			
		}); 
		function delUsers(){
			var rows=userObj.datagrid("getSelections");
			if(rows!=undefined&&rows!=''){
				$.messager.confirm('信息确认','您确定要删除选定的数据吗?', function(r){
					if (r){
						var nids="";
					for(var i=0;i<rows.length-1;i++){
						nids+=rows[i].uid+",";
					}
					nids+=rows[rows.length-1].uid;
					$.post("front/removeUser.do",{uid:nids},function(data){
						if(data){
							$.messager.show({
								title:'成功提示',
								msg:'删除成功',
								timeout:2000,
								showType:'slide'
							});
							rows=undefined;
							$('#userData').datagrid('reload');//刷新表格
						}else{
							$.messager.alert('失败提示','删除失败','error');
						}
					});
					}
				});
			}else{
				$.messager.alert('温馨提示','请选择要删除的数据...','info');
			}
		}
		function append(){
			$('#userGridwin').window('open');
			$('#addUserPanl').tree({  
			    url:'function/functionTree.do' ,  
			    animate:true,
			    checkbox:true 
			}); 
		}
		</script>
