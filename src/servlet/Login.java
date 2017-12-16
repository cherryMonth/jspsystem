package servlet;
import system.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpSession;
import java.util.Iterator;
import java.util.ArrayList;
import javax.servlet.*;
import java.util.Enumeration;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/login_test")
public class Login extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		String info = "";
		String name = request.getParameter("name");
		if(name==null || name.length()==0)
				info = "用户名不能为空!";
		String password = request.getParameter("password");
		String type = request.getParameter("type");
		if(password==null || password.length()==0)
			info += "\n用户登陆密码不能为空!";
		if(info.length()>0) {
			this.fail(request, response, info);
			return;
		}
			
		Base base = null;
		if(type.equals("admin"))
			base = new Admin();
		if(type.equals("student"))
			base = new Student();
		if(type.equals("teacher"))
			base = new Teacher();
		Object [] param = new Object[1];
		param[0]=name;
		Object result= base.executeQuerySingle("select password from " + type + " where no= ? ",param);
		if(result==null){
			info="密码错误或者用户不存在！";
			fail(request,response,info);
			return;
		}
		HttpSession session = request.getSession();
		if(password.equals(result.toString())) {
			session.setAttribute("login_id",param[0]);
			if(type.equals("admin"))
			{ 
			session.setAttribute("status", "admin");
				response.sendRedirect("admin_index.jsp");}
			else if(type.equals("teacher"))
				{
				session.setAttribute("status", "teacher");
				response.sendRedirect("teacher_index.jsp");}
			else
				{
				session.setAttribute("status", "student");
				response.sendRedirect("student_index.jsp");
				}
		}
		else{
			fail(request,response,"登录密码错误!");	
		}
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
					"<title>登录失败</title>\r\n" + 
					"</head>");
			out.println("<div style=\"margin-bottom:150px;\">\r\n" + 
					"<nav class=\"navbar navbar-default\" role=\"navigation\">\r\n" + 
					"	<div class=\"container-fluid\">\r\n" + 
					"	<div class=\"navbar-header\">\r\n" + 
					"		<a class=\"navbar-brand\" href=\"#\">学生信息管理系统</a>\r\n" + 
					"	</div>\r\n" + 
					"	<div>\r\n" + 
					"	</div>\r\n" + 
					"	</div>\r\n" + 
					"</nav>\r\n" + 
					"\r\n" + 
					"</div>");
			out.println("<div class=\"container\" style=\"text-align:center\">");
			out.println("<h2>登录失败，请检查您的输入!</h2>");
			out.println("<a href=/system/login.jsp><h2>输入正确信息</h2></a>");
			out.println("</div>");
			out.println("</body></html>");
		}
		catch(IOException e) {
			
		}
	}
}
