import java.sql.*;

class Test {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Step 1. Load and register the Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded successfully ...");

            // Step 2. Establish the Connection with database
            String url = "jdbc:mysql:///ineuron";
            String userName = "root";
            String password = "9402";
            connection = DriverManager.getConnection(url, userName, password);

            System.out.println("The implementation class name is :: " + connection.getClass().getName());

            // Step 3. Create statement object and send the query
            String sqlSelectQuery = "SELECT ID, FNAME,LNAME,AGE,CITY FROM student";
           // String sqlSelectQuery = "SELECT * FROM student";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sqlSelectQuery);

            // Step 4. Process the ResultSet
            while (resultSet.next()) {
                Integer id = resultSet.getInt("ID");
                String firstName = resultSet.getString("FNAME");
                String lastName = resultSet.getString("LNAME");
                Integer age = resultSet.getInt("AGE");
                String city = resultSet.getString("CITY");
                System.out.println(id + "\t" + firstName + "\t"+lastName+"\t"+age+"\t"+city);
            }
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
