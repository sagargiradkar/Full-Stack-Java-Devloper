package in.ineuron.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestApp {

	private static final String EXCEL_FILE = "select * from data.student ";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "jdbc:Excel:///{location of ecel sheet file }";
		
		try(Connection connection = DriverManager.getConnection(url)){
			try(PreparedStatement pstmt = connection.prepareStatement(EXCEL_FILE)){
				try(ResultSet resultSet = pstmt.executeQuery()){
					while(resultSet.next()) {
						System.out.println(
								resultSet.getInt(1)+"\t"+resultSet.getString(2)+"\t"+
						resultSet.getString(3));
					}
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
