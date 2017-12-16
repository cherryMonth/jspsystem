<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="pageBean" class="system.Tableinfo" scope="session"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>添加信息</title>
<title>修改信息界面</title>
</head>
<body>
<nav class="navbar navbar-default" role="navigation">
	<div class="container-fluid">
	<div class="navbar-header">
		<a class="navbar-brand" href="#">学生信息管理系统</a>
	</div>
	<div>
		<ul class="nav navbar-nav">
		<li><a href="admin_index.jsp">首页</a></li>
			<li><a href="addInfo.jsp">添加信息</a></li>
			
					<li><a href="deleteinfo.jsp">删除信息</a></li>
					<li><a href="queryinfo.jsp">查询信息</a></li>
					<li class="active"><a href="updateinfo.jsp">编辑信息</a></li>
					<li><a href="/system/exit">退出登录</a></li>
				</ul>
	</div>
	</div>
</nav>
<div class="container" style="text-align:center">
<h2>请根据需求修改下列选项</h2>
	<form action="/system/check?table=<%= (String)session.getAttribute("table")%>&old=<%= (String)session.getAttribute("old")%>" method="post">
	<% String [] columnName=pageBean.getColumnName();
	String [][] table= pageBean.getTableRecord();
	if(columnName!=null){
		for(int i=0;i<columnName.length;i++){
	out.print("<div class=\"form-group\">");
	out.print("<label for=\"inputEmail3\" class=\"col-sm-2 control-label\">"+columnName[i]+"</label>");
	out.print("<div class=\"col-sm-10\">");
	out.print("<input type=\"text\" name="+columnName[i]+" class=\"form-control\" value="+table[0][i]+">");
	out.print("</div>");
	out.print("</div>");
	out.print("<br>");
	out.print("<br>");
	out.print("<br>");
		}
	}
	%>
	<button type="submit" class="btn btn-default">提交</button>
	</form>
</div>
</body>
</html>