package edu.ant.persistency.jdbc;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by Matt on 13.11.2018 at 19:37.
 */

// Database singleton

public class Database {

    private static final Database instance = new Database();

    private Database() {
    }

    // Example of invoking from other classes: Database db = Database.getInstance();

    public static Database getInstance() {
        return instance;
    }

    public Connection getConnection() throws SQLException {
        Connection connection = null;
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("D:\\Dropbox\\PROJECTS\\SQL_backup\\testbase_credentials.txt"));
            String url = properties.getProperty("url");
            String user = properties.getProperty("user");
            String password = properties.getProperty("password");
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to database.");
        } catch (Exception e) {
            e.printStackTrace();

        }
        return connection;
    }

    public void disconnect() {
        System.out.println("Disconnected.");
    }

}
