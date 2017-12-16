<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>生成成绩单</title>
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
		<ul class="nav navbar-nav">
		<li><a href="teacher_index.jsp" >首页</a></li>
			<li><a href="/system/displaycourse" >查询课程表</a></li>
					<li class="active"><a href="createreport.jsp" >生成成绩单</a></li>
					<li><a href="querystudentcredit.jsp" >查看对应课程学生成绩单</a></li>
					<li><a href="/system/exit" >退出登录</a></li>
				</ul>
	</div>
	</div>
</nav>
<div class="container" style="text-align:center">
<form action="/system/getstuinfo">
<br>
<input name="key" class="form-control"  placeholder="请输入需要批改成绩的课程主键" style="width:300px;margin-left:37%;">
<br>
<br>
<input name="id" class="form-control" placeholder="请输入学生的学号" style="width:300px;margin-left:37%;">
<br>
<br>
<input name="credit" class="form-control" placeholder="请输入成绩" style="width:300px;margin-left:37%;">
<br>
<br>
<button type="submit" class="btn btn-default" >提交</button>
</form>
</div>
</body>
</html>
