import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
            
            String sqlDeleteQuery = "delete from student where ID = 2";
            
            int rowAffected = statement.executeUpdate(sqlDeleteQuery);
            

            // Step 4. Process the ResultSet
            System.out.println("No of rowa affected is :: "+rowAffected);
            
            System.out.println("Closing a connection ......");
        } catch (ClassNotFoundException ce) {
            ce.printStackTrace();
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

