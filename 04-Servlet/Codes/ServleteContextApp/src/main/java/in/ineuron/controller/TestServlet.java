package in.ineuron.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jakarta.servlet.ServletContext;


public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
	@Override
	public void doGet(HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>OUTPUT</title></head>");
		out.println("<body");
		out.println("<center>");
		out.println("<h1 style='color:green'>CONTEXT PARAMETER INFORMATION </h1>");
		out.println("<table border=1>");
		out.println("<tr><th>Context Parameter NAme</th><th>Context Parameter Value</th></tr>");
		
		
		ServletContext context = getServletContext();
		Enumeration<String> parameterNames = context.getInitParameterNames();
		while(parameterNames.hasMoreElements()) {
			String parameterName =(String) parameterNames.nextElement();
			String parameterValue = context.getInitParameter(parameterName);\
			out.println("<tr>");
			out.println("<td>"+parameterName+"</td>");
			out.println("<td>"+parameterValue+"</td>");
			out.println("</tr>");
		}
		 
		
		out.println("</table>");
		out.println("<center>");
		out.println("</body>");
		out.println("</html>");

		out.close();
	}

}
