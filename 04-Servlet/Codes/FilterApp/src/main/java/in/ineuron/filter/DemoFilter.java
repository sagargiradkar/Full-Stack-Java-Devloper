package in.ineuron.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpFilter;


public class DemoFilter extends HttpFilter implements Filter {
       
	static {
		System.out.println("Demofilter .class file is loading");
	}

	public DemoFilter() {
		System.out.println("Demofilter Object file is loading");

	}
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("Demofilter initialize .....");

	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		PrintWriter out = response.getWriter();
		out.println("<h1>This line is added by DemoFilter Befor processing the request ......</h1>");
		
		
		chain.doFilter(request, response);
		
		out.println("<h1>This line is added by Demofilter after processing the request ......</h1>");
	}

	public void destroy() {
		System.out.println("Demofilter Deinstanatiation");

	 }


}
