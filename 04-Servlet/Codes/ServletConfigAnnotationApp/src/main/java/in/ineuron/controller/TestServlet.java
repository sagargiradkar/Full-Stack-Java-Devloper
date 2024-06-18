package in.ineuron.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/test" }, initParams = { @WebInitParam(name = "url", value = "jdbc:mysql:///ineuron"),
		@WebInitParam(name = "user", value = "root"),
		@WebInitParam(name = "password", value = "9402") }, loadOnStartup = 10)
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection = null;
	private PreparedStatement pstmt = null;

	static {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded successfully...");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void init() throws ServletException {
		String jdbcUrl = getInitParameter("url");
		String user = getInitParameter("user");
		String password = getInitParameter("password");
		try {
			connection = DriverManager.getConnection(jdbcUrl, user, password);
			System.out.println("Connection Establised Successfully .....");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void doPost(jakarta.servlet.http.HttpServletRequest request,
			jakarta.servlet.http.HttpServletResponse response) throws ServletException, IOException {

//		PrintWriter out = response.getWriter();
//		out.println()
		String username = request.getParameter("username");
		String userage = request.getParameter("usrage");
		String useraddr = request.getParameter("useraddr");

		String sqlInsertQuery = "insert into student (name,age,address) values(?,?,?)";
		try {
			if (connection != null)
				pstmt = connection.prepareStatement(sqlInsertQuery);
			if (pstmt != null) {
				pstmt.setString(1, username);
				pstmt.setInt(2, Integer.parseInt(userage));
				pstmt.setString(3, useraddr);
			}
			if (pstmt != null) {
				int rowAffected = pstmt.executeUpdate();
				PrintWriter out = null;
				out = response.getWriter();
				if (rowAffected == 1) {
					out.println("<h1 style='color:green;text-align:center;'>REGISTRATION SUCCESSFULL  </h1>");

				} else {

					out.println(
							"<h1 style='color:green;text-align:center;'>REGISTRATION FAILLED PLEASE TRY AGAIAN WITH THE FOLLOWING LINK</h1>");
					out.println("<ahref='./result.html'>|REGISTRATION|</a>");
				}
				out.close();

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void destroy() {
		if (connection != null) {
			try {
				connection.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
