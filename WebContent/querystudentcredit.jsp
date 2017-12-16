<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<%
String id = (String)session.getAttribute("login_id");
if(id==null || id.length()==0)
	{
	response.sendRedirect("notlogin.jsp");
	return;
	}
%>
<nav class="navbar navbar-default" role="navigation">
	<div class="container-fluid">
	<div class="navbar-header">
		<a class="navbar-brand" href="#">学生信息管理系统</a>
	</div>
	<div>
		<ul class="nav navbar-nav"">
		<li><a href="teacher_index.jsp" >首页</a></li>
			<li><a href="/system/displaycourse" >查询课程表</a></li>
					<li><a href="createreport.jsp" >生成成绩单</a></li>
					<li class="active"><a href="querystudentcredit.jsp" >查看对应课程学生成绩单</a></li>
					<li><a href="/system/exit" >退出登录</a></li>
				</ul>
	</div>
	</div>
</nav>
<div class="container" style="text-align:center">
<form action="/system/querycredit" method=post>
<input type="text" class="form-control" style="width:300px;margin-left:37%;" name="type" placeholder="请输入课程的主键">
<br>
<br>
<button type="submit" class="btn btn-default" >提交</button>
</form>
</div>
</body>
</html>