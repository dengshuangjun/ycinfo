<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<!-- 以下是用来显示添加用户信息的面板 -->
	<!-- 以下是用来显示用户信息的数据表格 -->
<table id="userData"></table>  
		<div id="userGrid_bar" style="padding:5px;height:auto">
				<a href="javascript:void(0)" onclick="delUsers()" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">删除</a>
				<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="append()">添加</a>
</div>
	<div id="userGridwin">
				<div style="padding:10px 60px 20px 60px">
	    <form id="userform" class="easyui-form" method="post" data-options="novalidate:true" action="front/addUser.do" >
	    	<table cellpadding="5">
	    		<tr>
	    			<td>用户名:</td>
	    			<td><input id="uname" class="easyui-textbox" type="text" name="uname" data-options="required:true"></input></td>
	    		</tr>
	    		<tr>
	    			<td>密码:</td>
	    			<td><input id="upwd" class="easyui-textbox" type="password" name="upwd" data-options="required:true"></input></td>
	    		</tr>
	    		<tr>
	    			<td>确认密码:</td>
	    			<td><input id="rpwd" class="easyui-textbox" type="password" name="rpwd" data-options="required:true"></input></td>
	    		</tr>
	    	</table>
	    </form>
	    <div style="text-align:center;padding:5px">
	    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">添加</a>
	    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">重置</a>
	    </div>
	    </div>
	
	</div>  


		<script type="text/javascript">
		$('#userGridwin').dialog({ 
			title:"添加",
		    width:450,  
		    height:200,  
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
		
		}
		function submitForm(){
			$('#userform').form('submit',{
				onSubmit:function(){
					if($("#uname").val().length<2){
						$.messager.alert('错误','用户名长度不能太短...');  
						return false;
					}else if($("#upwd").val()==""){
						$.messager.alert('错误','密码不能为空...');  
						return false;
					}else if($("#upwd").val()!=$("#rpwd").val()){
						$.messager.alert('错误','密码输入不一致...');  
						return false;
					}
					return true;
				},
				success:function(data){
					if(data>0){
						$.messager.show({
							title:'成功提示',
							msg:'添加成功',
							timeout:5000,
							showType:'slide'
						});
						$('#userData').datagrid("reload");
					}
					
				}
			});
		}
		function clearForm(){
			$('#userform').form('clear');
		}
		</script>
