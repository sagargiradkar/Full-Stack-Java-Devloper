package in.ineuron.main;

import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

import in.ineuron.util.JdbcUtil;

public class InsertApp {

	public static void main(String[] args) {	
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		try 
		{
			Scanner sc = new Scanner(System.in);
			connection = JdbcUtil.getJdbcConnection();
			
			String sqlInsertQuery = "insert into student (`ID`,`FNAME`,`LNAME`,`AGE`,`CITY`) values(?,?,?,?,?)";
			System.out.println("\nConnection Established .....\n");
			if(connection !=null)
				pstmt = connection.prepareStatement(sqlInsertQuery);
			
			if(pstmt !=null)
				//use precompiled query to set the values
				pstmt.setInt(1, 757);
				pstmt.setString(2, "LALITA");
				pstmt.setString(3, "CHANDEWAR");
				pstmt.setInt(4, 20);
				pstmt.setString(5, "CHANDRAPUR");
				
				
				System.out.println(sqlInsertQuery);
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


