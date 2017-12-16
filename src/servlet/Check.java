package servlet;
import system.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/check")
public class Check extends HttpServlet{
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		request.setCharacterEncoding("utf-8");
		Enumeration enu=request.getParameterNames();
		String table = request.getParameter("table");
		String old = request.getParameter("old");
		Test t = new Test();
		String sql="update "+table+" set ";
		while(enu.hasMoreElements()) {
			String key = (String)enu.nextElement();
			if(key.equals("submit") || key.equals("table")||key.equals("old"))
				continue;
			else if(key.equals("people_num") || key.equals("Total_Credits") || key.equals("credit"))
			sql += key+"="+request.getParameter(key)+",";
			else
			sql += key+"="+"\""+request.getParameter(key)+"\",";
			
		}
		sql=sql.substring(0, sql.length()-1);
		sql += " where no="+old+";";
		System.out.println(sql);
		int result = t.executeUpdate(sql, null);
		if(result==0) 
			fail(request,response,"����ʧ�ܣ�������������!");
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
			out.println("<h2>"+args+"</h2>");
			out.println("<a href=/system/updateinfo.jsp><h2>����������Ϣ!</h2></a>");
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
					"<title>������Ϣ�ɹ�</title>\r\n" + 
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
					"			</li>\r\n" + 
					"		</ul>\r\n" + 
					"	</div>\r\n" + 
					"	</div>\r\n" + 
					"</nav>");
			out.println("<div class=\"container\" style=\"text-align:center\"> ");
			out.println("<h2>���³ɹ�!</h2>");
			out.println("<a href=/system/updateinfo.jsp><h2>����������Ϣ!</h2></a>");
			out.println("</div>");
			out.println("</body></html>");
		}
		catch(IOException e) {
			
		}
	}
	

}
