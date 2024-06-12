package in.ineuron.main;

import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

import in.ineuron.util.JdbcUtil;

public class DeleteApp {

	public static void main(String[] args) {	
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		Scanner sc = new Scanner(System.in);
		try 
		{
			
			connection = JdbcUtil.getJdbcConnection();
			
			String sqlDeleteQuery = "delete from student where ID = ?";
			System.out.println("\nConnection Established .....\n");
			if(connection !=null)
				pstmt = connection.prepareStatement(sqlDeleteQuery);
			
			if(pstmt !=null)
				//use precompiled query to set the values
            
            System.out.println("Enter the student ID ::");
            int ID = sc.nextInt();
           
				pstmt.setInt(1, ID);
				
				
				
				System.out.println(sqlDeleteQuery);
				//execute the query
				int rowCount = pstmt.executeUpdate();
				System.out.println("\nNo of row deleted is :: "+rowCount);
				
				
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


