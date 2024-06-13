package in.ineuron.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import in.ineuron.util.JdbcUtil;

public class DateInsertionApp {

	public static void main(String[] args)  {
		
		//Resource used
		Connection connection = null;
		PreparedStatement pstmt = null;
		Scanner sc = null;
		
		
		//variable used
		java.sql.Date sqlDob = null;
		java.sql.Date sqlDom = null;
		 
		String name = null;
		String dob = null;
		String dom = null;
		
		try {
			
			connection = JdbcUtil.getJdbcConnection();
			String sqlInsertQuery="insert into user(`id`,`name`,`dob`,`dom`) values(?,?,?,?)";
			if(connection !=null)
				connection.prepareStatement(sqlInsertQuery);
			
			if(pstmt !=null) {
				
				 sc = new Scanner(System.in);
				if(sc != null) {
					System.out.print("Enter the username :: ");
					name = sc.next();
					
					System.out.println("Enter the dob (MM-dd-yyy) :: ");
					dob = sc.next();
					
					System.out.println("Enter the dom(yyy-MM-dd :: ");
					dom = sc.next();
					
				}
				if(dob != null)
				{
					//Conversion of string to sql Date
					SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyy");
					java.util.Date uDate = sdf.parse(dob);
					
					long value = uDate.getTime();
					 sqlDob = new java.sql.Date(value);
				}
				
				if(dom != null) {
					sqlDom = java.sql.Date.valueOf(dom);
				}
				//set the input values to query  
				pstmt.setString(1, name);
				pstmt.setDate(2,sqlDob );
				pstmt.setDate(3,sqlDom );
				
				//Excecute the query
				int rowAffected = pstmt.executeUpdate();
				System.out.println("No of rows inserted is ::"+rowAffected);
			}
		}
		catch(SQLException |IOException e) {
			e.printStackTrace();
		}catch(ParseException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				JdbcUtil.cleanUp(connection, pstmt, null);
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
		}
		
	}

}
