<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
     <title>肇事集团管理界面</title>
	<link rel="stylesheet" href="css/style.css" type="text/css" media="all" />

    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->


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
				<a href="#">帮助</a>
				<span>|</span>
				<a href="#">退出</a>
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
						<h2 class="left">最新资讯</h2>
						<div class="right">
							<label>搜索资讯相关标题</label>
							<input type="text" class="field small-field" />
							<input type="submit" class="button" value="search" />
						</div>
					</div>
					<!-- End Box Head -->	

					<!-- Table -->
					<div class="table">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<th></th>
								<th>标题</th>
								<th>日期</th>
								<th>作者</th>
								<th width="110" class="ac">操作</th>
							</tr>
							
							<tr class="odd">
								<td><input type="checkbox" class="checkbox" /></td>
								<td><h3><a href="#">mdzz</a></h3></td>
								<td>12.05.09</td>
								<td><a href="#">Administrator</a></td>
								<td><a href="#" class="ico del">删除</a><a href="#" class="ico edit">编辑</a></td>
							</tr>
						</table>
						
						
						<!-- Pagging -->
						<div class="pagging">
							<div class="left">页码</div>
							<div class="right">
								<a href="#">上一页</a>
								<a href="#">1</a>
								<a href="#">2</a>
								<a href="#">3</a>
								<a href="#">4</a>
								
								<span>...</span>
								<a href="#">下一页</a>
								
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
						<h2>添加新资讯</h2>
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
				
				<!-- Box -->
				<div class="box">
					
					<!-- Box Head -->
					<div class="box-head">
						<h2>查看简历</h2>
					</div>
					<!-- End Box Head-->
					
					<div class="box-content">
					
					</div>
				</div>
				<!-- End Box -->
			</div>
			<!-- End Sidebar -->
			
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