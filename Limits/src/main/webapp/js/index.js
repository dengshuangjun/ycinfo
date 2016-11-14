//点击提交按钮时，从服务端获取数据，然后在客户端显示
function getListInfo(id){
	var params=id;
	var str="";
    $.ajax({
        url: "Favorite_getListInfo.action",
        // 数据发送方式
        type: "post",
        // 接受数据格式
        dataType : "json",
        // 要传递的数据
        data : {'result':params},
        // 回调函数，接受服务器端返回给客户端的值，即result值
        success : function(data){
        	for(var i =0; i < data.length; i++){
         	    str+="<div style='padding:6px 10px; width:588px; float: left; height:70px;'>";
				str+="<div><a href="+data[i].f_url+" style='color:blue;font-size:18px;' target='_blank'>"+data[i].f_label+"</a></div>";
				str+="<div style='color:black;font-size:16px;'>"+data[i].f_desc+"</div>";
				str+="<div style='color:green;font-size:14px;'>"+data[i].f_url+"</div>";
				str+="</div>";
        	}
        	console.info(str);
        	$("#content_links").html(str);
        } 
    });
}

//点击提交按钮时，从服务端获取数据，然后在客户端显示
function yuntu(id){
	var params=id;
	var str="";
    $.ajax({
        url: "Favorite_yuntu.action",
        // 数据发送方式
        type: "post",
        // 接受数据格式
        dataType : "json",
        // 要传递的数据
        data : {'result':params},
        // 回调函数，接受服务器端返回给客户端的值，即result值
        success : function(data){
        	for(var i = 0; i < data.length; i++){
        		str+="<font size="+data[i].t_count*3+">"+data[i].t_name+"</font>&nbsp;&nbsp;&nbsp";
        	}
        	$("#content_links").html(str);
        } 
    });
}
