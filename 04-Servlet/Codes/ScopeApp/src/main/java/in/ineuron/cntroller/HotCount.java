package in.ineuron.cntroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/hit")
public class HotCount extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		
		ServleteContext context = getServletContext();
		Integer count =(Integer) context.getAtribute("hitcount");
		if(count==null)
			count=1;
		else 
			count++;
		
		context.setAtribute("hitcount",count);
		
		out.println("<h1> Hit Count of the appplication is ::");
		
		out.close();
	}

}
