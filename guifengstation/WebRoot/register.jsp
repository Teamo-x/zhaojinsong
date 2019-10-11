<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>注册界面</title>
    
<script type="text/javascript" src="jquery-1.8.3.js"></script>
<script src="https://static.runoob.com/assets/jquery-validation-1.14.0/lib/jquery.js"></script>
<script src="https://static.runoob.com/assets/jquery-validation-1.14.0/dist/jquery.validate.min.js"></script>
<script src="https://static.runoob.com/assets/jquery-validation-1.14.0/dist/localization/messages_zh.js"></script>
<script type="text/javascript">
//自定义校验规则
	$.validator.addMethod(
		//规则的名称
		"checkUsername", 
		//校验的函数
		function(value,element,params){
			
			//定义一个标志
			var flag = false;
			
			//value:输入的内容
			//element:被校验的元素对象
			//params：规则对应的参数值
			//目的：对输入的username进行ajax校验
			$.ajax({
				"async":false,
				"url":"checkUsername",
				"data":{"username":value},
				"type":"POST",
				"dataType":"json",
				"success":function(data){
				//alert(flag);
					flag = data.isExist;
				}
			});
			
			
			//返回false代表该校验器不通过
			return !flag;
		}
		
	);


	$(function(){
		$("#myform").validate({
			rules:{
				"username":{
					"required":true,
					"checkUsername":true
				},
				"loginpass1":{
					"required":true,
					"rangelength":[6,12]
				},
				"loginpass2":{
					"required":true,
					"rangelength":[6,12],
					"equalTo":"#loginpass1"
				},
				"phone":{
					"required":true,
					
				}
				
			},
			messages:{
				"username":{
					"required":"用户名不可空",
					"checkUsername":"用户名已存在"
				},
				"loginpass1":{
					"required":"密码不能为空",
					"rangelength":"密码长度6-12位"
				},
				"loginpass2":{
					"required":"密码不能为空",
					"rangelength":"密码长度6-12位",
					"equalTo":"两次密码不一致"
				},
				"phone":{
					"required":"电话不能为空",
					
				}
			}
		});
	});


</script>

    <style>
        .p{
            color:red;
            margin-left:20px;
            display:inline-block;
        }
        .c{
            color:red;
            margin-left:4px;
            display:inline-block;
        }
        .l{
            font-size:18px;
        }
        .d{
            height:35px;
            width:300px;
            display:inline;
        }
        .i{
            height:30px;
            width:300px;
        }


    </style>

</head>
<body background="img/preview.jpg">

    <div style="height:80px;"></div>
    
    <form  id="myform" method="post" action="registerServlet"> 

        <div style="width:500px;float:left;margin:0 20px;">
     <div style="font-size:28px;">注册新管理员</div>
            <br/>
            <span class="p">*</span>
            <label for="username" class="l">用户名:</label>
            <div style="height:35px;width:300px;position:relative;display:inline;">
            
                <input name="username" id="username" type="text" style="height:30px;width:300px;padding-right:50px;">
                
                <span style="position:absolute;right:18px;top:2px;background-image:url(user.ico);height:16px;width:16px;display:inline-block;" ></span>
            </div>
            <br/><br/>
            <span class="p">*</span>
            <label for="phonenumber" class="l">手机号:</label>
            <div  class="d">
            
                <input name="phone" id="phone" type="text" class="i">
                
            </div>
            <br/><br/>
            <span class="c">*</span>
            <label for="login_password" class="l">登录密码:</label>
            <div  class="d">
            
                <input name="loginpass1" id="loginpass1" type="text" class="i">
            </div>
            
            <br/><br/>
            <span class="c">*</span>
            <label for="confirm_password" class="l">确认密码:</label>
            <div  class="d">
            
                <input  name="loginpass2" id="loginpass2" type="text" class="i">
                
            </div>
            <br/><br/>
            
            <input type="checkbox" name="agree" style="margin-left:100px;display:inline-block;" value="1"/>
            <span style="font-size:10px;">我已阅读并同意<a href="employeeBehaviorSpecification.jsp">《公司员工规范》</a></span>
            <br/><br/>
         
            <input type="submit" value="同意以上协议并注册" style="margin-left:100px;height:30px;width:300px;background-color:red;display:inline-block;"/>
            
        </div>

    </form>
	<div style="position:fixed; right:10px; bottom:10px;">
    <audio autoplay="autoplay" controls="controls"loop="loop" preload="auto"
            	src="mp3/HOP.mp3">
            		</audio>
            	</div>
</body>
</html>
