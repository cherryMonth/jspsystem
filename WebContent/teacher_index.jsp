<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style type="text/css">
	a{
color:#555;
}

	html,body,div{
		margin: 0;
		padding: 0;			
	}

	.slider-outer{
		width: 560px;
		height: 300px;
		margin: 150px auto;
		background-color: #f60;
		position: relative;
	}
	.img-item{
		position: absolute;
		width: 112px;
		height: 100%;
		background-color: #f10;
		transition: all 1.5s;
		/*设置子元素在3D空间中呈现*/
		transform-style: preserve-3d;
	}
	/*让图片可以构成一个有四个面的长方体 start*/
	.img{
		width: 100%;
		height: 100%;
		position: absolute;
		background-size: cover;
	}
	.img:nth-child(1){
		background: url(/system/static/1.png) no-repeat;
		transform: rotateX(0deg) translateZ(150px);
	}
	.img:nth-child(2){
		background: url(/system/static/2.png) no-repeat;
		transform: rotateX(-90deg) translateZ(150px);
	}
	.img:nth-child(3){
		background: url(/system/static/3.png) no-repeat;
		transform: rotateX(-180deg) translateZ(150px);
	}
	.img:nth-child(4){
		background: url(/system/static/4.png) no-repeat;
		transform: rotateX(-270deg) translateZ(150px);
	}
	/*让图片可以构成一个有四个面的长方体 end*/
	.btns{
		position: absolute;
		top: 50%;
		width: 100%;
		height: 70px;
		margin-top: -35px;
	}
	.prev,
	.next{
		width: 70px;
		height: 70px;
		line-height: 70px;
		text-align: center;
		background-color: rgba(0,0,0,.3);
		color: #fff;
		font-size: 30px;
		cursor: pointer;
		position: absolute;
	}
	.prev{
		left: 0;
	}
	.next{
		right: 0;
	}
	</style>
<title>教师登录首页</title>
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
		<ul class="nav navbar-nav" style="margin-top:15px;">
		<a href="teacher_index.jsp" style="margin-right:30px;margin-left:17px;">首页</a>
			<a href="/system/displaycourse" style="margin-right:30px;">查询课程表</a>
					<a href="createreport.jsp" style="margin-right:30px;">生成成绩单</a>
					<a href="querystudentcredit.jsp" style="margin-right:30px;">查看对应课程学生成绩单</a>
					<a href="/system/exit" style="margin-right:30px;">退出登录</a>
				</ul>
		</font>
	</div>
	</div>
</nav>
<div class="slider-outer" id="j_silder_outer">
	<div class="img-item">
		<div class="img"></div>
		<div class="img"></div>
		<div class="img"></div>
		<div class="img"></div>
	</div>
	<div class="img-item">
		<div class="img"></div>
		<div class="img"></div>
		<div class="img"></div>
		<div class="img"></div>
	</div>
	<div class="img-item">
		<div class="img"></div>
		<div class="img"></div>
		<div class="img"></div>
		<div class="img"></div>
	</div>
	<div class="img-item">
		<div class="img"></div>
		<div class="img"></div>
		<div class="img"></div>
		<div class="img"></div>
	</div>
	<div class="img-item">
		<div class="img"></div>
		<div class="img"></div>
		<div class="img"></div>
		<div class="img"></div>
	</div>
	<div class="btns" data-num="0">
		<div class="prev"><</div>
		<div class="next">></div>
	</div>
</div>
<script src="/system/bootstrap/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
	$(function (){
		var num = 0;
		$("#j_silder_outer .img-item").each(function(index, el) {
			$(this).css({
				"left":$(this).width() * index + "px",
				/*让每个img-item延时一定时间执行动画*/
				"transitionDelay": index * 0.3 + "s"
			});
			$(this).find(".img").css({
				"backgroundPosition": -$(this).width() * index + "px"
			});;
		});

		$(".prev").on("click",function (){
			$("#j_silder_outer .img-item").css("transform", "rotateX(" + (++num * 90) + "deg)");
		});

		$(".next").on("click",function (){
			$("#j_silder_outer .img-item").css("transform", "rotateX(" + (--num * 90) + "deg)");
		});
		
		var timejg=5000;//轮播间隔时间
		var time = setInterval(move,timejg);
		function move(){
			$("#j_silder_outer .img-item").css("transform", "rotateX(" + (--num * 90) + "deg)");
		}
		$('.slider-outer').hover(function(){
			clearInterval(time);
		},function(){
			time = setInterval(move,timejg);
		});


	})
</script>
</body>
</html>