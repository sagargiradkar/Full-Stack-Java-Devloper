import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;

public class imageSave {

    public static void main(String[] args) {
        Connection con = null;
        FileInputStream fis = null;
        try {
            // Load driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Create connection
            String url = "jdbc:mysql://localhost:3306/sagar?useSSL=false";
            String username = "root";
            String password = "9402";
            con = DriverManager.getConnection(url, username, password);

            // Create a query
            String sql = "INSERT INTO images (pic) VALUES (?)";

            // Create PreparedStatement
            PreparedStatement pstm = con.prepareStatement(sql);

            // Read user input

            // Set parameter values
            // pstm.setString(1, name);
            fis = new FileInputStream("image.png");
            pstm.setBinaryStream(1, fis, fis.available());

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
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException | SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
