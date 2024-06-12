package in.ineuron.main;

import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

import in.ineuron.util.JdbcUtil;

public class InsertAppDynamicInput {

	public static void main(String[] args) {	
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		Scanner sc = new Scanner(System.in);
		try 
		{
			
			connection = JdbcUtil.getJdbcConnection();
			
			String sqlUpdateQuery = "update student set LNAME = ? where ID = ?";
			System.out.println("\nConnection Established .....\n");
			if(connection !=null)
				pstmt = connection.prepareStatement(sqlUpdateQuery);
			
			if(pstmt !=null)
				//use precompiled query to set the values
            
				System.out.println("Enter the student ID ::");
            	int ID = sc.nextInt();
            

	            System.out.println("Enter the Lname of the student ::");
	            String LNAME = sc.next();


				pstmt.setInt(2, ID);
//				pstmt.setString(2, FNAME);
				pstmt.setString(1, LNAME);
//				pstmt.setInt(4, AGE);
//				pstmt.setString(5, CITY);
				
				
				System.out.println(sqlUpdateQuery);
				//execute the query
				int rowCount = pstmt.executeUpdate();
				System.out.println("\nNo of row updated is :: "+rowCount);
				
				
		}
		catch(IOException ie){
			ie.printStackTrace();
		}
	
		catch(SQLException se)
		{
			se.printStackTrace();
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally {
			try {
				JdbcUtil.cleanUp(connection, null, null);
				System.out.println();
				System.out.println("Closing the Resorces .........");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
    }
}


