<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<div class="easyui-layout" data-options="fit:true,border:false"><table id="dg"></table></div>
	
	<script type="text/javascript">
	var DataGrid = undefined;
	var editRow =  undefined;
	var datagrid = undefined;
	$(function() {
		DataGrid=$('#dg').datagrid({
			url:'front/findUser.do',
			loadMsg:"正在加载中...",
			pageNumber:1,
			pageSize:10,
			pageList:[10,20,30,40,50],
			fit : true,
			fitColumns : true,
			border : false,
			pagination : true,
			singleSelect:true,
			view: detailview,
			columns:[[
					{field : 'uids',title : '序列',width : 60,align : 'center'},  
			  		{field:'uid',title:'编号',align:'center',hidden : true},
			  		{field:'uname',title:'用户名',width:200,align:'center'},
			  		{field:'registertime',title:'注册时间',width:180,align:'center'},
			  		{field:'updatetime',title:'上次修改时间',width:180,align:'center'}
			]],
			detailFormatter:function(index,row){
				return '<div id="te" style="padding:2px"><table id="ddv-' + index + '"></table></div>';
			},
			onExpandRow:function(index,row){
				document.getElementById ("te").title ="项目信息";
				datagrid=$('#ddv-'+index).datagrid({ 
	            	url:'UserRole/findRoleByuid.do?user_id='+row.uid,
	            	fitColumns:true,  
	                singleSelect:true,  
	                sortName : 'id',
	    			sortOrder:'asc',
	                height:'auto', 
	                columns:[[  
						{field : 'ids',title : '序列',width : 60,align : 'center'},       
	                    {field:'id',title:'编号',align:'center',hidden : true},
				  		{field:'rname',title:'角色名',width:200,align:'center'},
				  		{field:'_operate',title:'操作',width:100,align:'center',
				        	  formatter:function(value,rowData,index){
				        		  return '<a class="icon-remove icon-padding" href="javascript:removeUserRole(\''+rowData.id+'\')">删除</a>';
				        	  }
				          }
	                ]], 
	                toolbar : [ {
	    				text : "添加",
	    				iconCls : 'icon-add',
	    				handler : function() {
	    					op = "addInfo"; // 当前的操作
	    					flag="添加";
	    					//先判断有没有正在编辑的行
	    					if (editRow != undefined) { //则说明有行正在被编辑，则还原当前的修改
	    						datagrid.datagrid("rejectChanges"); //回滚自创建以来或上次调用AcceptChanges，所有的变化数据
	    						datagrid.datagrid("endEdit",editRow); //关闭当前正在被编辑的行
	    						editRow = undefined;
	    					} else { //在表格的最前面添加一行
	    						datagrid.datagrid("insertRow", {index : 0,row : {}});
	    						//打开编辑器
	    						datagrid.datagrid("beginEdit",0);
	    						editRow = 0; //记录当前正在编辑的行
	    					}
	    				}
	    			},{
	    				text : "保存",
	    				iconCls : 'icon-save',
	    				handler : function() {
	    					datagrid.datagrid("endEdit",editRow); //关闭当前正在被编辑的行
	    					//获取当前被修改的行
	    					var rows = datagrid.datagrid("getChanges")[0];
	    					if (rows == undefined) {
	    						datagrid.datagrid("rejectChanges"); //回滚自创建以来或上次调用AcceptChanges，所有的变化数据
	    						datagrid.datagrid("unselectAll"); //关闭当前正在被编辑的行
	    						editRow = undefined;
	    					} else {
	   							var dirName=rows.dirName;
	   							var dirType=rows.dirType;
	   							$.post("back/datadict_addDatadict",{dirName:dirName,dirType:dirType},function(data) {
	   								if(data.total==1){	//表示添加信息成功
	   									$.messager.show({
	   										title : '成功提示',
	   										msg : '字典数据信息' + flag + '成功...',
	   										timeout : 2000,
	   										showType : 'slide'
	   									});
	   									datagrid.datagrid("reload");
	   								}else{
	   									$.messager.show({
	   										title : '失败提示',
	   										msg : '字典数据信息' + flag + '失败...',
	   										timeout : 2000,
	   										showType : 'slide'
	   									});
	   								}
	   							});
	    					}
	    				}
	    			}],
	                onResize:function(){  
	                    $('#dg').datagrid('fixDetailRowHeight',index);  
	                },
	                onLoadSuccess:function(){  
	                    setTimeout(function(){  
	                        $('#dg').datagrid('fixDetailRowHeight',index);  
	                    },0);  
	                }
	            });  
	            $('#dg').datagrid('fixDetailRowHeight',index);  
	        }	        
		});
	}); 
		
				
	</script>