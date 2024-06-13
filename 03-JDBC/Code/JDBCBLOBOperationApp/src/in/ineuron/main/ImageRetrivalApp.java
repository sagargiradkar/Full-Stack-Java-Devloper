package in.ineuron.main;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.ineuron.util.JdbcUtil;

public class ImageRetrivalApp {

	public static void main(String[] args) {
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		int id=1;
		try {
			connection = JdbcUtil.getJdbcConnection();
			
			String sqlSelectQuery = "select id,name,image from person where id = ?";
			
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
					
					InputStream is = resultSet.getBinaryStream(3);
					
					File file = new File("copied.jpg");
					
					FileOutputStream fos = new FileOutputStream(file);
					/*
					 * int i = is.read(); while(i!=-1) { fos.write(i); i = is.read(); }
					 */
					
					/*
					 * byte[] b = new byte[1024]; while(is.read(b)>0) { fos.write(b); }
					 */
					
					IOUtils.copy(is,fos);
					fos.close();
					System.out.println(sid+"\t"+sname+"\t"+file.getAbsolutePath());
					
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
