import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class dynamicInsert {
    public static void main(String[] args) {
        Connection con = null;
        BufferedReader br = null;
        try {
            // Load driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Create connection
            String url = "jdbc:mysql://localhost:3306/sagar?useSSL=false";
            String username = "root";
            String password = "9402";
            con = DriverManager.getConnection(url, username, password);

            // Create a query
            String sql = "INSERT INTO my_table (tName, tCity) VALUES (?, ?)";

            // Create PreparedStatement
            PreparedStatement pstm = con.prepareStatement(sql);

            // Read user input
            br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter name:");
            String name = br.readLine();

            System.out.println("Enter city:");
            String city = br.readLine();

            // Set parameter values
            pstm.setString(1, name);
            pstm.setString(2, city);

            // Execute the query
            int rowsAffected = pstm.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Data inserted successfully.");
            } else {
                System.out.println("Failed to insert data.");
            }
        } catch (ClassNotFoundException | SQLException | IOException e) {
            e.printStackTrace();
            System.out.println("Error occurred while inserting data.");
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
                if (br != null) {
                    br.close();
                }
            } catch (IOException | SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
