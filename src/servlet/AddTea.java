package servlet;
import system.Teacher;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.ArrayList;
import javax.servlet.*;
import java.util.Enumeration;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/addtea")
public class AddTea extends HttpServlet{
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		request.setCharacterEncoding("utf-8");
		Enumeration enu=request.getParameterNames();
		Teacher t=new Teacher();
		ArrayList<String> list=new ArrayList();
		while(enu.hasMoreElements()) {
			String k = new String();
			k=(String) enu.nextElement();
			list.add(k);
		}
		Iterator it = list.iterator();
		Object [] o = new Object[5];
		while(it.hasNext())
		{
			String test = (String) it.next();
			if(test.equals("no")) {
				o[0] = request.getParameter(test);
			if(((String)o[0]).equals("") || ((String)o[0])==null) {
				fail(request,response);
				return;
			}
			}
			if(test.equals("name"))
			{
				o[1] = request.getParameter(test);
			if(((String)o[1]).equals("") || ((String)o[1])==null) {
				fail(request,response);
				return;
			}
			}
			if(test.equals("age"))
			{
				o[2] = request.getParameter(test);
			}
			if(test.equals("password"))
			{
				o[3] = request.getParameter(test);
			if(((String)o[3]).equals("") || ((String)o[3])==null) {
				fail(request,response);
				return;
			}
			}
			if(test.equals("sex"))
			{
				o[4] = request.getParameter(test);
			if(((String)o[4]).equals("") || ((String)o[4])==null) {
				fail(request,response);
				return;
			}
			}
			
		}
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
					"<title>��ӽ�ʦ�ɹ�</title>\r\n" + 
					"</head>");
			out.println("<nav class=\"navbar navbar-default\" role=\"navigation\">\r\n" + 
					"	<div class=\"container-fluid\">\r\n" + 
					"	<div class=\"navbar-header\">\r\n" + 
					"		<a class=\"navbar-brand\" href=\"#\">ѧ����Ϣ����ϵͳ</a>\r\n" + 
					"	</div>\r\n" + 
					"	<div>\r\n" + 
					"		<ul class=\"nav navbar-nav\">\r\n" + 
					"		<li><a href=\"admin_index.jsp\">��ҳ</a></li>\r\n" + 
					"			<li class=\"active\"><a href=\"addInfo.jsp\">�����Ϣ</a></li>\r\n" + 
					"			\r\n" + 
					"					<li><a href=\"deleteinfo.jsp\">ɾ����Ϣ</a></li>\r\n" + 
					"					<li><a href=\"queryinfo.jsp\">��ѯ��Ϣ</a></li>\r\n" + 
					"					<li><a href=\"updateinfo.jsp\">�༭��Ϣ</a></li>\r\n" + 
					"					<li><a href=\"/system/exit\">�˳���¼</a></li>\r\n" + 
					"				</ul>\r\n" + 
					"	</div>\r\n" + 
					"	</div>\r\n" + 
					"</nav>");
			out.println("<div class=\"container\" style=\"text-align:center\">");
			out.println("<a href=/system/addInfo.jsp><h2>���������Ϣ</h2></a>");
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
					"<title>��ӽ�ʦʧ��</title>\r\n" + 
					"</head>");
			out.println("<nav class=\"navbar navbar-default\" role=\"navigation\">\r\n" + 
					"	<div class=\"container-fluid\">\r\n" + 
					"	<div class=\"navbar-header\">\r\n" + 
					"		<a class=\"navbar-brand\" href=\"#\">ѧ����Ϣ����ϵͳ</a>\r\n" + 
					"	</div>\r\n" + 
					"	<div>\r\n" + 
					"		<ul class=\"nav navbar-nav\">\r\n" + 
					"		<li><a href=\"admin_index.jsp\">��ҳ</a></li>\r\n" + 
					"			<li class=\"active\"><a href=\"addInfo.jsp\">�����Ϣ</a></li>\r\n" + 
					"			\r\n" + 
					"					<li><a href=\"deleteinfo.jsp\">ɾ����Ϣ</a></li>\r\n" + 
					"					<li><a href=\"queryinfo.jsp\">��ѯ��Ϣ</a></li>\r\n" + 
					"					<li><a href=\"updateinfo.jsp\">�༭��Ϣ</a></li>\r\n" + 
					"					<li><a href=\"/system/exit\">�˳���¼</a></li>\r\n" + 
					"				</ul>\r\n" + 
					"			</li>\r\n" + 
					"		</ul>\r\n" + 
					"	</div>\r\n" + 
					"	</div>\r\n" + 
					"</nav>");
			out.println("<div class=\"container\" style=\"text-align:center\">");
			out.println("<h2>���ʧ�ܣ�������������!</h2>");
			out.println("<a href=/system/addInfo.jsp><h2>������ȷ��Ϣ</h2></a>");
			out.println("</div>");
			out.println("</body></html>");
		}
		catch(IOException e) {
			
		}
	}

}
