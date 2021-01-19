package edu.ant.patterns.persistency.jdbc.procedures;

import java.io.FileInputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by Matt on 24.11.2018 at 17:29.
 */
// Calling stored procedure as result set
public class GetBeehivesForLine {
    public static void main(String[] args) throws Exception {
        Connection connection = null;
        CallableStatement statement = null;
        ResultSet resultSet = null;

        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("D:\\Dropbox\\PROJECTS\\SQL_backup\\testbase_credentials.txt"));
            String url = properties.getProperty("url");
            String user = properties.getProperty("user");
            String password = properties.getProperty("password");
            connection = DriverManager.getConnection(url, user, password);

            String line = "Hinderhofer";
            statement = connection.prepareCall("{call get_beehives_for_line(?)}");

            statement.setString(1, line);

            statement.execute();

            resultSet = statement.getResultSet();

            display(resultSet);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(connection, statement, resultSet);
        }
    }

    private static void display(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            int beehive_id = resultSet.getInt("beehive_id");
            String colour = resultSet.getString("beehive_colour");
            String line = resultSet.getString("line");

            System.out.printf("%d, %s, %s\n", beehive_id, colour, line);
        }
    }

    private static void close(Connection connection, CallableStatement statement, ResultSet resultSet) throws SQLException {
        if (statement != null) {
            statement.close();
        }

        if (connection != null) {
            connection.close();
        }

        if (resultSet != null) {
            resultSet.close();
        }
    }
}
