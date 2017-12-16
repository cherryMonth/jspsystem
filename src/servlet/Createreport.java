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
			fail(request,response,"�γ�����������,�����������!");
			return;
		}
		
		String stu_no = request.getParameter("id");
		if(stu_no==null||stu_no.length()==0) {
			fail(request,response,"ѧ������������,�����������!");
			return;
		}
		float grade = 0;
		String credit = request.getParameter("credit");
		{
			if(credit==null||credit.length()==0) {
				fail(request,response,"�ɼ�û������!");
				return;
			}
			try {
				grade = Integer.parseInt(credit);
			}
			catch(Exception e) {
				fail(request,response,"������ĳɼ�������Чֵ!");
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
			fail(request,response,"���Ŀγ��б��²�����������Ӧ�Ŀγ�!");
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
			fail(request,response,"���ʧ�ܣ������������!");
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
					"<title>��ѯ�γ�ʧ��</title>\r\n" + 
					"</head>");
					out.println("<nav class=\"navbar navbar-default\" role=\"navigation\">\r\n" + 
					"	<div class=\"container-fluid\">\r\n" + 
					"	<div class=\"navbar-header\">\r\n" + 
					"		<a class=\"navbar-brand\" href=\"#\">ѧ����Ϣ����ϵͳ</a>\r\n" + 
					"	</div>\r\n" + 
					"	<div>\r\n" + 
					"		<ul class=\"nav navbar-nav\">\r\n" + 
					"		<li><a href=\"teacher_index.jsp\">��ҳ</a></li>\r\n" + 
					"			<li><a href=\"/system/displaycourse\">��ѯ�γ̱�</a></li>\r\n" + 
					"			\r\n" + 
					"					<li class=\"active\"><a href=\"createreport.jsp\">���ɳɼ���</a></li>\r\n" + 
					"					<li><a href=\"querystudentcredit.jsp\">�鿴��Ӧ�γ�ѧ���ɼ���</a></li>\r\n" + 
					"					<li><a href=\"/system/exit\">�˳���¼</a></li>\r\n" + 
					"				</ul>\r\n" + 
					"	</div>\r\n" + 
					"	</div>\r\n" + 
					"</nav>");
			out.println("<div class=\"container\" style=\"text-align:center\">");
			out.println("<h2>����ɹ�!</h2>");
			out.println("<a href=/system/createreport.jsp>�������ĳɼ�</a>");
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
					"<title>��ѯ�γ�ʧ��</title>\r\n" + 
					"</head>");
			out.println("<nav class=\"navbar navbar-default\" role=\"navigation\">\r\n" + 
					"	<div class=\"container-fluid\">\r\n" + 
					"	<div class=\"navbar-header\">\r\n" + 
					"		<a class=\"navbar-brand\" href=\"#\">ѧ����Ϣ����ϵͳ</a>\r\n" + 
					"	</div>\r\n" + 
					"	<div>\r\n" + 
					"		<ul class=\"nav navbar-nav\">\r\n" + 
					"		<li><a href=\"teacher_index.jsp\">��ҳ</a></li>\r\n" + 
					"			<li><a href=\"/system/displaycourse\">��ѯ�γ̱�</a></li>\r\n" + 
					"			\r\n" + 
					"					<li class=\"active\"><a href=\"createreport.jsp\">���ɳɼ���</a></li>\r\n" + 
					"					<li><a href=\"querystudentcredit.jsp\">�鿴��Ӧ�γ�ѧ���ɼ���</a></li>\r\n" + 
					"					<li><a href=\"/system/exit\">�˳���¼</a></li>\r\n" + 
					"				</ul>\r\n" + 
					"			</li>\r\n" + 
					"		</ul>\r\n" + 
					"	</div>\r\n" + 
					"	</div>\r\n" + 
					"</nav>");
			out.println("<div class=\"container\" style=\"text-align:center\">");
			out.println("<h2>����ʧ��,ѧ���ɼ��Ѿ����������߸�ѧ��������!</h2>");
			out.println("<a href=/system/createreport.jsp><h2>��������!</h2></a>");
			out.println("</div>");
			out.println("</body></html>");
		}
		catch(IOException e) {
			
		}
	}

}
