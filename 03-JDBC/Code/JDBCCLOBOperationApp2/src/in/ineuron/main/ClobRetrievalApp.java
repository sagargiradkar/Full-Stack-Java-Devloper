
package in.ineuron.main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.io.IOUtils;
import in.ineuron.util.JdbcUtil;

public class ClobRetrievalApp {

    public static void main(String[] args) {
        
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        int id = 1;
        try {
            // Get the database connection
            connection = JdbcUtil.getJdbcConnection();
            
            // SQL query to retrieve CLOB data
            String sqlSelectQuery = "SELECT id, name, history FROM cities WHERE id = ?";
            
            if (connection != null)
                pstmt = connection.prepareStatement(sqlSelectQuery);
            
            if (pstmt != null) {
                // Setting input values
                pstmt.setInt(1, id);
                
                // Execute the query
                resultSet = pstmt.executeQuery();
            }
            
            if (resultSet != null) {
                // Processing the resultSet
                if (resultSet.next()) {
                    System.out.printf("ID\tNAME\tHistory File Path%n");
                    int sid = resultSet.getInt(1);
                    String sname = resultSet.getString(2);
                    Reader reader = resultSet.getCharacterStream(3);
                    
                    // File to write the CLOB data
                    File file = new File("history_copied.txt");
                    FileWriter writer = new FileWriter(file);
                    
                    // Using IOUtils to copy the CLOB data to the file
                    IOUtils.copy(reader, writer);
                    writer.close();
                    
                    System.out.println(sid + "\t" + sname + "\t" + file.getAbsolutePath());
                    
                } else {
                    System.out.println("Record not found in the database for the given id :: " + id);
                }
            }
            
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                JdbcUtil.cleanUp(connection, pstmt, resultSet);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}/*
	 * ```
	 * 
	 * ### Explanation:
	 * 
	 * 1. **Package and Imports**: - The program is placed in the `in.ineuron.main`
	 * package. - Necessary imports include classes for database connection, SQL
	 * operations, file operations, and IO utilities.
	 * 
	 * 2. **Database Connection and SQL Execution**: - `connection =
	 * JdbcUtil.getJdbcConnection();`: Establishes a connection to the database
	 * using a utility class `JdbcUtil`. - `String sqlSelectQuery =
	 * "SELECT id, name, history FROM cities WHERE id = ?";`: Defines an SQL query
	 * to retrieve CLOB data.
	 * 
	 * 3. **Preparing and Executing the SQL Query**: - `pstmt =
	 * connection.prepareStatement(sqlSelectQuery);`: Prepares the SQL statement. -
	 * `pstmt.setInt(1, id);`: Sets the input parameter for the SQL query. -
	 * `resultSet = pstmt.executeQuery();`: Executes the query and retrieves the
	 * results.
	 * 
	 * 4. **Processing the ResultSet**: - Checks if the result set contains any data
	 * with `if (resultSet.next())`. - Retrieves data from the result set, including
	 * the CLOB data using `resultSet.getCharacterStream(3)`.
	 * 
	 * 5. **Writing CLOB Data to a File**: - `File file = new
	 * File("history_copied.txt");`: Creates a file to store the CLOB data. -
	 * `FileWriter writer = new FileWriter(file);`: Creates a `FileWriter` to write
	 * data to the file. - `IOUtils.copy(reader, writer);`: Copies the CLOB data
	 * from the `Reader` to the `FileWriter`. - `writer.close();`: Closes the file
	 * writer.
	 * 
	 * 6. **Output**: - Prints the ID, name, and file path of the CLOB data.
	 * 
	 * 7. **Exception Handling**: - Catches `SQLException`, `IOException`, and
	 * generic exceptions, printing their stack traces.
	 * 
	 * 8. **Resource Cleanup**: - Uses a utility method
	 * `JdbcUtil.cleanUp(connection, pstmt, resultSet);` to close the database
	 * resources.
	 * 
	 * ### Corrections: - Corrected the `PreparedStatement` initialization (it was
	 * missing `pstmt = connection.prepareStatement(sqlSelectQuery);`). - Corrected
	 * the parameter index in `pstmt.setInt(1, id);` (it was incorrectly set to `id`
	 * instead of `1`). - Fixed the duplicate `Reader` initialization. - Added
	 * necessary imports and proper exception handling. - Ensured proper resource
	 * cleanup in the `finally` block.
	 */