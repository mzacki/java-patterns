package edu.ant.persistency.jdbc.transactions;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by Matt on 26.11.2018 at 17:29.
 */
public class BeehiveReview {
    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String query = "UPDATE beehives SET review_date=? WHERE beehive_id=?";
        int beehive = 1;
        // TODO rethink using timestamp and SE8 local date API
        java.util.Date date = new java.util.Date();
        Date sqlDate = new Date(date.getTime());

        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("D:\\Dropbox\\PROJECTS\\SQL_backup\\testbase_credentials.txt"));
            String url = properties.getProperty("url");
            String user = properties.getProperty("user");
            String password = properties.getProperty("password");
            connection = DriverManager.getConnection(url, user, password);
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setDate(1, sqlDate);
            preparedStatement.setInt(2, beehive);
            preparedStatement.executeUpdate();
            // TODO add scanner to enter beehive_id to be reviewed (currently works with default values)
            // TODO show table records BEFORE and AFTER

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }

            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (connection != null) {
                connection.close();
            }
        }

    }
}
