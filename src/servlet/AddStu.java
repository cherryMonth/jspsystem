package servlet;
import system.Student;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.ArrayList;
import javax.servlet.*;
import java.util.Enumeration;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/addStu")
public class AddStu extends HttpServlet{
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		request.setCharacterEncoding("utf-8");
		Enumeration enu=request.getParameterNames();
		Student t=new Student();
		ArrayList<String> list=new ArrayList();
		while(enu.hasMoreElements()) {
			String k = new String();
			k=(String) enu.nextElement();
			list.add(k);
		}
		Iterator it = list.iterator();
		Object [] o = new Object[10];
		while(it.hasNext())
		{
			String test = (String) it.next();
			if(test.equals("no"))
				o[0] = request.getParameter(test);
			if(test.equals("name"))
				o[1] = request.getParameter(test);
			if(test.equals("sex"))
				o[2] = request.getParameter(test);
			if(test.equals("password"))
				o[3] = request.getParameter(test);
			if(test.equals("birthday"))
				o[4] = request.getParameter(test);
			if(test.equals("age"))
				o[5] = request.getParameter(test);
			if(test.equals("Pro_No"))
				o[6] = request.getParameter(test);
			if(test.equals("Grade"))
				o[7] = request.getParameter(test);
			if(test.equals("class_no"))
				o[9] = request.getParameter(test);
		}
		o[8] = 0.0;
		int result = t.add(o);
		if(result==0) 
		fail(request,response);
		else
		success(request,response);
	}
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		doPost(request,response);
	}
	
	public void success(HttpServletRequest request,HttpServletResponse response) {
		response.setContentType("text/html;charset=utf-8");
		try {
			PrintWriter out=response.getWriter();
			out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n" + 
					"<html>\r\n" + 
					"<head>\r\n" + 
					"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\r\n" + 
					"<link rel=\"stylesheet\" href=\"http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css\">\r\n" + 
					"	<script src=\"http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js\"></script>\r\n" + 
					"	<script src=\"http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js\"></script>\r\n" + 
					"<title>添加学生成功</title>\r\n" + 
					"</head>");
			out.println("<nav class=\"navbar navbar-default\" role=\"navigation\">\r\n" + 
					"	<div class=\"container-fluid\">\r\n" + 
					"	<div class=\"navbar-header\">\r\n" + 
					"		<a class=\"navbar-brand\" href=\"#\">学生信息管理系统</a>\r\n" + 
					"	</div>\r\n" + 
					"	<div>\r\n" + 
					"		<ul class=\"nav navbar-nav\">\r\n" + 
					"		<li><a href=\"admin_index.jsp\">首页</a></li>\r\n" + 
					"			<li class=\"active\"><a href=\"addInfo.jsp\">添加信息</a></li>\r\n" + 
					"			\r\n" + 
					"					<li><a href=\"deleteinfo.jsp\">删除信息</a></li>\r\n" + 
					"					<li><a href=\"queryinfo.jsp\">查询信息</a></li>\r\n" + 
					"					<li><a href=\"updateinfo.jsp\">编辑信息</a></li>\r\n" + 
					"					<li><a href=\"/system/exit\">退出登录</a></li>\r\n" + 
					"				</ul>\r\n" + 
					"	</div>\r\n" + 
					"	</div>\r\n" + 
					"</nav>");
			out.println("<div class=\"container\" style=\"text-align:center\">");
			out.println("<a href=/system/addInfo.jsp><h2>继续添加信息</h2></a>");
			out.println("</div>");
			out.println("</body></html>");
		}
		catch(IOException e) {
			
		}
	}
	
	public void fail(HttpServletRequest request,HttpServletResponse response) {
		response.setContentType("text/html;charset=utf-8");
		try {
			PrintWriter out=response.getWriter();
			out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n" + 
					"<html>\r\n" + 
					"<head>\r\n" + 
					"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\r\n" + 
					"<link rel=\"stylesheet\" href=\"http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css\">\r\n" + 
					"	<script src=\"http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js\"></script>\r\n" + 
					"	<script src=\"http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js\"></script>\r\n" + 
					"<title>添加学生失败</title>\r\n" + 
					"</head>");
			out.println("<nav class=\"navbar navbar-default\" role=\"navigation\">\r\n" + 
					"	<div class=\"container-fluid\">\r\n" + 
					"	<div class=\"navbar-header\">\r\n" + 
					"		<a class=\"navbar-brand\" href=\"#\">学生信息管理系统</a>\r\n" + 
					"	</div>\r\n" + 
					"	<div>\r\n" + 
					"		<ul class=\"nav navbar-nav\">\r\n" + 
					"		<li><a href=\"admin_index.jsp\">首页</a></li>\r\n" + 
					"			<li class=\"active\"><a href=\"addInfo.jsp\">添加信息</a></li>\r\n" + 
					"			\r\n" + 
					"					<li><a href=\"deleteinfo.jsp\">删除信息</a></li>\r\n" + 
					"					<li><a href=\"queryinfo.jsp\">查询信息</a></li>\r\n" + 
					"					<li><a href=\"updateinfo.jsp\">编辑信息</a></li>\r\n" + 
					"					<li><a href=\"/system/exit\">退出登录</a></li>\r\n" + 
					"				</ul>\r\n" + 
					"			</li>\r\n" + 
					"		</ul>\r\n" + 
					"	</div>\r\n" + 
					"	</div>\r\n" + 
					"</nav>");
			out.println("<div class=\"container\" style=\"text-align:center\">");
			out.println("<h2>添加失败，请检查您的输入!</h2>");
			out.println("<a href=/system/addInfo.jsp><h2>输入正确信息</h2></a>");
			out.println("</div>");
			out.println("</body></html>");
		}
		catch(IOException e) {
			
		}
	}

}
