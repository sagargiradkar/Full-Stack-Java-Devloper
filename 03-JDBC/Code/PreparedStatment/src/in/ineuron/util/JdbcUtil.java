package in.ineuron.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;

public class JdbcUtil {
	
	
	private JdbcUtil() {}
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch(ClassNotFoundException ce)
		{
			ce.printStackTrace();
		}
	}

	public static Connection getJdbcConnection() throws SQLException, IOException
	{
		FileInputStream fis = new FileInputStream("C:\\Users\\sagar\\Documents\\full-stack-java-devloper1\\03-JDBC\\PreparedStatment\\src\\in\\ineuron\\application\\application.properties");
		
		Properties properties = new Properties();
		
		properties.load(fis);
		
		Connection connection = null;
		// Step 2. Establish the Connection with database
        connection = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("user"), properties.getProperty("password"));

       // System.out.println("The implementation class name is :: " + connection.getClass().getName());
        System.out.println("Connection object created ....");
        
        return connection;
	}
	
	public static void cleanUp(Connection con,Statement statment,ResultSet resultSet) throws SQLException
	{
		if(con!=null) con.close();
		if(statment!=null) statment.close();
		if(resultSet!=null) resultSet.close();
	}
}
