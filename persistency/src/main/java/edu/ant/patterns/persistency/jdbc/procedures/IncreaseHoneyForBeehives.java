package edu.ant.patterns.persistency.jdbc.procedures;

import java.io.FileInputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * Created by Matt on 20.11.2018 at 21:00.
 */

// Calling stored procedure IN type

public class IncreaseHoneyForBeehives {
    public static void main(String[] args) throws Exception {

        Connection connection = null;
        CallableStatement statement = null;

        try {
            // Connection
            Properties properties = new Properties();
            properties.load(new FileInputStream("D:\\Dropbox\\PROJECTS\\SQL_backup\\testbase_credentials.txt"));
            String url = properties.getProperty("url");
            String user = properties.getProperty("user");
            String password = properties.getProperty("password");
            connection = DriverManager.getConnection(url, user, password);

            int beehive = 1;
            int increaseAmount = 10;

            // Show honey_weight BEFORE
            System.out.println("Honey weight BEFORE\n");
            showHoney(connection, beehive);

            // Prepare the stored procedure call
            statement = connection
                    .prepareCall("{call increase_honeyweight_for_beehive(?, ?)}");

            // Set the parameters
            statement.setInt(1, beehive);
            statement.setDouble(2, increaseAmount);

            // Call stored procedure
            System.out.println("\n\nCalling stored procedure.  increase_honeyweight_for_beehive('" + beehive + "', " + increaseAmount + ")");
            statement.execute();
            System.out.println("Finished calling stored procedure");

            // Show honey_weight AFTER
            System.out.println("\n\nHoney weight AFTER\n");
            showHoney(connection, beehive);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(connection, statement, null);
        }
    }

    private static void showHoney(Connection myConn, int beehive) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // Prepare statement
            preparedStatement = myConn
                    .prepareStatement("select * from beehives where beehive_id=?");

            preparedStatement.setInt(1, beehive);

            // Execute SQL query
            resultSet = preparedStatement.executeQuery();

            // Process result set
            while (resultSet.next()) {
                int beehive_id = resultSet.getInt("beehive_id");
                String line = resultSet.getString("line");
                float honey_weight = resultSet.getFloat("honey_weight");


                System.out.printf("%d, %s, %.2f\n", beehive_id, line, honey_weight);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(preparedStatement, resultSet);
        }

    }

    private static void close(Connection connection, Statement statement,
                              ResultSet resultSet) throws SQLException {
        if (resultSet != null) {
            resultSet.close();
        }

        if (statement != null) {
            statement.close();
        }

        if (connection != null) {
            connection.close();
        }
    }

    private static void close(Statement statement, ResultSet resultSet)
            throws SQLException {

        close(null, statement, resultSet);
    }
}
