package in.ineuron.bean;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test")
public class TestApp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) throws ServletException, IOException {
		
		extracted(response);
		String sname = "sachin";
		String age = "45";
		String address = "MI";
		System.out.println(sname+age+address);
		
	}

	private void extracted(jakarta.servlet.http.HttpServletResponse response) throws IOException {
		PrintWriter writer = response.getWriter();
		writer.println("<html><head><title> DISP</title></head>");
		writer.close();
	}

}
