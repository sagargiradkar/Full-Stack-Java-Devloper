package in.ineuron.main;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import in.ineuron.util.JdbcUtil;

public class BatchUpdateUsingPreparedStatment {

    public static void main(String[] args) {
        
        // Resources used
        Connection connection = null;
        PreparedStatement pstmt = null;
        Scanner scanner = null;
    
    
        try {
            // Get the database connection
            connection = JdbcUtil.getJdbcConnection();
            
            
            String sqlInsertQuery = "insert into employees(`name`,`age`,`address`) values(?,?,?)";
            if(connection != null) {
            	pstmt = connection.prepareStatement(sqlInsertQuery);
            }
            if(pstmt!=null) {
            	scanner = new Scanner(System.in);
            	while(true) {
            		System.out.print("Enter the name :: ");
            		String name = scanner.next();
            		
            		System.out.print("Enter the age :: ");
            		Integer age = scanner.nextInt();
            		
            		System.out.print("Enter the address :: ");
            		String address = scanner.next();
            		
            		pstmt.setString(1, name);
            		pstmt.setInt(2, age);
            		pstmt.setString(3, address);
            		
            		
            		//one batch got created and query got added 
            		pstmt.addBatch();
            		
            		System.out.println("Do u want to insert one more rescord[YES\\NO]");
            		String option = scanner.next();
            		if(option.equalsIgnoreCase("no")) {
            			break;
            		}
            			
            		
            	}
            	//Exceuting the queries present in batch file
            	pstmt.executeBatch();
            	
            	System.out.println("Record inserted successfully ...");
            	
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
