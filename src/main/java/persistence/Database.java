package persistence;

import java.io.*;
import java.sql.*;
import java.util.*;
import org.apache.logging.log4j.*;

/**
 * Provides access to the database
 * Created on 8/31/16
 *
 * @author pwaite
 * @author Alex M - Foll 2019 - added multi-line sql capability
 */
public class Database implements PropertiesLoader {
    // Create an object of the Database class
    private static Database intsance = new Database();
    private Properties properties;
    private Connection connection;
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Private constructor prevents instantiating this class anywhere else
     */
    private Database() {
        properties = loadProperties("/database.properties");
    }

    /**
     * Gets the only Database object available
     *
     * @return the single Database object
     */
    public static Database getInstance() {
        return intsance;
    }

    /**
     * Gets the Database connection
     *
     * @return the Database connection
     */
    public Connection getConnection() {
        return connection;
    }

    /**
     * Attempt to connect to the Database
     *
     * @throws Exception the exception
     */
    public void connect() throws Exception {
        if (connection != null) {
            return;
        }

        try {
            Class.forName(properties.getProperty("driver"));
        } catch (ClassNotFoundException e) {
            throw new Exception("Database.connect()... Error: MySQL Driver not found");
        }

        String url = properties.getProperty("url");
        connection = DriverManager.getConnection(url, properties.getProperty("username"),
                properties.getProperty("password"));
    }

    /**
     * Close and clean up the Database connection
     */
    public void disconnect() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.error("Cannot close connection", e);
            }
        }

        connection = null;
    }

    /**
     * Run the sql
     *
     * @param sqlFile the sql file to be read and executed line by line
     */
    public void runSQL(String sqlFile) {
        Statement stmt = null;
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(classLoader.getResourceAsStream(sqlFile)))) {
            connect();
            stmt = connection.createStatement();
            String sql = "";

            while (br.ready()) {
                char inputValue = (char)br.read();

                if (inputValue == ';') {
                    stmt.executeUpdate(sql);
                    sql = "";
                } else {
                    sql += inputValue;
                }
            }
        } catch (SQLException se) {
            logger.error("SQL Exception", se);
        } catch (Exception e) {
            logger.error("Exception", e);
        } finally {
            disconnect();
        }
    }
}
