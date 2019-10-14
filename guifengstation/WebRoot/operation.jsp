<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
     <title>肇事集团管理界面</title>
	<link rel="stylesheet" href="fxdcss/style.css" type="text/css" media="all" />

    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="jquery-1.8.3.js"></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	  <link rel="stylesheet" href="cssClock/style.css">
    <script type="text/javascript">
    
       function searchWord(obj){
	         //1键盘抬起时获得输入框的内容
        // alert(obj.value);
        var word = $(obj).val();
        //2根据输入框的内容去数据库中模糊查询---List<Product>
        var content = "";
        $.ajax({
            url:"${pageContext.request.contextPath}/searchServlet",
            type:"POST",
            contentType: "application/x-www-form-urlencoded; charset=utf-8",
            data:{"word":word},
            success:function (data) {
                //3将返回的商品名称显示在showDiv中
                if (data.length>0){
                    for (var i = 0;i<data.length;i++){
                        content+="<div style='color:black;padding: 5px;cursor: pointer' onmouseover='overChangeColor(this)' onmouseout='outChangeColor(this)' onclick='setContent(this)'>"+data[i]+"</div>";
                    }
                    $("#showDiv").html(content);
                    $("#showDiv").css("display","block");
                }
            },
            dataType:"json",
            }

        );

	         
	           
	       }
	       
	       //鼠标在小div上变色
	 function overChangeColor(obj){
		$(obj).css("background","#e8e7ed");
	}

    function outChangeColor(obj){
		$(obj).css("background","#fff");
	}
    
      function setContent(obj){
      var txt=$(obj).text();
       $("#txt").val(txt);
       $("#showDiv").css("display","none");
      
      }
    
    
    </script>
    
    <style type="text/css">
 
  #showDiv{

 width: 180px;
right:-17px;
top:20px;
}
  
  
   *{

-webkit-touch-callout: none; /* prevent callout to copy image, etc when tap to hold */
-webkit-text-size-adjust: none; /* prevent webkit from resizing text to fit */
-webkit-tap-highlight-color: rgba(210,210,210,0.35); /* make transparent link selection, adjust last value opacity 0 to 1.0 */
-webkit-user-select: none; /* prevent copy paste, to allow, change 'none' to 'text' */
}
body{font-family:"微软雅黑";font-size:12px;}

.ylcon{width:100%;min-width:320px;}
.tit{height:26px;line-height:26px;padding:0px 15px;position:relative;font-size:15px;color:#aaa;border-bottom:1px solid rgba(0, 0, 0, 0.15);}
 
.story{border-bottom:1px dashed #cecece;padding:0 15px 3px;position:relative;}
.story_t{font-size:1.2em;color:rgba(0,0,0,1);padding-top:5px;padding-bottom:2px;}
.story_m{color:rgba(110,110,110,1);line-height:21px;word-break:break-all;word-wrap:break-word;overflow:hidden;font-size:1.2em;padding:2px 0;}
.story_time{color:rgba(154,154,154,1);padding:2px 0;}
.story_hf{background:rgb(245,245,245);font-size:1.2em;border:1px solid rgba(204,204,204,0.2);border-radius:2px;color:rgba(110,110,110,1);padding:4px;margin-bottom:5px;}
.opbtn{position:absolute;top: 0;right: 0;}
	</style>

</head>
   
<body>
<!-- Header -->
<div id="header">
	<div class="shell">
		<!-- Logo + Top Nav -->
		<div id="top">
			<h1>管理员模式</h1>
			<div id="top-navigation">
				欢迎管理员 <strong>${loginname}</strong>
				<span>|</span>
				<a href="https://baidu.com">帮助</a>
				<span>|</span>
				<a href="AdminLogin.jsp">退出</a>
			</div>
		</div>
		<!-- End Logo + Top Nav -->
		
		<!-- Main Nav -->
	
		<!-- End Main Nav -->
	</div>
</div>
<!-- End Header -->

<!-- Container -->
<div id="container">
	<div class="shell">
		
		<br />
		<!-- Main -->
		<div id="main">
			<div class="cl">&nbsp;</div>
			
			<!-- Content -->
			<div id="content">
				
				<!-- Box -->
				<div class="box">
					<!-- Box Head -->
					<div class="box-head">
						<h2 class="left">公告资讯</h2>
						<div class="right">
						
							<form class="navbar-form navbar-right" role="search" action="lookupServlet" method="post">
					<div class="form-group" style="position: relative;margin-right:60px;width: 170px;">
						<input type="text" id="txt" onkeyup="searchWord(this)" class="form-control" placeholder="Search" name="lookup" autocomplete="off">
						<div id="showDiv" class="jz" style="position: absolute; background-color: white; border: 1px solid #ccc; z-index: 1000; display: none;">
						</div>
						<button type="submit"  class="button">查询</button>
						
					</div>
				</form>
						</div>
					</div>
					<!-- End Box Head -->	

					<!-- Table -->
					<div class="table">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<th>编号</th>
								<th>标题</th>
								<th>日期</th>
								<th>作者</th>
								<th width="110" class="ac">操作</th>
							</tr>
							
							
							
							<c:forEach var="n" items="${pageBean.list}">
				<tr>
	             <td>${n.nid}</td>
				 <td>${n.title}</td>
					 <td>${n.time}</td>
					 <td>${n.author}</td>
					<td>&nbsp&nbsp&nbsp&nbsp&nbsp<a href="deleteServlet?id=${n.nid}" class="ico del">删除</a></td>
					
				</tr>
 
			</c:forEach>
						</table>
						
						
						<!-- Pagging -->
						<div class="pagging">
							<div class="left">页码</div>
							<div class="right">
								  
                     <c:forEach var="page" begin="1" end="${pageBean.totalPage}" >
	                <a href="PageServlet?pageNow=${page}">${page}</a>
	                        </c:forEach>
	  
								
							</div>
						</div>
						<!-- End Pagging -->
						
					</div>
					<!-- Table -->
					
				</div>
				<!-- End Box -->
				
				<!-- Box -->
				<div class="box">
					<!-- Box Head -->
					<div class="box-head">
						<h2>发布公告资讯</h2>
					</div>
					
					
					<!-- 新闻公告发布 -->
					
					<form action="managementConsulting" method="post" enctype="multipart/form-data">
						
						<!-- Form -->
						<div class="form">
								<p>
									<span class="req">不超过30个字</span>
									<label>文章标题</label>
									<input type="text" class="field size1"  name="title"/>
									<br>
								</p>
								<p>
								<label>作者</label>
								<input type="text" class="field size1"  name="author"/>
								</p>
								<br>
								<br>
								<br>
								<p>
								 <h3>相关图片上传</h3>
								</p>
								<p>
								<input type="file" name="img" />
								</p>
								<p>
								
								<h2>文章内容请符合富强、民主、文明、和谐、自由、平等、公正、法治、爱国、敬业、诚信、友善的正确价值观</h2>
								</p>	
							<br>
							<br>
							<br>
								
								<p>
			
									<span class="req">万字以内</span>
									<label>内容</label>
									<textarea class="field size1" rows="10" cols="30" name="content"></textarea>
								</p>	
							
						</div>
						
						
						
						<div class="buttons">
							<input type="reset" class="button" value="重置" />
							<input type="submit" class="button" value="提交" />
						</div>
						<!-- End Form Buttons -->
					</form>
				</div>
				<!-- End Box -->

			</div>
			<!-- End Content -->
			
			<!-- Sidebar -->
			<div id="sidebar">
				
				
				<div class="box">
					
					
					<div class="box-head">
						<h2>所有留言</h2>
					</div>
				
					
					<div class="box-content">
					  
					  <div id="messDivId">
<div class="story">
<div class="opbtn"><a href="emptymMessageServlet">清空留言</a></div>
   
      <c:forEach var="c" items="${viewMessage}" >
	  <p class="story_t">${c.name}</p>
     <p class="story_time">${c.boxmail}</p>
       <p class="story_m">${c.content}</p>
     
	                        </c:forEach>

         </div>
            </div>
					   
					   
					   
					</div>
					
					 <div class="clock" style="margin-top:750px">
        <div class="hourHand"></div>
        <div class="minuteHand"></div>
        <div class="secondHand"></div>
        <div class="center"></div>
        <div class="time"></div>
        <ul>
            <li><span>1</span></li>
            <li><span>2</span></li>
            <li><span>3</span></li>
            <li><span>4</span></li>
            <li><span>5</span></li>
            <li><span>6</span></li>
            <li><span>7</span></li>
            <li><span>8</span></li>
            <li><span>9</span></li>
            <li><span>10</span></li>
            <li><span>11</span></li>
            <li><span>12</span></li>
        </ul>
    </div>

    <audio src="5[kb]sidestick.aif.mp3" class="audio"   ></audio>
  
  

  <script type="text/javascript" src="jsclock/clock.js" ></script>

<div style="text-align:center;clear:both">
<script src="/gg_bd_ad_720x90.js" type="text/javascript"></script>
<script src="/follow.js" type="text/javascript"></script>
</div>
					
				</div>
			
			</div>
		
			
			<div class="cl">&nbsp;</div>			
		</div>
		<!-- Main -->
	</div>
</div>
<!-- End Container -->

<!-- Footer -->
<div id="footer">
	<div class="shell">
		<span class="left">&copy; 2019 - 肇事集团</span>
		<span class="right">
			回味 <a href="Main.jsp" target="_blank" title="The Sweetest CSS Templates WorldWide">肇事集团首页</a>
		</span>
	</div>
</div>
<!-- End Footer -->
	
</body>
</html>