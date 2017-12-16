package servlet;

import system.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.*;
import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/displaystucredit")
public class Stuquerycredit extends HttpServlet{
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		String type = (String)request.getSession().getAttribute("login_id");
		if(type==null||type.length()==0) {
			fail(request,response,"请输入有效主键!");
			return;
		}
		Tableinfo t = new Tableinfo();
		HttpSession session=request.getSession();
		List <Object> list = new Test().excuteQuery("select * from result where student_no ="+type+";",null);
		if(list==null || list.size()==0) {
			fail(request,response,"当前表格无数据!");
			return;
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map = (java.util.Map<String, Object>) list.get(0);
		String [] column = map.keySet().toArray(new String[map.keySet().size()]);
		String [][] TableRecord = new String[list.size()][column.length];
		
		for(int i=0;i<list.size();i++) {
			map =  (java.util.Map<String, Object>) list.get(i);
			for(int j=0;j<column.length;j++) {
				TableRecord[i][j] =  map.get(column[j]).toString();
			}
		}
		t.setColumnName(column);
		t.setTableRecord(TableRecord);
		session.setAttribute("pageBean", t);
		response.sendRedirect("PageInfo.jsp");
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
					"<title>查询信息失败</title>\r\n" + 
					"</head>");
			out.println("<nav class=\"navbar navbar-default\" role=\"navigation\">\r\n" + 
					"	<div class=\"container-fluid\">\r\n" + 
					"	<div class=\"navbar-header\">\r\n" + 
					"		<a class=\"navbar-brand\" href=\"#\">学生信息管理系统</a>\r\n" + 
					"	</div>\r\n" + 
					"	<div>\r\n" + 
					"		<ul class=\"nav navbar-nav\">\r\n" + 
					"		<li><a href=\"student_index.jsp\">首页</a></li>\r\n" + 
					"			<li><a href=\"/system/displaystucourse\">查询课程表</a></li>\r\n" + 
					"			\r\n" + 
					"					<li class=\"active\"><a href=\"/system/displaystucredit\">查看成绩单</a></li>\r\n" + 
					"					<li><a href=\"/system/exit\">退出登录</a></li>\r\n" + 
					"				</ul>\r\n" + 
					"	</div>\r\n" + 
					"	</div>\r\n" + 
					"</nav>");
			out.println("<div class=\"container\" style=\"text-align:center\"> ");
			out.println("<h2>"+args+"!</h2>");
			out.println("<a href=/system/student_index.jsp><h2>返回首页!</h2></a>");
			out.println("</div>");
			out.println("</body></html>");
		}
		catch(IOException e) {
			
		}
	}
}
