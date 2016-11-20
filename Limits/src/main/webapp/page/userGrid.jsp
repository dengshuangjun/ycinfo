<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<!-- 以下是用来显示添加用户信息的面板 -->
	<div id="userGridwin">
			<form id="userform" method="post" action="front/addUser.do"  style="padding:10px 60px 20px 60px" >  
			<table cellpadding="5">
	    		<tr>
	    			<td><label for="uname">用户名:</label> </td>
	    			<td><input class="easyui-validatebox" type="text" name="uname" data-options="required:true,validType:'length[3,10]'" />  </td>
	    		</tr>
	    		<tr>  
				      <td>  <label for="upwd">密  码:</label>  </td>
				       <td> <input id="pwd" class="easyui-validatebox"  type="password"  name="upwd" data-options="required:true,validType:'length[6,16]'" /> </td>
				    </tr>
				  	<tr>  
				       <td>  <label for="uupwd">确认密码:</label>  </td>
				        <td> <input id="rpwd" class="easyui-validatebox"  type="password"  name="uupwd" data-options="required:true,validType:'length[6,16]'" validType="equals['#pwd']"  />  </td>
				  </tr>
	    	</table>
	    	<div style="text-align:center;padding:5px">
	    		<button onclick="submitForm()" >添加</button>
	    		<button onclick="clearForm()" >重置</button>
	    	
	    </div>
		</form> 
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
		
		}
		function submitForm(){
			$('#userform').form('submit',{
				onSubmit:function(){
					
					return $(this).form('enableValidation').form('validate');
				}
			});
		}
		function clearForm(){
			$('#userform').form('clear');
		}
		</script>
