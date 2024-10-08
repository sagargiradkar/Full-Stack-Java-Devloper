package in.ineuron.main;

import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

import in.ineuron.util.JdbcUtil;

public class UpdateApp {

	public static void main(String[] args) {	
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		Scanner sc = new Scanner(System.in);
		try 
		{
			
			connection = JdbcUtil.getJdbcConnection();
			
			String sqlInsertQuery = "insert into student (`ID`,`FNAME`,`LNAME`,`AGE`,`CITY`) values(?,?,?,?,?)";
			System.out.println("\nConnection Established .....\n");
			if(connection !=null)
				pstmt = connection.prepareStatement(sqlInsertQuery);
			
			if(pstmt !=null)
				//use precompiled query to set the values
            
            System.out.println("Enter the student ID ::");
            int ID = sc.nextInt();
            
            System.out.println("Enter the name of the student ::");
            String FNAME = sc.next();
//            FNAME = "'"+FNAME+"'";
            System.out.println("Enter the Lname of the student ::");
            String LNAME = sc.next();
//            LNAME = "'"+LNAME+"'";

            System.out.println("Enter the age of student ::");
            int AGE = sc.nextInt();
            
            

            System.out.println("Enter the City of the student ::");
            String CITY = sc.next();
//            CITY = "'"+CITY+"'";
				pstmt.setInt(1, ID);
				pstmt.setString(2, FNAME);
				pstmt.setString(3, LNAME);
				pstmt.setInt(4, AGE);
				pstmt.setString(5, CITY);
				
				
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


