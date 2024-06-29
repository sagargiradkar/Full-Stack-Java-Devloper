<%@ page language="java" import="java.sql.*"%>

<%!
Connection connection = null;
	PreparedStatement pstmt1 = null;
	PreparedStatement pstmt2 = null;

	public void jspInit() {
		ServletConfig config = getServletConfig();
		String url = config.getInitParameter("url");
		String user = config.getInitParameter("user");
		String password = config.getInitParameter("password");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, user, password);
			pstmt1 = connection.prepareStatement("insert into employee (ename,eaddr,esal) values(?,?,?)");
			pstmt2 = connection.prepareStatement("select eid,ename,eaddr,esal from employee");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}
%>
<%			
String action = request.getParameter("s1");
if (action.equalsIgnoreCase("register")) {
	//Take the data and insert operation
	String ename = request.getParameter("ename");
	String eaddr = request.getParameter("eaddr");
	String esal = request.getParameter("esal");

	pstmt1.setString(1, ename);
	pstmt1.setString(2, eaddr);
	pstmt1.setInt(3, Integer.parseInt(esal));

	int rowCount = pstmt1.executeUpdate();
	if (rowCount == 1)
		out.println("<h1 style='color:green;text-align:center;'>Employee Registred</h1>");
	else
		out.println("<h1 style='color:red;text-align:center;'>Employee Not Registred</h1>");

} else {
	//Get the data from db
	ResultSet resultSet = pstmt2.executeQuery();
	out.println("<table border='1' bgcolor='pink'>");
	out.println("<tr><th>EID</th><th>ENAME</th><th>EADDR</th><th>ESAL</th></tr>");
	while (resultSet.next()) {
		out.println(resultSet.getInt(1));
		out.println(resultSet.getInt(2));
		out.println(resultSet.getInt(3));
		out.println(resultSet.getInt(4));

	}
	out.println("</table>");
}
%>
<br />
<br />
<a href="./index.html">| HOME PAGE |</a>



<%!public void jspDestroy() {
		try {
			if (pstmt1 != null) {
				pstmt1.close();
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}
		try {
			if (pstmt2 != null)
				pstmt2.close();
		} catch (SQLException se) {
			se.printStackTrace();
		}
		try {
			if (connection != null)
				connection.close();
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}%>