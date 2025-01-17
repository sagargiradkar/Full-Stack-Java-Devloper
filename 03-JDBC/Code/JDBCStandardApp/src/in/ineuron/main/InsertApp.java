package in.ineuron.main;

import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

import in.ineuron.util.JdbcUtil;

public class InsertApp {

	public static void main(String[] args) {	
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try 
		{
			Scanner sc = new Scanner(System.in);
			connection = JdbcUtil.getJdbcConnection();
			if(connection !=null)
				statement = connection.createStatement();
			if(statement != null)
				resultSet = statement.executeQuery("select * from student");
			if(resultSet!=null) {
				System.out.println("ID\tFNAME\tLNAME\tAGE\tCITY");
				while(resultSet.next())
				{
					System.out.println(resultSet.getInt("ID") + "\t" + resultSet.getString("FNAME") + "\t"+resultSet.getString("LNAME")+"\t"+resultSet.getInt("AGE")+"\t"+resultSet.getString("CITY"));
				
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
				JdbcUtil.cleanUp(connection, statement, resultSet);
				System.out.println();
				System.out.println("Closing the Connection .........");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
    }
}


