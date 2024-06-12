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
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement pstmt = null;
		
		String name = null;
		String dob = null;
		java.sql.Date sqlDob = null;
		Scanner sc = null;
		 sc = new Scanner(System.in);
		try {
			
			connection = JdbcUtil.getJdbcConnection();
			String sqlInsertQuery="insert into user(`id`,`name`,`dob`) values(?,?,?)";
			if(connection !=null)
				connection.prepareStatement(sqlInsertQuery);
			
			if(pstmt !=null) {
				
				if(sc !=null) {
					System.out.print("Enter the username :: ");
					name = sc.next();
					
					System.out.println("Enter the dob (MM-dd-yyy) :: ");
					dob = sc.next();
					
				}
				if(dob!=null)
				{
					SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyy");
					
					java.util.Date uDate = sdf.parse(dob);
					
					long value = uDate.getTime();
					 sqlDob = new java.sql.Date(value);
				}
				
			//set the values 
				
				pstmt.setString(1, name);
				pstmt.setDate(2,sqlDob );
				
				
				int rowAffected = pstmt.executeUpdate();
				System.out.println("No of rows inserted is ::"+rowAffected);
			}
		}
		catch(SQLException |IOException e) {
			e.printStackTrace();
		}catch(ParseException pe) {
			pe.printStackTrace();
		}catch(Exception ew) {
			ew.printStackTrace();
		}finally {
			try {
				JdbcUtil.cleanUp(connection, pstmt, null);
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
		}
		
	}

}
