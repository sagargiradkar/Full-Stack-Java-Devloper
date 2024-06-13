package in.ineuron.main;

import java.io.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import in.ineuron.util.JdbcUtil;

public class BlobInsertionApp {

	public static void main(String[] args) throws ParseException  {
		
		//Resource used
		Connection connection = null;
		PreparedStatement pstmt = null;
		Scanner sc = null;
	
		String name = null;
		String imageLocation = null;
	
		
		try {
			
			connection = JdbcUtil.getJdbcConnection();
			String sqlInsertQuery="insert into person(`id`,`name`,`image`) values(?,?,?)";
			if(connection !=null)
				connection.prepareStatement(sqlInsertQuery);
			
			if(pstmt !=null) {
				
				 sc = new Scanner(System.in);
				if(sc != null) {
					System.out.print("Enter the username :: ");
					name = sc.next();
					
					System.out.println("Enter the image location :: ");
					imageLocation = sc.next();
					
				}
				
				//set the input values to query  
				pstmt.setString(1, name);
				pstmt.setBinaryStream(2, new FileInputStream(new File(imageLocation)));
				
				
				//Excecute the query
				int rowAffected = pstmt.executeUpdate();
				System.out.println("No of rows inserted is ::"+rowAffected);
			}
		}
		catch(SQLException |IOException e) {
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
