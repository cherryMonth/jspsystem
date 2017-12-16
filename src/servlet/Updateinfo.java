package servlet;
import system.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.Enumeration;
import java.util.HashMap;

@WebServlet("/updateinfo")
public class Updateinfo extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		request.setCharacterEncoding("utf-8");
		String type=(String)request.getParameter("type");
		if(type==null||type.length()==0) {
			fail(request,response,"��ѡ��ѡ���е�����");
			return;
		}
		HttpSession session=request.getSession();
		Tableinfo t = new Tableinfo();
		String key=request.getParameter("key");
		if(key==null||key.length()==0) {
			fail(request,response,"����������������������!");
			return;
		}
		List <Object> list = new Test().excuteQuery("select * from "+type+" where no="+key, null);
		if(list.size()==0) {
			fail(request,response,"�޷���Ҫ�������!");
			return;
		}
		String old="";
		Map<String, Object> map = new HashMap<String, Object>();
		map = (java.util.Map<String, Object>) list.get(0);
		String [] column = map.keySet().toArray(new String[map.keySet().size()]);
		String [][] TableRecord = new String[1][column.length];
			map =  (java.util.Map<String, Object>) list.get(0);
			for(int j=0;j<column.length;j++) {
				TableRecord[0][j] =  map.get(column[j]).toString();
				if(column[j].equals("no"))
					old=TableRecord[0][j];
				
			}
			
		t.setColumnName(column);
		t.setTableRecord(TableRecord);
		session.setAttribute("pageBean", t);
		session.setAttribute("table", type);
		session.setAttribute("old", old);
		response.sendRedirect("edit.jsp");
		
		
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
					"<title>������Ϣʧ��</title>\r\n" + 
					"</head>");
			out.println("<nav class=\"navbar navbar-default\" role=\"navigation\">\r\n" + 
					"	<div class=\"container-fluid\">\r\n" + 
					"	<div class=\"navbar-header\">\r\n" + 
					"		<a class=\"navbar-brand\" href=\"#\">ѧ����Ϣ����ϵͳ</a>\r\n" + 
					"	</div>\r\n" + 
					"	<div>\r\n" + 
					"		<ul class=\"nav navbar-nav\">\r\n" + 
					"		<li><a href=\"admin_index.jsp\">��ҳ</a></li>\r\n" + 
					"			<li><a href=\"addInfo.jsp\">�����Ϣ</a></li>\r\n" + 
					"			\r\n" + 
					"					<li><a href=\"deleteinfo.jsp\">ɾ����Ϣ</a></li>\r\n" + 
					"					<li><a href=\"queryinfo.jsp\">��ѯ��Ϣ</a></li>\r\n" + 
					"					<li class=\"active\"><a href=\"updateinfo.jsp\">�༭��Ϣ</a></li>\r\n" + 
					"					<li><a href=\"/system/exit\">�˳���¼</a></li>\r\n" + 
					"				</ul>\r\n" + 
					"	</div>\r\n" + 
					"	</div>\r\n" + 
					"</nav>");
			out.println("<div class=\"container\" style=\"text-align:center\"> ");
			out.println("<h2>"+args+"!</h2>");
			out.println("<a href=/system/updateinfo.jsp><h2>����������Ϣ!</h2></a>");
			out.println("</div>");
			out.println("</body></html>");
		}
		catch(IOException e) {
			
		}
	}
}
