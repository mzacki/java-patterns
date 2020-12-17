package edu.ant.patterns.persistency.jdbc.procedures;

import java.io.FileInputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Properties;

/**
 * Created by Matt on 24.11.2018 at 15:42.
 */
// Calling stored procedure INOUT type
public class SaluteTheLine {
    public static void main(String[] args) throws Exception {

        Connection connection = null;
        CallableStatement statement = null;

        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("D:\\Dropbox\\PROJECTS\\SQL_backup\\testbase_credentials.txt"));
            String url = properties.getProperty("url");
            String user = properties.getProperty("user");
            String password = properties.getProperty("password");
            connection = DriverManager.getConnection(url, user, password);

            String line = "Sklenar";
            statement = connection.prepareCall("{call salute_the_line(?)}");
            statement.registerOutParameter(1, Types.VARCHAR);
            statement.setString(1, line);
            statement.execute();

            String result = statement.getString(1);
            System.out.println(result);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(connection, statement);
        }
    }

    private static void close(Connection connection, CallableStatement statement) throws SQLException {
        if (statement != null) {
            statement.close();
        }

        if (connection != null) {
            connection.close();
        }
    }


}
