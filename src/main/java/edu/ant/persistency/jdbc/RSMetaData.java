package edu.ant.persistency.jdbc;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Properties;

/**
 * Created by Matt on 19.11.2018 at 19:46.
 */
public class RSMetaData {

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;


        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("D:\\Dropbox\\PROJECTS\\SQL_backup\\testbase_credentials.txt"));
            String url = properties.getProperty("url");
            String user = properties.getProperty("user");
            String password = properties.getProperty("password");
            // Connecting
            connection = DriverManager.getConnection(url, user, password);
            // Statement
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM beehives");

            // ResultSet metadata
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int columnCount = resultSetMetaData.getColumnCount();
            System.out.println("Column count: " + columnCount + "\n");

            for (int column=1; column <= columnCount; column++) {
                System.out.println("Column name: " + resultSetMetaData.getColumnName(column));
                System.out.println("Column type name: " + resultSetMetaData.getColumnTypeName(column));
                System.out.println("Is Nullable: " + resultSetMetaData.isNullable(column));
                System.out.println("Is Auto Increment: " + resultSetMetaData.isAutoIncrement(column) + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
