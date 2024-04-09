import java.sql.*;

class InsertJDBC {
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
            String sql = "CREATE TABLE IF NOT EXISTS my_table (tId INT(20) PRIMARY KEY AUTO_INCREMENT, tName VARCHAR(200) NOT NULL, tCity VARCHAR(400))";

            // Create a Statement
            Statement stmt = con.createStatement();
            stmt.executeUpdate(sql);

            System.out.println("Table created in database..");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
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
