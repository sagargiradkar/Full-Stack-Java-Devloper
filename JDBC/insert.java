import java.sql.*;

public class insert {
    public static void main(String[] args) {
        Connection con = null;
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

            // Set parameter values
            pstm.setString(1, "Sagar Giradkar");
            pstm.setString(2, "Bhandara");

            // Execute the query
            pstm.executeUpdate();

            System.out.println("Inserted...");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
