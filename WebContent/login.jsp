<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="system.Test" %>
<%@ page import="java.sql.*" %>
<jsp:useBean id="user" class="system.Test" scope="request" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>用户登录页面</title>
</head>
<body>
<div style="margin-bottom:150px;">
<nav class="navbar navbar-default" role="navigation">
	<div class="container-fluid">
	<div class="navbar-header">
		<a class="navbar-brand" href="#">学生信息管理系统</a>
	</div>
	<div>
	</div>
	</div>
</nav>

</div>
<div class="container">
<form action="/system/login_test" Method=post>
<div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">登录账号</label>
    <div class="col-sm-10">
      <input type="name" name="name" class="form-control"  placeholder="login number">
    </div>
  </div>
  <br>
  <div class="form-group" style="margin-top:50px;">
    <label for="inputPassword3" class="col-sm-2 control-label">密码</label>
    <div class="col-sm-10">
      <input type="password" name="password" class="form-control"  placeholder="Password">
    </div>
  </div>
  <div class="form-group" style="text-align:center;margin-top:50px;">
    <div class="col-sm-offset-2 col-sm-10">
      <div class="checkbox">
        <label>
          <input type="checkbox"> Remember me
        </label>
      </div>
      <div>
      <label>
      <input type="radio" name="type" value="admin" checked="select">管理员登录
   </label>
   <label>
   <input type="radio" name="type" value="teacher">教师登录
   </label>
   <label>
   <input type="radio" name="type" value="student">学生登录
   </label>
   </div>
    </div>
  </div>
  <div class="form-group" style="text-align:center;margin-top:50px;">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default">Sign in</button>
    </div>
  </div>
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