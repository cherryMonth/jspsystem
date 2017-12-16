<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge"><!--ie使用edge渲染模式-->
<meta content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=no" id="viewport" name="viewport">
<meta name="renderer" content="webkit"><!--360渲染模式-->
<meta name="format-detection" content="telephone=notelphone=no, email=no" />
<meta name="description" content="" />
<meta name="keywords" content="" />
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />
<meta name="apple-touch-fullscreen" content="yes"><!-- 是否启用 WebApp 全屏模式，删除苹果默认的工具栏和菜单栏 -->
<meta name="apple-mobile-web-app-status-bar-style" content="black"><!-- 设置苹果工具栏颜色:默认值为 default，可以定为 black和 black-translucent-->
<meta http-equiv="Cache-Control" content="no-siteapp" /><!-- 不让百度转码 -->
<meta name="HandheldFriendly" content="true"><!-- 针对手持设备优化，主要是针对一些老的不识别viewport的浏览器，比如黑莓 -->
<meta name="MobileOptimized" content="320"><!-- 微软的老式浏览器 -->
<meta name="screen-orientation" content="portrait"><!-- uc强制竖屏 -->
<meta name="x5-orientation" content="portrait"><!-- QQ强制竖屏 -->
<meta name="browsermode" content="application"><!-- UC应用模式 -->
<meta name="x5-page-mode" content="app"><!-- QQ应用模式 -->
<meta name="msapplication-tap-highlight" content="no"><!-- windows phone 点击无高光 -->
<link rel="stylesheet" href="/system/bootstrap/css/index.css" />
	<style>
	a{
color:#555;
}
	</style>
<title>学生登录首页</title>
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
	<font color="#555">
		<ul class="nav navbar-nav"style="margin-top:15px;">
		<a href="student_index.jsp" style="margin-right:30px;margin-left:17px;">首页</a>
			<a href="/system/displaystucourse" style="margin-right:30px;">查询课程表</a>
					<a href="/system/displaystucredit" style="margin-right:30px;">查看成绩单</a>
					<a href="/system/exit" style="margin-right:30px;">退出登录</a>
				</ul>
		</font>
	</div>
	</div>
</nav>
<div class="container" style="text-align:center">
<div class="js-silder">
   <div class="silder-scroll">
		<div class="silder-main">
			<div class="silder-main-img">
				<img src="/system/static/2-1.jpg" alt="">
			</div>
			<div class="silder-main-img">
				<img src="/system/static/3-1.jpg" alt="">
			</div>
			<div class="silder-main-img">
				<img src="/system/static/1-1.jpg" alt="">
			</div>
		</div>
	</div>
</div>
</div>

<script src="/system/bootstrap/js/jquery-1.11.3.min.js" type="text/javascript"></script>
<script src="/system/bootstrap/js/wySilder.min.js" type="text/javascript"></script>
<script>
	$(function (){
		$(".js-silder").silder({
			auto: true,//自动播放，传入任何可以转化为true的值都会自动轮播
			speed: 20,//轮播图运动速度
			sideCtrl: true,//是否需要侧边控制按钮
			bottomCtrl: true,//是否需要底部控制按钮
			defaultView: 0,//默认显示的索引
			interval: 5000,//自动轮播的时间，以毫秒为单位，默认3000毫秒
			activeClass: "active",//小的控制按钮激活的样式，不包括作用两边，默认active
		});
	});
</script>
</body>
</html>