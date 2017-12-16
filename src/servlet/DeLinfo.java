package servlet;
import system.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/delinfo")
public class DeLinfo extends HttpServlet{
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		request.setCharacterEncoding("utf-8");
		String type=(String)request.getParameter("type");
		if(type==null||type.length()==0) {
			fail(request,response,"该类型不存在!");
			return;
		}
	
		String key =(String)request.getParameter("key");
		if(key==null||key.length()==0) {
			fail(request,response,"主键为空无法进行删除!");
			return;
		}
		
		Base base = null;
		if(type.equals("fau"))
			base = new Faculty();
		if(type.equals("stu"))
			base = new Student();
		if(type.equals("tea"))
			base = new Teacher();
		if(type.equals("pro"))
			base = new Professional();
		if(type.equals("cla"))
			base = new CLass();
		if(type.equals("cou"))
			base = new Course();
		
		int result = base.del(key);
		if(result==0)
			fail(request,response,"请检查您的输入，删除失败!");
		else
			success(request,response);
	
	}
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		doPost(request,response);
	}
	
	public void fail(HttpServletRequest request,HttpServletResponse response,String args) {
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
					"<title>删除信息失败</title>\r\n" + 
					"</head>");
			out.println("<nav class=\"navbar navbar-default\" role=\"navigation\">\r\n" + 
					"	<div class=\"container-fluid\">\r\n" + 
					"	<div class=\"navbar-header\">\r\n" + 
					"		<a class=\"navbar-brand\" href=\"#\">学生信息管理系统</a>\r\n" + 
					"	</div>\r\n" + 
					"	<div>\r\n" + 
					"		<ul class=\"nav navbar-nav\">\r\n" + 
					"		<li><a href=\"admin_index.jsp\">首页</a></li>\r\n" + 
					"			<li><a href=\"addInfo.jsp\">添加信息</a></li>\r\n" + 
					"			\r\n" + 
					"					<li class=\"active\"><a href=\"deleteinfo.jsp\">删除信息</a></li>\r\n" + 
					"					<li><a href=\"queryinfo.jsp\">查询信息</a></li>\r\n" + 
					"					<li><a href=\"updateinfo.jsp\">编辑信息</a></li>\r\n" + 
					"					<li><a href=\"/system/exit\">退出登录</a></li>\r\n" + 
					"				</ul>\r\n" + 
					"	</div>\r\n" + 
					"	</div>\r\n" + 
					"</nav>");
			out.println("<div class=\"container\" style=\"text-align:center\"> ");
			out.println("<h2>"+args+"!</h2>");
			out.println("<a href=/system/deleteinfo.jsp><h2>重新输入信息!</h2></a>");
			out.println("</div>");
			out.println("</body></html>");
		}
		catch(IOException e) {
			
		}
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
					"<title>删除成功</title>\r\n" + 
					"</head>");
			out.println("<nav class=\"navbar navbar-default\" role=\"navigation\">\r\n" + 
					"	<div class=\"container-fluid\">\r\n" + 
					"	<div class=\"navbar-header\">\r\n" + 
					"		<a class=\"navbar-brand\" href=\"#\">学生信息管理系统</a>\r\n" + 
					"	</div>\r\n" + 
					"	<div>\r\n" + 
					"		<ul class=\"nav navbar-nav\">\r\n" + 
					"		<li><a href=\"admin_index.jsp\">首页</a></li>\r\n" + 
					"			<li><a href=\"addInfo.jsp\">添加信息</a></li>\r\n" + 
					"			\r\n" + 
					"					<li class=\"active\"><a href=\"deleteinfo.jsp\">删除信息</a></li>\r\n" + 
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
			out.println("<h2>删除成功!</h2>");
			out.println("<a href=/system/deleteinfo.jsp><h2>继续删除信息!</h2></a>");
			out.println("</div>");
			out.println("</body></html>");
		}
		catch(IOException e) {
			
		}
	}

}
