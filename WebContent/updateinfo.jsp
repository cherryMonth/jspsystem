<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>更新信息界面</title>
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
		<li><a href="admin_index.jsp">首页</a></li>
			<li><a href="addInfo.jsp">添加信息</a></li>
			
					<li><a href="deleteinfo.jsp">删除信息</a></li>
					<li><a href="queryinfo.jsp">查询信息</a></li>
					<li class="active"><a href="updateinfo.jsp">编辑信息</a></li>
					<li><a href="/system/exit">退出登录</a></li>
				</ul>
			</li>
		</ul>
	</div>
	</div>
</nav>
<div class="container">
<form action="/system/updateinfo" method="post">
<div style="text-align:center">
<input type="radio" name="type" value="Faculty" >更新学院信息
<input type="radio" name="type" value="Professional" >更新专业信息
<input type="radio" name="type" value="course" >更新课程信息
<input type="radio" name="type" value="teacher" >更新教师信息
<input type="radio" name="type" value="class" >更新班级信息
<input type="radio" name="type" value="student" >更新学生信息
</div>
<br>
<div class="col-sm-10">
      <input type="name" name="key" class="form-control" style="margin-top:50px;" placeholder="请输入需要删除对象的主键">
    </div>
<br>
<br>
      <button type="submit" class="btn btn-default" style="margin-top:50px;margin-left:40%;">提交</button>
</form>
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