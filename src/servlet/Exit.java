package servlet;
import system.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import javax.servlet.*;
import java.util.Enumeration;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/exit")
public class Exit extends HttpServlet{
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();
		String id=(String)session.getAttribute("login_id");
		session.removeAttribute(id);
		response.sendRedirect("login.jsp");
	}

	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		doPost(request,response);
	}
}
