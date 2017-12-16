package servlet;
import system.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import javax.servlet.*;
import java.util.Enumeration;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/getstuinfo")
public class Createreport extends HttpServlet{
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		request.setCharacterEncoding("utf-8");
		String key=request.getParameter("key");
		if(key==null||key.length()==0) {
			fail(request,response,"课程主键不存在,请检查你的输入!");
			return;
		}
		
		String stu_no = request.getParameter("id");
		if(stu_no==null||stu_no.length()==0) {
			fail(request,response,"学生主键不存在,请检查你的输入!");
			return;
		}
		float grade = 0;
		String credit = request.getParameter("credit");
		{
			if(credit==null||credit.length()==0) {
				fail(request,response,"成绩没有输入!");
				return;
			}
			try {
				grade = Integer.parseInt(credit);
			}
			catch(Exception e) {
				fail(request,response,"您输入的成绩不是有效值!");
				return;
			}
		}
		Test t = new Test();
		String login_id = (String) request.getSession().getAttribute("login_id");
		Object [] o = new Object[2];
		o[0] = login_id;
		o[1] = key;
		String pro_no=(String)t.executeQuerySingle("select Pro_No from course where work_no=? and  no = ?", o);
		if(pro_no==null||pro_no.length()==0) {
			fail(request,response,"您的课程列表下不存在主键对应的课程!");
			return;
		}
		String sql = "insert into result values(?,?,?,?)";
		Object [] o2 = new Object[4];
		o2[0] = key;
		o2[1] = login_id;
		o2[2] = stu_no;
		o2[3] = grade;
		int result = new Test().executeUpdate(sql, o2);
		if(result>0)
			success(request,response);
		else
			fail(request,response,"添加失败，请检查你的输入!");
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
					"<title>查询课程失败</title>\r\n" + 
					"</head>");
					out.println("<nav class=\"navbar navbar-default\" role=\"navigation\">\r\n" + 
					"	<div class=\"container-fluid\">\r\n" + 
					"	<div class=\"navbar-header\">\r\n" + 
					"		<a class=\"navbar-brand\" href=\"#\">学生信息管理系统</a>\r\n" + 
					"	</div>\r\n" + 
					"	<div>\r\n" + 
					"		<ul class=\"nav navbar-nav\">\r\n" + 
					"		<li><a href=\"teacher_index.jsp\">首页</a></li>\r\n" + 
					"			<li><a href=\"/system/displaycourse\">查询课程表</a></li>\r\n" + 
					"			\r\n" + 
					"					<li class=\"active\"><a href=\"createreport.jsp\">生成成绩单</a></li>\r\n" + 
					"					<li><a href=\"querystudentcredit.jsp\">查看对应课程学生成绩单</a></li>\r\n" + 
					"					<li><a href=\"/system/exit\">退出登录</a></li>\r\n" + 
					"				</ul>\r\n" + 
					"	</div>\r\n" + 
					"	</div>\r\n" + 
					"</nav>");
			out.println("<div class=\"container\" style=\"text-align:center\">");
			out.println("<h2>插入成功!</h2>");
			out.println("<a href=/system/createreport.jsp>继续批改成绩</a>");
			out.println("</div>");
			out.println("</body></html>");
		}
		catch(IOException e) {
			
		}
	}
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
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
					"<title>查询课程失败</title>\r\n" + 
					"</head>");
			out.println("<nav class=\"navbar navbar-default\" role=\"navigation\">\r\n" + 
					"	<div class=\"container-fluid\">\r\n" + 
					"	<div class=\"navbar-header\">\r\n" + 
					"		<a class=\"navbar-brand\" href=\"#\">学生信息管理系统</a>\r\n" + 
					"	</div>\r\n" + 
					"	<div>\r\n" + 
					"		<ul class=\"nav navbar-nav\">\r\n" + 
					"		<li><a href=\"teacher_index.jsp\">首页</a></li>\r\n" + 
					"			<li><a href=\"/system/displaycourse\">查询课程表</a></li>\r\n" + 
					"			\r\n" + 
					"					<li class=\"active\"><a href=\"createreport.jsp\">生成成绩单</a></li>\r\n" + 
					"					<li><a href=\"querystudentcredit.jsp\">查看对应课程学生成绩单</a></li>\r\n" + 
					"					<li><a href=\"/system/exit\">退出登录</a></li>\r\n" + 
					"				</ul>\r\n" + 
					"			</li>\r\n" + 
					"		</ul>\r\n" + 
					"	</div>\r\n" + 
					"	</div>\r\n" + 
					"</nav>");
			out.println("<div class=\"container\" style=\"text-align:center\">");
			out.println("<h2>创建失败,学生成绩已经被创建或者该学生不存在!</h2>");
			out.println("<a href=/system/createreport.jsp><h2>重新输入!</h2></a>");
			out.println("</div>");
			out.println("</body></html>");
		}
		catch(IOException e) {
			
		}
	}

}
