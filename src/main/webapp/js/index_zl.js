//自定义js
$(document).ready(function () {

	/*初始化目录菜单  */
	var indexurl = "../folder/index";
	$.ajax({
		  url: indexurl,
		  type: "GET",
		  dataType: "json",
		  success:function(data){
		  	//解析
		  	for (var i = 0; i < data.length; i++) {
		  		$("#folderlist").append(' <li class="dropdown"><a aria-expanded="false" role="button" href="#" class="dropdown-toggle" data-toggle="dropdown">'+data[i].name+'<span class="caret"></span></a><ul id="folder'+i+'" role="menu" class="dropdown-menu"> </ul></li>');
		  		var subdata = data[i].subsetlist;
		  		for (var j = 0; j < subdata.length; j++) {
		  			$("#folder"+i).append('<li><a href="../'+subdata[j].path+'"  id="'+i+'">'+subdata[j].name+'</a></li>');
				}
			}
		  }
		});


	//  进入此页面就判断是否登陆
	//拿到cookie 对应的值
	var gsjcookieval  = $.cookie('gsjcookie');
	if(gsjcookieval !=null){
		//存在cookie,就去请求后台
		logined(gsjcookieval);
	}
	
	//获取登陆信息
	function logined(gsjcookie_val){
    	var cookieurl = "../user/logininfo/"+gsjcookie_val;
    	$.ajax({
         		  url: cookieurl,
         		  type: "GET",
     			  dataType: "json",
     			  success:function(data){
     				 //解析data
     				 $("#nologin").css({ display:"none"});
     				 $("#infologin").css({ display:""});
     				 $("#infologin").append(' <i class="fa fa-user"></i> '+data.username+'');
     				//设置userid
     				$("#userid").val(data.userid);
     				$("#username").val(data.username);
     				
     			  }
     			});
		}

	
});


