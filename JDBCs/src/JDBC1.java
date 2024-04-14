import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC1 {

	 public static void main(String[] args) {
	        Connection connection = null;
	        Statement statement = null;
	        ResultSet resultSet = null;
	        try {
	            // Load and register the Driver
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            System.out.println("Driver loaded successfully....");

	            // Establish the connection with database
	            String url = "jdbc:mysql:///sagar";
	            String userName = "root";
	            String password = "9402";
	            connection = DriverManager.getConnection(url, userName, password);
	            System.out.println("Connection established successfully .....");
	            System.out.println("The implement class name is " + connection.getClass().getName());

	            // Create statement object and send the query
	            String sqlSelectQuery = "select * from my_table";
	            statement = connection.createStatement();
	            resultSet = statement.executeQuery(sqlSelectQuery);

	            System.out.println("");
	            // Process the ResultSet here if needed
	            while (resultSet.next()) {
	                Integer tId = resultSet.getInt(1);
	                String tName = resultSet.getString(2);
	                String tCity = resultSet.getString(3);

	                System.out.println(tId + "\t" + tName + "\t" + tCity);
	            }
	        } catch (ClassNotFoundException ce) {
	            ce.printStackTrace();
	        } catch (SQLException se) {
	            se.printStackTrace();
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            if (connection != null) {
	                try {
	                    connection.close();
	                    System.out.println("Connection colsed ........");
	                } catch (SQLException se) {
	                    se.printStackTrace();
	                }
	            }
	        }

	    }

}
