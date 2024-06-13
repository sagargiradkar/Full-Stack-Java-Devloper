package in.ineuron.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import in.ineuron.util.JdbcUtil;

public class DateRetrivalApp {

	public static void main(String[] args) {
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		int id=1;
		try {
			connection = JdbcUtil.getJdbcConnection();
			
			String sqlSelectQuery = "select id,name,dob,dom from user where id = ?";
			
			if(connection !=null)
				connection.prepareStatement(sqlSelectQuery);
			
			if(pstmt != null) {
				//setting innput values
				
				pstmt.setInt(id, id);
				
				//execute the query
				
				resultSet = pstmt.executeQuery();
				
			}
			if(resultSet != null) {
				//processing the resultSet
				if(resultSet.next()) {
					System.out.printf("SID\tSNAME\tSDOB\tSDOM");
					int sid = resultSet.getInt(1);
					String sname = resultSet.getString(2);
					java.sql.Date sdob = resultSet.getDate(3);
					java.sql.Date sdom = resultSet.getDate(4);
					
					SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyy");
					
					String strDob = sdf.format(sdob);
					String strDom = sdf.format(sdom);
					
					
					
					
					System.out.println(sid+"\t"+sname+"\t"+strDob+"\t"+strDom);
					
				}else {
					System.out.println("Record not found in the database for the given id :: "+id);
				}
			}
			
		}catch(SQLException |IOException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				JdbcUtil.cleanUp(connection, pstmt, resultSet);
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		

	}

}
