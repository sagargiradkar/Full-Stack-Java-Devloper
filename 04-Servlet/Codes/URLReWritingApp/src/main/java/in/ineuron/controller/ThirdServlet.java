package in.ineuron.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/third  ")
public class ThirdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("deprecation")
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String depName = request.getParameter("depName");
		String depAmount = request.getParameter("depAmount");
	
		
		HttpSession session = request.getSession(false);
		session.setAttribute("depName", depName);
		session.setAttribute("depAmount", depAmount);
		
		PrintWriter out = response.getWriter();
	
		out.println("<html><head><title>Deposit Form</title><head>");
		
		out.println("<body bgcolor='cyan'>");
		out.println("<center>");
		
		out.println("<h1 style='color:red;'>Detailes About Transaction...... </h1>");
		out.println("<table>");
		
		out.println("<tr><th>NAME</th<th>VALUE</th</tr>");
		Enumeration<String> attributeNames = session.getAttributeNames();
		while(attributeNames.hasMoreElements()) {
			String attributeName = (String)attributeNames.nextElement();
			Object attributeValue = session.getAttribute(attributeName);
			out.println("<tr>");
			out.println("<td>"+attributeName+"</td>");
			out.println("<td>"+attributeValue+"</td>");
			out.println("</tr>");
			
		}
		
		
		
		out.println("</table>");
		
		out.println("<center>");
		out.println("<body>");
		out.println("<html>");
		
		out.close(); 
	
	}

}
