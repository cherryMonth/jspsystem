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
			fail(request,response,"�����Ͳ�����!");
			return;
		}
	
		String key =(String)request.getParameter("key");
		if(key==null||key.length()==0) {
			fail(request,response,"����Ϊ���޷�����ɾ��!");
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
			fail(request,response,"�����������룬ɾ��ʧ��!");
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
					"<title>ɾ����Ϣʧ��</title>\r\n" + 
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
					"					<li class=\"active\"><a href=\"deleteinfo.jsp\">ɾ����Ϣ</a></li>\r\n" + 
					"					<li><a href=\"queryinfo.jsp\">��ѯ��Ϣ</a></li>\r\n" + 
					"					<li><a href=\"updateinfo.jsp\">�༭��Ϣ</a></li>\r\n" + 
					"					<li><a href=\"/system/exit\">�˳���¼</a></li>\r\n" + 
					"				</ul>\r\n" + 
					"	</div>\r\n" + 
					"	</div>\r\n" + 
					"</nav>");
			out.println("<div class=\"container\" style=\"text-align:center\"> ");
			out.println("<h2>"+args+"!</h2>");
			out.println("<a href=/system/deleteinfo.jsp><h2>����������Ϣ!</h2></a>");
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
					"<title>ɾ���ɹ�</title>\r\n" + 
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
					"					<li class=\"active\"><a href=\"deleteinfo.jsp\">ɾ����Ϣ</a></li>\r\n" + 
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
			out.println("<h2>ɾ���ɹ�!</h2>");
			out.println("<a href=/system/deleteinfo.jsp><h2>����ɾ����Ϣ!</h2></a>");
			out.println("</div>");
			out.println("</body></html>");
		}
		catch(IOException e) {
			
		}
	}

}
