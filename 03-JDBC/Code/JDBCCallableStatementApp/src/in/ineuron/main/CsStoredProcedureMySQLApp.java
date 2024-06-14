package in.ineuron.main;

import java.io.*;
import java.sql.*;
import java.text.ParseException;
import java.util.Scanner;

/*DELIMITER $$

CREATE
    [DEFINER = { user | CURRENT_USER }]
    PROCEDURE `ineuron`.`P_GET_PRODUCT_DETAILS_BY_ID`(IN id INT,OUT NAME VARCHAR(20),OUT rate INT,OUT qnt INT)
    
	BEGIN
		SELECT pname,price,qty INTO NAME,rate,qnt FROM products WHERE pid = id;
	END$$

DELIMITER ;`P_GET_PRODUCT_DETAILS_BY_ID`
*/
import in.ineuron.util.JdbcUtil;

public class CsStoredProcedureMySQLApp {

	private static final String storedProcedureCall = "{CALL `P_GET_PRODUCT_DETAILS_BY_ID`(?,?,?,?)}";

	public static void main(String[] args) throws ParseException {

		// Resource used
		Connection connection = null;
		CallableStatement cstmt = null;
		Scanner scanner = null;

		int id = 1;
		try {

			connection = JdbcUtil.getJdbcConnection();

			if (connection != null) {
				cstmt = connection.prepareCall(storedProcedureCall);
			}

			scanner = new Scanner(System.in);
			// setting the input values
			if (scanner != null) {
				System.out.print("Enter the productt id ::");
				id = scanner.nextInt();
			}
			if (cstmt != null) {
				cstmt.setInt(1, id);
			}

			// setting the datatypes of output values
			if (cstmt != null) {
				cstmt.registerOutParameter(2, Types.VARCHAR);
				cstmt.registerOutParameter(3, Types.INTEGER);
				cstmt.registerOutParameter(4, Types.INTEGER);
			}

			// run the stored prcedure
			if (cstmt != null) {
				cstmt.execute();
			}

			// retrive the results
			if (cstmt != null) {
				System.out.println("Produnt name is :: " + cstmt.getString(2));
				System.out.println("Produnt Cost is :: " + cstmt.getInt(3));
				System.out.println("Produnt OTY is :: " + cstmt.getInt(4));

			}

		} catch (SQLException | IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				JdbcUtil.cleanUp(connection, cstmt, null);
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

}
