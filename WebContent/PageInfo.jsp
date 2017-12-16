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
<title>显示查询结果页面</title>
</head>
<body>
<%
String type=(String)session.getAttribute("status");
if(type.equals("admin")){
%>
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
					<li  class="active"><a href="queryinfo.jsp">查询信息</a></li>
					<li><a href="updateinfo.jsp">编辑信息</a></li>
					<li><a href="/system/exit">退出登录</a></li>
				</ul>
	</div>
	</div>
</nav>
<%} 
else if(type.equals("teacher")){
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
					<li><a href="querystudentcredit.jsp" >查看对应课程学生成绩单</a></li>
					<li><a href="/system/exit" >退出登录</a></li>
				</ul>
	</div>
	</div>
</nav>
<%} 
else if(type.equals("student")){
%>
<nav class="navbar navbar-default" role="navigation">
	<div class="container-fluid">
	<div class="navbar-header">
		<a class="navbar-brand" href="#">学生信息管理系统</a>
	</div>
	<div>
	<font color="#555">
		<ul class="nav navbar-nav">
		<li><a href="student_index.jsp" style="margin-right:30px;margin-left:17px;">首页</a></li>
			<li><a href="/system/displaystucourse" style="margin-right:30px;">查询课程表</a></li>
					<li><a href="/system/displaystucredit" style="margin-right:30px;">查看成绩单</a></li>
					<li><a href="/system/exit" style="margin-right:30px;">退出登录</a></li>
				</ul>
		</font>
	</div>
	</div>
</nav>
<%} %>
<div class="container">
<div style="text-align:center">
<jsp:setProperty name="pageBean" property="pageSize" param="pageSize" />
<jsp:setProperty name="pageBean" property="currentPage" param="currentPage" />
<table border=1 align="center"  class="table table-bordered">
<%
	String [][] table = pageBean.getTableRecord();
	if(table==null){
		out.print("当前查询没有记录!");
		return;
	}
	String [] columnName=pageBean.getColumnName();
	if(columnName!=null){
		out.print("<thead>");
		out.print("<tr>");
		for(int i=0;i<columnName.length;i++){
			out.print("<th>"+columnName[i]+"</th>");
		}
		out.print("</tr>");
		out.print("</thead>");
	}
	int totalRecord = table.length;
	
	out.println("全部记录数"+totalRecord);
	
	int pageSize = pageBean.getPageSize();
	int totalPages = pageBean.getTotalPages();
	
	if(totalRecord%pageSize==0)
		totalPages = totalRecord/pageSize;
	else
		totalPages = totalRecord/pageSize+1;
	
	pageBean.setPageSize(pageSize);
	pageBean.settotalPages(totalPages);
	out.print("<br>");
	out.print("<br>");
	if(totalPages>=1){
		if(pageBean.getCurrentPage()<1)
			pageBean.setCurrentPage(pageBean.getTotalPages());
		if(pageBean.getCurrentPage()>pageBean.getTotalPages())
			pageBean.setCurrentPage(1);
		
		int index=(pageBean.getCurrentPage()-1)*pageSize;
		int start=index;
		out.print("<tbody>");
		for(int i=index;i<pageSize+index;i++){
			if(i==totalRecord)
				break;
			out.print("<tr>");
			for(int j=0;j<columnName.length;j++){
				out.print("<td>"+table[i][j]+"</td>");
			}
			out.print("</tr>");
		}
		out.print("</tbody>");
	}
%>
</table>
</div>
<div style="text-align:center">
<br>每页最多显示<jsp:getProperty name="pageBean" property="pageSize"/>条信息
<br>当前显示第<font color="#4f9fcf"><jsp:getProperty name="pageBean" property="currentPage"/>
页,共有<jsp:getProperty name="pageBean" property="totalPages"/>
</font>页
<table align="center" style="margin-top:50px"  class="table table-bordered">
<tr><td><form action="" method="post" >
<input type=hidden name="currentPage" value="<%=pageBean.getCurrentPage()-1 %>">
<button type="submit" class="btn btn-default">上一页</button>
</form></td>
<td><form action="" method="post" style="text-align:center">
<input type=hidden name="currentPage" value="<%=pageBean.getCurrentPage()+1 %>">
<button type="submit" class="btn btn-default">下一页</button>
</form></td></tr>
<tr><td><form action="" method="post" >
每页显示<input type="text" name="pageSize" value=10 size=3>
条记录<button type="submit" class="btn btn-default">确定</button>
</form></td>
<td><form action="" method="post" >
输入页码<input type="text" name="currentPage" size=3>
<button type="submit" class="btn btn-default">提交</button>
</form></td></tr>
</table>
</div>
</div>
<div style="float:right;" id="github_iframe"></div>

<script type="text/javascript" color=black opacity='0.7' zIndex="-2" count="200" src="/system/bootstrap/js/canvas-nest.js"></script>
<script type="text/javascript">
    function async_load() {
        //async load github
        var i = document.createElement("iframe");
        i.scrolling = "no";
        i.frameborder = "0";
        i.border = "0";
        i.setAttribute("frameborder", "0", 0);
        i.width = "100px";
        i.height = "20px";
        document.getElementById("github_iframe").appendChild(i);
    }

    if (window.addEventListener) {window.addEventListener("load", async_load, false);}
    else if (window.attachEvent) {window.attachEvent("onload", async_load);}
    else {window.onload = async_load;}
</script>
</body>
</html>