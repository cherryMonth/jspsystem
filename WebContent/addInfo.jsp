<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>添加信息</title>
<script>
function addFac(){
	var div=document.getElementById("form");
	var el = document.getElementById("newform");
	if(el){
	el.parentNode.removeChild(el);	
	}
	var newform = document.createElement("form");
	newform.setAttribute("action","/system/addFac");
	newform.setAttribute("method","post");
	newform.setAttribute("name", "newform");
	newform.setAttribute("id","newform");
	var input1 = document.createElement("input");
	input1.name="no";
	input1.setAttribute("class","form-control");
	input1.setAttribute("style","width:200px;margin-left:45%;");
	input1.setAttribute("placeholder","请输入学院号!");
	var input2 = document.createElement("input");
	input2.setAttribute("placeholder","请输入学院名称!");
	input2.name="name";
	input2.setAttribute("class","form-control");
	input2.setAttribute("style","width:200px;margin-left:45%;");
	var input3 = document.createElement("input");
	input3.setAttribute("placeholder","请输入院长!");
	input3.name="dean";
	input3.setAttribute("class","form-control");
	input3.setAttribute("style","width:200px;margin-left:45%;");
	var submit = document.createElement("div");
	submit.setAttribute("style","text-align:center")
	submit.innerHTML="<button type=\"submit\" class=\"btn btn-default\">提交</button>";
	newform.append(document.createElement("br"));
	newform.append(input1);
	newform.append(document.createElement("br"));
	newform.append(input2);
	newform.append(document.createElement("br"));
	newform.append(input3);
	newform.append(document.createElement("br"));
	newform.append(submit);
	newform.append(document.createElement("br"));
	div.append(newform);
}

function addPro(){
	var div=document.getElementById("form");
	var el = document.getElementById("newform");
	if(el){
	el.parentNode.removeChild(el);	
	}
	var newform = document.createElement("form");
	newform.setAttribute("method","post");
	newform.setAttribute("action","/system/addPro");
	newform.setAttribute("name", "newform");
	newform.setAttribute("id","newform");
	var input1 = document.createElement("input");	
	input1.name="no";
	input1.setAttribute("placeholder","请输入专业号!");
	input1.setAttribute("class","form-control");
	input1.setAttribute("style","width:200px;margin-left:45%;");
	var input2 = document.createElement("input");
	input2.name="name";
	input2.setAttribute("class","form-control");
	input2.setAttribute("style","width:200px;margin-left:45%;");
	input2.setAttribute("placeholder","请输入专业名称!");
	var input3 = document.createElement("input");
	input3.name="faculty_no";
	input3.setAttribute("class","form-control");
	input3.setAttribute("style","width:200px;margin-left:45%;");
	var submit = document.createElement("div");
	submit.setAttribute("style","text-align:center")
	submit.innerHTML="<button type=\"submit\" class=\"btn btn-default\">提交</button>";
	input3.setAttribute("placeholder","请输入学院号!");
	newform.append(document.createElement("br"));
	newform.append(input1);
	newform.append(document.createElement("br"));
	newform.append(input2);
	newform.append(document.createElement("br"));
	newform.append(input3);
	newform.append(document.createElement("br"));
	newform.append(submit);
	newform.append(document.createElement("br"));
	div.append(newform);
}

function addCou(){
	var div=document.getElementById("form");
	var el = document.getElementById("newform");
	if(el){
	el.parentNode.removeChild(el);	
	}
	var newform = document.createElement("form");
	newform.setAttribute("method","post");
	newform.setAttribute("action","/system/addCou");
	newform.setAttribute("name", "newform");
	newform.setAttribute("id","newform");
	var input1 = document.createElement("input");	
	input1.name="no";
	input1.setAttribute("class","form-control");
	input1.setAttribute("style","width:200px;margin-left:45%;");
	input1.setAttribute("placeholder","请输入课程号!");
	
	var input2 = document.createElement("input");
	input2.name="name";
	input2.setAttribute("class","form-control");
	input2.setAttribute("style","width:200px;margin-left:45%;");
	input2.setAttribute("placeholder","请输入课程名称!");
	
	var input3 = document.createElement("input");
	input3.name="pro_no";
	input3.setAttribute("class","form-control");
	input3.setAttribute("style","width:200px;margin-left:45%;");
	input3.setAttribute("placeholder","请输入专业号!");
	
	var input4 = document.createElement("input");
	input4.name="work_no";
	input4.setAttribute("class","form-control");
	input4.setAttribute("style","width:200px;margin-left:45%;");
	input4.setAttribute("placeholder","请输入任课教师工号!");
	
	var input5 = document.createElement("input");
	input5.name="credit_no";
	input5.setAttribute("class","form-control");
	input5.setAttribute("style","width:200px;margin-left:45%;");
	input5.setAttribute("placeholder","请输入课程所占学分!");
	
	
	var submit = document.createElement("div");
	submit.setAttribute("style","text-align:center")
	submit.innerHTML="<button type=\"submit\" class=\"btn btn-default\">提交</button>";
	newform.append(document.createElement("br"));
	newform.append(input1);
	newform.append(document.createElement("br"));
	newform.append(input2);
	newform.append(document.createElement("br"));
	newform.append(input3);
	newform.append(document.createElement("br"));
	newform.append(input4);
	newform.append(document.createElement("br"));
	newform.append(input5);
	newform.append(document.createElement("br"));
	newform.append(submit);
	newform.append(document.createElement("br"));
	div.append(newform);
}

function addTea(){
	var div=document.getElementById("form");
	var el = document.getElementById("newform");
	if(el){
	el.parentNode.removeChild(el);	
	}
	var newform = document.createElement("form");
	newform.setAttribute("method","post");
	newform.setAttribute("action","/system/addTea");
	newform.setAttribute("name", "newform");
	newform.setAttribute("id","newform");
	var input1 = document.createElement("input");
	input1.name="no";
	input1.setAttribute("class","form-control");
	input1.setAttribute("style","width:200px;margin-left:45%;");
	input1.setAttribute("placeholder","请输入教师号!");
	var input2 = document.createElement("input");
	input2.setAttribute("placeholder","请输入教师名称!");
	input2.name="name";
	input2.setAttribute("class","form-control");
	input2.setAttribute("style","width:200px;margin-left:45%;");
	var input3 = document.createElement("input");
	input3.setAttribute("placeholder","请输入年龄!");
	input3.name="age";
	input3.setAttribute("class","form-control");
	input3.setAttribute("style","width:200px;margin-left:45%;");
	var input4 = document.createElement("input");
	input4.setAttribute("placeholder","请输入登录密码!");
	input4.name="password";
	input4.setAttribute("class","form-control");
	input4.setAttribute("style","width:200px;margin-left:45%;");
	input4.type="password";
	var input5 = document.createElement("select");
	input5.name="sex";
	input5.innerHTML="<option value=\"男\">男性</option>"+ 
	"<option value=\"女\">女性</option>";
	
	var submit = document.createElement("div");
	submit.setAttribute("style","text-align:center")
	submit.innerHTML="<button type=\"submit\" class=\"btn btn-default\">提交</button>";
	newform.append(document.createElement("br"));
	newform.append(input1);
	newform.append(document.createElement("br"));
	newform.append(input2);
	newform.append(document.createElement("br"));
	newform.append(input3);
	newform.append(document.createElement("br"));
	newform.append(input4);
	newform.append(document.createElement("br"));
	newform.append(document.createTextNode("请选择性别：   "));
	newform.append(input5);
	newform.append(document.createElement("br"));
	newform.append(document.createElement("br"));
	newform.append(submit);
	newform.append(document.createElement("br"));
	div.append(newform);
}

function addClas(){
	var div=document.getElementById("form");
	var el = document.getElementById("newform");
	if(el){
	el.parentNode.removeChild(el);	
	}
	var newform = document.createElement("form");
	newform.setAttribute("method","post");
	newform.setAttribute("action","/system/addClas");
	newform.setAttribute("name", "newform");
	newform.setAttribute("id","newform")
	var input1 = document.createElement("input");
	input1.name="no";
	input1.setAttribute("class","form-control");
	input1.setAttribute("style","width:200px;margin-left:45%;");
	input1.setAttribute("placeholder","请输入班级号!");
	var input2 = document.createElement("input");
	input2.setAttribute("placeholder","请输入班级名称!");
	input2.name="name";
	input2.setAttribute("class","form-control");
	input2.setAttribute("style","width:200px;margin-left:45%;");
	var input3 = document.createElement("input");
	input3.setAttribute("placeholder","请输入所属专业号!");
	input3.name="pro_no";
	input3.setAttribute("class","form-control");
	input3.setAttribute("style","width:200px;margin-left:45%;");
	var submit = document.createElement("div");
	submit.setAttribute("style","text-align:center")
	submit.innerHTML="<button type=\"submit\" class=\"btn btn-default\">提交</button>";
	newform.append(document.createElement("br"));
	newform.append(input1);
	newform.append(document.createElement("br"));
	newform.append(input2);
	newform.append(document.createElement("br"));
	newform.append(input3);
	newform.append(document.createElement("br"));
	newform.append(submit);
	newform.append(document.createElement("br"));
	div.append(newform);
}

function addStu(){
	var div=document.getElementById("form");
	var el = document.getElementById("newform");
	if(el){
	el.parentNode.removeChild(el);	
	}
	var newform = document.createElement("form");
	newform.setAttribute("method","post");
	newform.setAttribute("action","/system/addStu");
	newform.setAttribute("name", "newform");
	newform.setAttribute("id","newform")
	var input1 = document.createElement("input");
	input1.name="no";
	input1.setAttribute("placeholder","请输入学生学号!");
	input1.setAttribute("class","form-control");
	input1.setAttribute("style","width:200px;margin-left:45%;");
	var input2 = document.createElement("input");
	input2.setAttribute("placeholder","请输入学生名称!");
	input2.name="name";
	input2.setAttribute("class","form-control");
	input2.setAttribute("style","width:200px;margin-left:45%;");
	var input3 = document.createElement("select");
	input3.name="sex";
	input3.innerHTML="<option value=\"男\">男性</option>"+ 
	"<option value=\"女\">女性</option>";
	
	var input4 = document.createElement("input");
	input4.setAttribute("placeholder","请输入登录密码!");
	input4.type="password";
	input4.name="password";
	input4.setAttribute("class","form-control");
	input4.setAttribute("style","width:200px;margin-left:45%;");
	var input5 = document.createElement("input");
	input5.setAttribute("placeholder","请输入生日!");
	input5.name="birthday";
	input5.setAttribute("class","form-control");
	input5.setAttribute("style","width:200px;margin-left:45%;");
	var input6 = document.createElement("input");
	input6.setAttribute("placeholder","请输入年龄!");
	input6.name="age";
	input6.setAttribute("class","form-control");
	input6.setAttribute("style","width:200px;margin-left:45%;");
	var input7 = document.createElement("input");
	input7.setAttribute("placeholder","请输入专业号!");
	input7.name="Pro_No";
	input7.setAttribute("class","form-control");
	input7.setAttribute("style","width:200px;margin-left:45%;");
	var input8 = document.createElement("input");
	input8.setAttribute("placeholder","请输入年级!");
	input8.name="Grade";
	input8.setAttribute("class","form-control");
	input8.setAttribute("style","width:200px;margin-left:45%;");
	var input9 = document.createElement("input");
	input9.setAttribute("placeholder","请输入班级号!");
	input9.name="class_no";
	input9.setAttribute("class","form-control");
	input9.setAttribute("style","width:200px;margin-left:45%;");
	var submit = document.createElement("div");
	submit.setAttribute("style","text-align:center")
	submit.innerHTML="<button type=\"submit\" class=\"btn btn-default\">提交</button>";
	newform.append(document.createElement("br"));
	newform.append(input1);
	newform.append(document.createElement("br"));
	newform.append(input2);
	newform.append(document.createElement("br"));
	newform.append(input4);
	newform.append(document.createElement("br"));
	newform.append(input5);
	newform.append(document.createElement("br"));
	newform.append(input6);
	newform.append(document.createElement("br"));
	newform.append(input7);
	newform.append(document.createElement("br"));
	newform.append(input8);
	newform.append(document.createElement("br"));
	newform.append(input9);
	newform.append(document.createElement("br"));
	newform.append(document.createTextNode("请选择性别：   "));
	newform.append(input3);
	newform.append(document.createElement("br"));
	newform.append(document.createElement("br"));
	newform.append(submit);
	newform.append(document.createElement("br"));
	div.append(newform);
}

</script>
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
			<li class="active"><a href="addInfo.jsp">添加信息</a></li>
			
					<li><a href="deleteinfo.jsp">删除信息</a></li>
					<li><a href="queryinfo.jsp">查询信息</a></li>
					<li><a href="updateinfo.jsp">编辑信息</a></li>
					<li><a href="/system/exit">退出登录</a></li>
				</ul>
	</div>
	</div>
</nav>
<div style="text-align:center">
<input type="radio" name="type" value="添加学院" onClick="addFac()">添加学院
<input type="radio" name="type" value="添加专业" onClick="addPro()">添加专业
<input type="radio" name="type" value="添加课程" onClick="addCou()">添加课程
<input type="radio" name="type" value="添加教师" onClick="addTea()">添加教师
<input type="radio" name="type" value="添加班级" onClick="addClas()">添加班级
<input type="radio" name="type" value="添加学生" onClick="addStu()">添加学生
</div>
<div id="form" style="text-align:center">
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