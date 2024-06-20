package in.ineuron.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;


@WebServlet("/test")
public class TestApp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(jakarta.servlet.http.HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Controll in servlet 1");
		
		String userName = request.getParameter("userName");
		String userPass = request.getParameter("userPass");
		
		System.out.println("userNeme :: "+userName+"userPass :: "+userPass);
		
		if(userName.equals("sagar")&& userPass.equals("javaDev")) {
			RequestDispatcher requestDisp = request.getRequestDispatcher("/home.jsp");
		}else {
			ServletContext servletContext = request.getServletContext();
			RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/error.jsp");
			
			requestDispatcher.forward(request, response);
			
		}
	}

}
