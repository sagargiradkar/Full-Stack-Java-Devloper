package in.ineuron.main;

import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

import in.ineuron.util.JdbcUtil;

public class SelectApp {

	public static void main(String[] args) {	
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		Scanner sc = new Scanner(System.in);
		try 
		{
			
			connection = JdbcUtil.getJdbcConnection();
			
			String sqlSelectQuery = "select ID,FNAME,LNAME,AGE,CITY from student where ID = ?";
			System.out.println("\nConnection Established .....\n");
			if(connection !=null)
				pstmt = connection.prepareStatement(sqlSelectQuery);
			
			if(pstmt !=null)
				//use precompiled query to set the values
				
				System.out.println("Enter the value of id :: ");
				int sid = sc.nextInt();
				pstmt.setInt(1, sid);
	
				System.out.println(sqlSelectQuery);
				//execute the query
				resultSet = pstmt.executeQuery();
			if(resultSet!=null)
			{
				if(resultSet.next()){
					System.out.println("ID\tFNAME\tLNAME\tAGE\tCITY");
					System.out.println(resultSet.getInt(1)+"\t"+resultSet.getString(2)+"\t"+resultSet.getString(3)+"\t"+resultSet.getInt(4)+"\t"+resultSet.getString(5));
				}else {
					System.out.println("Record not available for the given id :: "+sid);
				}
			}
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
				JdbcUtil.cleanUp(connection, pstmt, resultSet);
				System.out.println();
				System.out.println("Closing the Resorces .........");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
    }
}


