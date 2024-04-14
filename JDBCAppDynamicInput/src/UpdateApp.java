import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateApp {

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
	            
	            Scanner scanner = new Scanner(System.in);
	            System.out.print("Enter Id :: ");
	            int tId = scanner.nextInt();
	            
	            System.out.print("Enter Name of Student :: ");
	            String tName = scanner.next();
	            
	            System.out.print("Enter Name of City :: ");
	            String tCity = scanner.next();
	            
	            String sqlUpdateQuery = "update my_table set tCity='"+tCity+"' where tId ="+tId+"" ;
	            System.out.println(sqlUpdateQuery);
	            int rowAffected = statement.executeUpdate(sqlUpdateQuery);
	            System.out.println("No of rows affedted is : :"+rowAffected);
	            
	            statement.close();
	            connection.close();
	            System.out.println("closing the resources ..");
	            

	    }

}
