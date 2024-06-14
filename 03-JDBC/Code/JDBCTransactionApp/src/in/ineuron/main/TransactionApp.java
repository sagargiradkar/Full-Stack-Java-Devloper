package in.ineuron.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import in.ineuron.util.JdbcUtil;

public class TransactionApp {

	public static void main(String[] args)  {
		
		//Resource used
		Connection connection = null;
		Statement stmt = null;
		ResultSet resultSet = null;
		Scanner sc = null;

		try {
			connection = JdbcUtil.getJdbcConnection();
			
			if(connection !=null)
				stmt = connection.createStatement();
			
			if(stmt != null)
			{
				resultSet = stmt.executeQuery("select name,balance from accounts");
			}
			System.out.println("<<<<<<<<<<<< Balance before Transaction >>>>>>>>>>");

			if(resultSet != null) {
				System.out.println("NAME\tBALANCE");
				while(resultSet.next()) {
					System.out.println(resultSet.getString(1)+"\t"+resultSet.getInt(2));
				}
			}
			
			
			//Transaction begins
			System.out.println("\n Transactions Begins ....");
			connection.setAutoCommit(false);
			
			//Prepare the operation as a single unit
			stmt.executeUpdate("update accounts set balance = balance - 5000 where name = 'sachi'");
			stmt.executeUpdate("update accounts set balance = balance + 5000 where name = 'dhoni'");
			
			System.out.println("Can you please confirm the transaction of 5000INR ...[YES/NO]");
			sc = new Scanner(System.in);
			String option = sc.next();
			if(option.equalsIgnoreCase("yes")) {
				connection.commit();
			}else {
				connection.rollback();
			}
			
			System.out.println("<<<<<<<<<<<< Balance after Transaction >>>>>>>>>>");
			ResultSet rs = stmt.executeQuery("select name,balance from accounts");
			if(resultSet != null) {
				System.out.println("NAME\tBALANCE");
				while(rs.next()) {
					System.out.println(rs.getString(1)+"\t"+rs.getInt(2));
				}
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
