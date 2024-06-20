package in.ineuron.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet1")
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Controll in servlet 1 ");
		
		request.setAttribute("Sagar","JAVA");
		request.setAttribute("Navin","Telusko");
		request.setAttribute("Nitin","API");
	RequestDispatcher requestDispatcher = request.getRequestDispatcher("/servlet2");
	requestDispatcher.forward(request,response);
	
	}

}
