package in.ineuron.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TragetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	static{
		System.out.println("Target Servlet .class file is loading ....");
	}
	public TragetServlet(){
		
	}
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
		PrintWriter out = response.getWriter();
		
		
		out.println("<h1>This is Target Servlet...</h1>");
	}

}
