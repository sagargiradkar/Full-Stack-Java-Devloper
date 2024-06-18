 package in.ineuron.controller;

import java.io.File;
import java.io.IOException;

import javax.imageio.stream.FileImageInputStream;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/test")
public class ResponseHeaderApp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	response.setContentType("image/png");
	
	File file = new File("C:\\Users\\sagar\\Documents\\full-stack-java-devloper1\\04-Servlet\\Codes\\ResponseHeaderApp\\1.png");
	FileImageInputStream fis =  new FileImageInputStream(file);	
	
	byte[] b = new byte[(int) file.length()];
	fis.read(b);
	
	ServletOutputStream stream = response.getOutputStream();
	stream.write(b);
	stream.flush();
	stream.close();
	fis.close();
	}

}
