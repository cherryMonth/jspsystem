package servlet;
import system.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;

import system.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.Enumeration;
import java.util.HashMap;

@WebServlet("/displaycourse")
public class DisplayCou extends HttpServlet{
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
			request.setCharacterEncoding("utf-8");
			HttpSession session =request.getSession();
			String type=(String) session.getAttribute("status");
			if(type==null||type.length()==0) {
				fail(request,response,"�������δѡ��!");
				return;
			}
			String id=(String) session.getAttribute("login_id");
			if(id==null||id.length()==0) {
				fail(request,response,"�û�IDδ����!");
				return;
			}
			
			String pro_no ="";
			Course c =new Course();
			Tableinfo t = new Tableinfo();
			Object [] o = new Object [1];
			o[0] = id;
			pro_no=(String)c.executeQuerySingle("select Pro_No from course where no=?", o);
			String sql="";
			if(type.equals("teacher"))
				sql = "select * from course where work_no = \""+id+"\";";
			else
				sql = "select * from course where pro_no = \""+pro_no+"\";";
			List <Object> list = new Test().excuteQuery(sql,null);
			if(list.size()==0) {
				fail(request,response,"��ǰ���������!");
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
		doPost(request,response);	}
	
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
					"			<li class=\"active\"><a href=\"/system/displaycourse\">��ѯ�γ̱�</a></li>\r\n" + 
					"			\r\n" + 
					"					<li><a href=\"createreport.jsp\">���ɳɼ���</a></li>\r\n" + 
					"					<li><a href=\"querystudentcredit.jsp\">�鿴��Ӧ�γ�ѧ���ɼ���</a></li>\r\n" + 
					"					<li><a href=\"/system/exit\">�˳���¼</a></li>\r\n" + 
					"				</ul>\r\n" + 
					"	</div>\r\n" + 
					"	</div>\r\n" + 
					"</nav>");
			out.println("<div class=\"container\" style=\"text-align:center\">");
			out.println("<h2>��ǰû�������йصĿγ�!</h2>");
			out.println("<a href=/system/teacher_index.jsp><h2>�������˵�</h2></a>");
			out.println("</div>");
			out.println("</body></html>");
		}
		catch(IOException e) {
			
		}
	}
}
