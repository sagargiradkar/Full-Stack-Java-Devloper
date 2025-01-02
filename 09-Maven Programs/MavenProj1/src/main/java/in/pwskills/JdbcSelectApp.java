package in.pwskills;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcSelectApp {

    public static void main(String[] args) {
        // Database connection details
        String url = "jdbc:mysql://localhost:3306/ineuron"; // Change port if necessary
        String username = "root"; // Replace with your MySQL username
        String password = "root"; // Replace with your MySQL password

        // SQL query to execute
        String query = "SELECT * FROM employee";

        // Establish connection and execute query
        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            System.out.println("Connected to the database successfully!");
            System.out.println("Employee Details:");

            // Process the result set
            System.out.printf("%-5s %-15s %-20s %-5s%n", "EID", "ENAME", "EADDRESS", "EAGE");
            System.out.println("-------------------------------------------------------");
            while (resultSet.next()) {
                int eid = resultSet.getInt("eid");
                String ename = resultSet.getString("ename");
                String eaddress = resultSet.getString("eaddress");
                int eage = resultSet.getInt("eage");
                System.out.printf("%-5d %-15s %-20s %-5d%n", eid, ename, eaddress, eage);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
