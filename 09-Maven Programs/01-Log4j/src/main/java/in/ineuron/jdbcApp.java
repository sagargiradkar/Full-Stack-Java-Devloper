package in.ineuron;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class jdbcApp
{
    // SLF4J Logger instance
    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args)
    {
        logger.info("Application started");

        // Database credentials
        String jdbcURL = "jdbc:mysql://localhost:3306/octbatch";
        String username = "root";
        String password = "root";

        Connection connection = null;

        try {
            logger.info("Attempting to connect to the database");

            // Establishing connection
            connection = DriverManager.getConnection(jdbcURL, username, password);

            if (connection != null) {
                logger.info("Connected to the database successfully!");
            }
        } catch (SQLException e) {
            logger.error("Failed to connect to the database", e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                    logger.info("Database connection closed");
                } catch (SQLException e) {
                    logger.error("Error while closing the database connection", e);
                }
            } else {
                logger.warn("Connection object is null, skipping close");
            }
        }

        logger.info("Application terminated");
    }
}
