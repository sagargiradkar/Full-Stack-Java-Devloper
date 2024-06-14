package in.ineuron.main;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import in.ineuron.util.JdbcUtil;

public class ClobInsertionApp {

    public static void main(String[] args) {
        
        // Resources used
        Connection connection = null;
        PreparedStatement pstmt = null;
        Scanner sc = null;
    
        String name = null;
        String pdfLocation = null;
    
        try {
            // Get the database connection
            connection = JdbcUtil.getJdbcConnection();
            String sqlInsertQuery = "INSERT INTO cities(name, history) VALUES(?, ?)";
            
            if (connection != null)
                pstmt = connection.prepareStatement(sqlInsertQuery);
            
            if (pstmt != null) {
                sc = new Scanner(System.in);
                
                if (sc != null) {
                    System.out.print("Enter the city name: ");
                    name = sc.nextLine();
                    
                    System.out.print("Enter the path to the PDF file: ");
                    pdfLocation = sc.nextLine();
                }
                
                // Set the input values to the query
                pstmt.setString(1, name);
                File file = new File(pdfLocation);
                
                if (file.exists() && file.isFile()) {
                    pstmt.setCharacterStream(2, new FileReader(file));
                    
                    // Execute the query
                    int rowsAffected = pstmt.executeUpdate();
                    System.out.println("Number of rows inserted: " + rowsAffected);
                } else {
                    System.out.println("The provided file path does not exist or is not a file.");
                }
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                JdbcUtil.cleanUp(connection, pstmt, null);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
