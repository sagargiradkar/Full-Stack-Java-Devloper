package in.ineuron.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jakarta.servlet.ServletConfig;

public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		System.out.println("");
		ServletConfig config = getServletConfig();
		ServletContext context = getServletContext();
		System.out.println(config.getClass().getName());
		
		System.out.println(context.getClass().getName());
		
		System.out.println(request.getClass().getName());
		
		System.out.println(response.getClass().getName());
		
	
	}

}
