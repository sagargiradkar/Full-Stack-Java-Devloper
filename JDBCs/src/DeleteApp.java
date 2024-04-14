import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteApp {

	 public static void main(String[] args) throws SQLException {
	       
	  
	            // Establish the connection with database
	            String url = "jdbc:mysql:///sagar";
	            String userName = "root";
	            String password = "9402";
	            Connection connection = DriverManager.getConnection(url, userName, password);
	            System.out.println("Connection established successfully .....");

	            // Create statement object and send the query
	            Statement statement = connection.createStatement();
	            System.out.println("Connection Created successfully");
	            
	         
//	            String sqlDeleteQuery = "delete from my_table where tId = 1";
//	            int rowAffected = statement.executeUpdate(sqlDeleteQuery);
//	            System.out.println("No of rows affedted is : :"+rowAffected);
	            
	            String sqlDeleteQuery = "delete from my_table where tId = 1";
	            int rowAffected = statement.executeUpdate(sqlDeleteQuery);
	            System.out.println("No of rows affedted is : :"+rowAffected);
	            
	            statement.close();
	            connection.close();
	            System.out.println("closing the resources ..");
	            

	    }

}
