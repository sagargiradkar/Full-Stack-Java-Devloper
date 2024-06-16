package in.ineuron.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertExcel {

	private static final String EXCEL_FILE = "insert into data.student values(?,?,?)";
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "jdbc:Excel:///{location of ecel sheet file }";
		String name = null , address = null;
		Integer id = null;
		Scanner sc = null;
		try {
			sc = new Scanner(System.in);
			if(sc !=null) {
				System.out.println("Enter the name :: ");
				name = sc.next();
				System.out.println("Enter the address :: ");
				address = sc.next();
				System.out.println("Enter the id :: ");
				id = sc.nextInt();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(sc!=null) {
				sc.close();
			}
		}
		try(Connection connection = DriverManager.getConnection(url)){
			try(PreparedStatement pstmt = connection.prepareStatement(EXCEL_FILE)){
				pstmt.setInt(1, id);
				pstmt.setString(2, name);
				pstmt.setString(3, address);
				
				int count = pstmt.executeUpdate();
				
				if(count == 0) {
					System.out.println("Record not inserted .....");
				}else {
					System.out.println("Record Inserted Succesfull ...");
				}
				}
			}
		catch(SQLException se){
			se.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	

}
