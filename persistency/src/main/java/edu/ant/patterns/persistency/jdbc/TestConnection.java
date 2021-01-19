package edu.ant.patterns.persistency.jdbc;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * Created by Matt on 18.11.2018 at 13:22.
 */
public class TestConnection {

    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Loading credentials via properities class for standalone connection
            Properties properties = new Properties();
            properties.load(new FileInputStream("D:\\Dropbox\\PROJECTS\\SQL_backup\\testbase_credentials.txt"));
            String url = properties.getProperty("url");
            String user = properties.getProperty("user");
            String password = properties.getProperty("password");
            // Connecting by standalone connection
            // connection = DriverManager.getConnection(url, user, password);
            // Connection by Singleton Database factory
            connection = Database.getInstance().getConnection();
            System.out.println("Connection successful!");
            // Metadata
            DatabaseMetaData meta = connection.getMetaData();
            System.out.println("Product name: " + meta.getDatabaseProductName());
            System.out.println("Product version: " + meta.getDatabaseProductVersion());
            System.out.println();
            System.out.println("JDBC Driver name: " + meta.getDriverName());
            System.out.println("JDBC Driver version: " + meta.getDriverVersion());
            // Columns and tables

            // Sample query
            System.out.println();
            System.out.println("Sample query:");
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM beehives");

            while (resultSet.next()) {
                System.out.println(resultSet.getInt("beehive_id") + ". " + resultSet.getString("beehive_colour") + " " +
                                "- " +
                                resultSet.getString(
                        "line"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (connection != null) {
                connection.close();
            }
            if (statement != null) {
                statement.close();
            }
        }

    }
}
