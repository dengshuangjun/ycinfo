<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML>
<html>
 	<head>
 		<base href="/Ssm2/">
	   	<meta charset="utf-8">
	   	<title>用户信息管理系统</title>
	   	<link rel="stylesheet" type="text/css" href="easyui/css/easyui.css">
		<link rel="stylesheet" type="text/css" href="easyui/css/icon.css">
		<link rel="stylesheet" type="text/css" href="easyui/css/demo.css">
		
		<script type="text/javascript" src="js/jquery-1.11.3.js"></script>
		<script type="text/javascript" src="easyui/js/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="easyui/js/easyui-lang-zh_CN.js"></script>
		<script type="text/javascript" src="js/ajaxfileupload.js"></script>
 	</head>
 
	<body>
		<!--  datagrid表格-->
		<table id="profile_data" >
		
		</table>
		
		<!--  弹出框html-->
		<div id="deitdlg" class="easyui-dialog" style="width:300px;height:370px;padding:10px 20px"  
		        closed="true" buttons="#dlg-buttons">  
		    <form id="fm" action="front/save" method="POST" enctype="multipart/form-data" >  
		        <div class="fitem">  
		            <label>用户编号:</label>  
		            <input id="pid" name="id" class="easyui-textbox" required="true"/>
		        </div> 
		        <div class="fitem">
		            <label>用户名称:</label>  
		            <input id="pname" name="name" class="easyui-textbox" required="true"/>
		        </div> 
		        <div class="fitem">
		            <label>用户生日:</label>  
		            <input id="pbirthday" name="birthday" class="easyui-datebox myinput" required="true"/>
		        </div> 
		        <div class="fitem">
		            <label>用户性别:</label>  
		            <input id="pgender" name="gender" class="easyui-textbox" required="true"/>
		        </div> 
		        <div class="fitem">
		            <label>用户职位:</label>  
		            <input id="pcareer" name="career" class="easyui-textbox" required="true"/>
		        </div> 
		        <div class="fitem">
		            <label>用户地址:</label>  
		            <input id="paddress" name="address" class="easyui-textbox" required="true"/>
		        </div> 
		        <div class="fitem">
		            <label>手机号码:</label>  
		            <input id="pmobile" name="mobile" class="easyui-textbox" required="true"/>  
		        </div>
		        <div class="fitem">
		            <label>用户图像:</label>  
		            <input id="imageFile" type="file" name="imageFile" onchange="getPic(this)"/>   
		        </div>
		        <div colspan="2" id="pics"></div>  
		    </form>
		     <!--  按钮-->
			<div id="dlg-buttons">  
			    <a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="saveProfile()" style="width:90px">Save</a>  
			    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#deitdlg').dialog('close')" style="width:90px">Cancel</a>  
			</div>  
		</div>
		
		
		
		<!--  datagrid表格js-->
		<script type="text/javascript" charset="gbk">
			var obj;
			obj=$('#profile_data').datagrid({ 		
			    url:'front/getData',
			    fitColumns:true,
				striped:true,
				loadMsg:"数据加载中...",
				pagination:true,
				rownumbers:true,
				sortName:'id',
				sortOrder:'asc',
				remoteSort:false,
			    columns:[[  
			              
			        {field:'id',title:'编号',width:80,sortable:true,align:'center'},  
			        {field:'name',title:'用户名',width:80,align:'center'}  ,
			        {field:'birthday',title:'生日',width:80,align:'center'},
			        {field:'gender',title:'性别',width:80,align:'center'},
			        {field:'career',title:'职位',width:80,align:'center'},
			        {field:'address',title:'地址',width:80,align:'center'},
			        {field:'picPath',title:'图片',width:80,align:'center',
			        	formatter: function(value,row,index){
							if (value!=null&&value!=""){
								var str="";
								var pics=value.split(",");			
								str="<img src='../uploadpic/"+pics[0]+"' width='60px' height='40px'/>&nbsp;";
								return str;
							} else {
								var str="<img src='images/zanwu.jpg' width='40px' height='20px'/>&nbsp;";
								return str;
							}
						}},
			        {field:'mobile',title:'手机号码',width:80,align:'center'},
			        {field:'_operate',title:'操作',width:100,align:'center',
			        	  formatter:function(value,rowData,index){
			        		  return '<a class="editcls"  onclick="editUser('+index+')"></a>&nbsp;&nbsp;&nbsp;<a class="remove" onclick="removeUser('+rowData.id+')"></a>';
			        	  }
			          }
			    ]],
				onLoadSuccess:function(data){  //为格式化列添加样式，变成有图标的按钮
		            $('.editcls').linkbutton({text:'修改',plain:true,iconCls:'icon-edit'});
		            $('.remove').linkbutton({text:'删除',plain:true,iconCls:'icon-remove'});
				}
			});
		</script>
		
		<!-- 弹出框js-->
		<script type="text/javascript">
			//打开修改
			function editUser(index){
				$('#profile_data').datagrid('selectRow', index);
				var row = $('#profile_data').datagrid('getSelected');
			    if (row){ 
			    	if (row.picPath!=null&&row.picPath!=""&&row.picPath!=undefined){
			    		var imgStr= "<img src='../uploadpic/"+row.picPath+"' style='width:110px'/>"
						document.getElementById("pics").innerHTML = imgStr;
					}else{
						var imgStr= "<img src='images/zanwu.jpg' style='width:110px'/>"
						document.getElementById("pics").innerHTML = imgStr;
					} 
			        $('#deitdlg').dialog('open').dialog('setTitle','修改学生信息');
			        $('#fm').form('load',row);
			    }  
			}
			//打开图片
			function getPic(objs){
				var pics=objs.files;
				var picPath=window.URL.createObjectURL(pics[0]);
				var imgStr= "<img src='"+picPath+"' style='width:110px'/>"
				document.getElementById("pics").innerHTML = imgStr;
			}
			//异步提交
			function saveProfile(){
				var id=$.trim($("#pid").val());
				var name=$.trim($("#pname").val());
				var birthday=$.trim($("#pbirthday").datebox('getValue'));
				var gender=$.trim($("#pgender").val());
				var career=$.trim($("#pcareer").val());
				var address=$.trim($("#paddress").val());
				var mobile=$.trim($("#pmobile").val());
				$.ajaxFileUpload({
					url:"front/updata",
					secureuri:false,
					fileElementId:"imageFile",
					dataType:"json",
					data:{id:id,name:name,birthday:birthday,gender:gender,career:career,address:address,mobile:mobile},
					success:function(data,status){
						if(data==1){//说明是成功的
							$.messager.show({title:'成功提示',msg:'信息修改成功',timeout:2000,showType:'slide'});
							$("#deitdlg").dialog("close");
							$("#profile_data").datagrid("reload");//页面刷新
						}else{
							$.messager.alert("失败提示","信息修改失败。。。","error");
						}
					},
					error:function(data,status,e){
						$.messager.alert("错误提示","信息修改失败。。。\n"+e,"error");
					}
				});
			}
			//删除
			function removeUser(id){  
				alert(id);
				$.post("front/remove",{id:id},function(data){
					if(data=1){
						$.messager.show({
							title:'成功提示',
							msg:'删除成功...',
							timeout:2000,
							showType:'slide'
						});
						$("#profile_data").datagrid("reload");//页面刷新
					}else{
						$.messager.alert('失败提示','删除失败...','error');
					}
				});  
			}
		</script>
	</body>
	
</html>