<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<table id="roleData"></table> 

<div id="roleGrid_bar" style="padding:5px;height:auto">
				<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="addRole()">添加</a>
				<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true" onclick="updateRole()">修改</a>
</div>
<div id="role_panl">
	<div style="padding:10px 60px 10px 60px">
			<label>角色名:</label>
	    	<input id="rname"  class="easyui-textbox" type="text" name="rname" data-options="required:true"></input>
	    	
	</div>
	<ul id="functionTree"></ul>  
	<div style="text-align:center;padding:5px">
	    	<a href="javascript:void(0)" id="addRoleButton" onclick="submitRoleForm()">添加</a>
	  </div>
</div>  


<script type="text/javascript">
$('#role_panl').dialog({ 
	title:"添加",
    width:450,  
    height:400,  
    modal:true,
    closed:true,
    top:100,
    left:700
   
});



var roleData=undefined;
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
	toolbar:"#roleGrid_bar",
	columns:[[
	  		{field:'rid',sortable:true,align:'center',checkbox:true},
	  		{field:'rname',title:'角色名',width:200,align:'center'},
	  		{field:'addtime',title:'注册时间',width:180,align:'center'},
	  		{field:'updatetime',title:'上次修改时间',width:180,align:'center'}]]
	
}); 

function addRole(){
	$('#role_panl').dialog('open');
	$('#rname').textbox({
		value:""
	});
	$('#functionTree').tree({
		cascadeCheck:true,
		checkbox:true,
	    url:'function/functionTree.do'  
	});
	 $('#addRoleButton').linkbutton({plain:true,iconCls:'icon-add'});
	 $('#cleatRoleButton').linkbutton({plain:true,iconCls:'icon-clear'});
}
function submitRoleForm(){
	var rname= $('#rname').val();
	
	var nodes = $('#functionTree').tree('getChecked','indeterminate');  
    var nodes1 = $('#functionTree').tree('getChecked');  
    var s = '';  
    for(var i=0; i<nodes.length; i++){  
        if (s != ''){ s += ','};  
        s += nodes[i].id;  
    }  
    for(var i=0; i<nodes1.length; i++){  
        if (s != ''){ s += ','};  
        s += nodes1[i].id;  
    }  
		
	if(rname.length<2||rname.length>8){
		$.messager.alert('提示','请输入角色名长度为2到8!','info');
	}else if(s==""){
		$.messager.alert('提示','请选择角色相应的权限！','info');
	}else{
		$.post("list/addRole.do",{fids:s,rname:rname},function(data){
			if(data){
				$.messager.show({
					title:'成功提示',
					msg:'角色添加成功！',
					timeout:5000,
					showType:'slide'
				});
				 $('#functionTree').tree('reload');
				 $('#roleData').datagrid('reload');
			}else{
				$.messager.alert('错误','添加失败，请联系开发人员!','error');
			}
		},"json")
	}
}
function updateRole(){
	
}
</script>
	