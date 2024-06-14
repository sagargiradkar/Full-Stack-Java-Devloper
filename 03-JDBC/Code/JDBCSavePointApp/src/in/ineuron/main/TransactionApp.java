package in.ineuron.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.Scanner;

import in.ineuron.util.JdbcUtil;

public class TransactionApp {

	public static void main(String[] args)  {
		
		//Resource used
		Connection connection = null;
		Statement stmt = null;

		try {
			connection = JdbcUtil.getJdbcConnection();
			
			if(connection != null)
			{
				stmt = connection.createStatement();
				
			}
			
			System.out.println("Transaction Begins .....");
			connection.setAutoCommit(false);
			stmt.executeUpdate("insert into politicians(`name`,`party`) values('MODI','BJP')");
			
			stmt.executeUpdate("insert into politicians(`name`,`party`) values('KCR','TRS')");
			
			Savepoint sp = connection.setSavepoint();
			stmt.executeUpdate("insert into politicians(`name`,`party`) values('siddhu','BJP')");
			connection.rollback(sp);
			
			System.out.println("Operation are rolled back to savepoint ....");
			connection.commit();
			
			
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
