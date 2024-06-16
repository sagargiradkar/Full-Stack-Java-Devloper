package in.ineuron.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.Scanner;

import in.ineuron.util.JdbcUtil;

public class DeleteApp {

	public static void main(String[] args)  {
		
		//Resource used
		Connection connection = null;
		Statement stmt = null;
		ResultSet resultSet = null;
		try {
			connection = JdbcUtil.getJdbcConnection();
			
			if(connection != null)
				//Expecting ResultSet to be SCROLLABLE AND UPDATABLE
				stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);

			String sqlQuery = "select * from employees";
			
			if(stmt!=null)
				resultSet = stmt.executeQuery(sqlQuery);
			
			if(resultSet != null) {
				System.out.println("Records Before Deletion .....");
				System.out.println("ID\tNAME\tAGE\tADDRESS");
				while(resultSet.next()) {
					System.out.println(resultSet.getInt(1)+"\t"+resultSet.getString(2)+"\t"+resultSet.getInt(3)+"\t"+resultSet.getString(4));
				}
				System.out.println();
				
				//performing delete operation using resultSet
				resultSet.last();
				
				resultSet.deleteRow();//performing deletion operation
				
				resultSet.beforeFirst();
				System.out.println("Records after Deletinon .....");
				System.out.println("ID\tNAME\tAGE\tADDRESS");
				while(resultSet.next()) {
					System.out.println(resultSet.getInt(1)+"\t"+resultSet.getString(2)+"\t"+resultSet.getInt(3)+"\t"+resultSet.getString(4));
				}
				System.out.println();
				
				
			}
			
			
		}
		catch(SQLException |IOException e) {
			e.printStackTrace();
	
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				JdbcUtil.cleanUp(connection, stmt, null);
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
		}
		
	}

}
