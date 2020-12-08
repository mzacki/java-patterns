package edu.ant.persistency.jdbc;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * Created by Matt on 19.11.2018 at 18:49.
 */
public class DBMetaData {
    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        String catalog = null;
        String schemaPattern = null;
        String tableNamePattern = null;
        String columnNamePattern = null;
        String[] types = null;

        try {
            // Loading credentials via properities class
            Properties properties = new Properties();
            properties.load(new FileInputStream("D:\\Dropbox\\PROJECTS\\SQL_backup\\testbase_credentials.txt"));
            String url = properties.getProperty("url");
            String user = properties.getProperty("user");
            String password = properties.getProperty("password");
            // Connecting
            connection = DriverManager.getConnection(url, user, password);
            // Metadata
            DatabaseMetaData meta = connection.getMetaData();
            System.out.println("Product name: " + meta.getDatabaseProductName());
            System.out.println("Product version: " + meta.getDatabaseProductVersion());
            System.out.println();
            System.out.println("JDBC Driver name: " + meta.getDriverName());
            System.out.println("JDBC Driver version: " + meta.getDriverVersion());
            // Columns and tables
            System.out.println("Tables");
            System.out.println("--------------");
            resultSet = meta.getTables("testbase", schemaPattern, tableNamePattern,
                    types);

            while (resultSet.next()) {
                System.out.println(resultSet.getString("TABLE_NAME"));
            }

            // 4. Get list of columns
            System.out.println("\n\nColumns");
            System.out.println("--------------");

            resultSet = meta.getColumns("testbase", schemaPattern, tableNamePattern, columnNamePattern);

            while (resultSet.next()) {
                System.out.println(resultSet.getString("COLUMN_NAME"));
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
