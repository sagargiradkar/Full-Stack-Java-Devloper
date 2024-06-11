import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertApp {

	public static void main(String[] args) {
	
		Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
          
            // Step 2. Establish the Connection with database
            String url = "jdbc:mysql:///ineuron";
            String userName = "root";
            String password = "9402";
            connection = DriverManager.getConnection(url, userName, password);

            System.out.println("The implementation class name is :: " + connection.getClass().getName());

            // Step 3. Create statement object and send the query
        
            statement = connection.createStatement();
            
            String sqlInsertQuery = "insert into student(`id`,`FNAME`,`LNAME`,`AGE`,`CITY`) values(20,'PRAKAS','Giradkar',50,'BHANDAR')";
            
            int rowAffected = statement.executeUpdate(sqlInsertQuery);
            

            // Step 4. Process the ResultSet
            System.out.println("No of rows affected is :: "+rowAffected);
            
            System.out.println("Closing a connection ......");
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close resources in reverse order of their opening
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
	}


