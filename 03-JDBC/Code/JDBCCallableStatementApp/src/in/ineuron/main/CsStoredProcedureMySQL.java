package in.ineuron.main;

import java.io.*;
import java.sql.*;
import java.text.ParseException;
import java.util.Scanner;

/*DELIMITER $$

USE `ineuron`$$

DROP PROCEDURE IF EXISTS `P_GET_PRODUCT_BY_NAME`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `P_GET_PRODUCT_BY_NAME`(IN name1 VARCHAR(20),IN name2 VARCHAR(20))
BEGIN
		SELECT pid,pname,price.qty FROM products WHERE pname IN (name1,name2);
	END$$

DELIMITER ;
*/
import in.ineuron.util.JdbcUtil;

public class CsStoredProcedureMySQL {

	private static final String storedProcedureCall = "{CALL `P_GET_PRODUCT_DETAILS_BY_NAME`(?,?)}";

	public static void main(String[] args) throws ParseException {

		// Resource used
		Connection connection = null;
		CallableStatement cstmt = null;
		Scanner scanner = null;
		ResultSet resultSet = null;
		String prod1 = null;
		String prod2 = null;
		boolean flag = false;
		try {

			connection = JdbcUtil.getJdbcConnection();

			if (connection != null) {
				cstmt = connection.prepareCall(storedProcedureCall);
			}

			scanner = new Scanner(System.in);
			// setting the input values
			if (scanner != null) {
				System.out.print("Enter the product1 name ::");
				prod1 = scanner.next();
				
				System.out.print("Enter the product2 name ::");
				prod2 = scanner.next();
			}
			
			
			if (cstmt != null) {
				cstmt.setString(0, prod1);
				cstmt.setString(2, prod2);
			}


			// run the stored prcedure
			if (cstmt != null) {
				cstmt.execute();
			}

			// retrive the results
			if (cstmt != null) {
				resultSet = cstmt.getResultSet();

			}
			
			//process the resultSet
			if(resultSet!=null)
			{	
				System.out.println("PID\tPNAME\tQTY");
				while(resultSet.next()) {
					System.out.println(resultSet.getInt(1)+"\t"+resultSet.getString(2)+"\t"+resultSet.getInt(3)+"\t"+resultSet.getInt(4));
					flag = true;
				}
			}
			
			
			if(flag) {
				System.out.println("Record available and display ..");
			}else {
				System.out.println("Record not available");
			}

		} catch (SQLException | IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				JdbcUtil.cleanUp(connection, cstmt, resultSet);
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

}
