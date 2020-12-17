package edu.ant.patterns.persistency.jdbc.transactions;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Properties;
import java.util.Scanner;

/**
 * Created by Matt on 25.11.2018 at 15:09.
 */
public class HoneyPicking {
    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("D:\\Dropbox\\PROJECTS\\SQL_backup\\testbase_credentials.txt"));
            String url = properties.getProperty("url");
            String user = properties.getProperty("user");
            String password = properties.getProperty("password");
            connection = DriverManager.getConnection(url, user, password);

            connection.setAutoCommit(false);

            System.out.println("Honey weight (kg) BEFORE\n");
            showHoney(connection);

            int beehive = askBeehiveId();
            preparedStatement = connection.prepareStatement("UPDATE beehives SET honey_weight=10 WHERE beehive_id=?");

            preparedStatement.setInt(1, beehive);
            updateDateTime(connection, beehive);
            preparedStatement.executeUpdate();
            System.out.println("\n>> Transaction steps are ready.\n");

            boolean correct = isOKtoSave();

            if (correct) {

                connection.commit();

                System.out.println("\n>> Transaction COMMITTED.\n");
            } else {

                connection.rollback();
                System.out.println("\n>> Transaction ROLLED BACK.\n");
            }

            System.out.println("Honey weight AFTER\n");
            showHoney(connection);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(connection, preparedStatement, null);
        }
    }

    private static int askBeehiveId() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the beehive id you want to steal the honey from: ");
        int beehive = scanner.nextInt();
        // TODO cannot close scanner here and open it again in subsequent method???
        // scanner.close();
        return beehive;
    }

    private static boolean isOKtoSave() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Is it okay to save?  yes/no: ");
        String input = scanner.nextLine();
        scanner.close();

        return input.equalsIgnoreCase("yes");
    }

    private static void showHoney(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // Prepare statement
            preparedStatement = connection
                    .prepareStatement("select * from beehives");

            // Execute SQL query
            resultSet = preparedStatement.executeQuery();

            // Process result set
            while (resultSet.next()) {
                int beehive_id = resultSet.getInt("beehive_id");
                String line = resultSet.getString("line");
                float honey_weight = resultSet.getFloat("honey_weight");
                LocalDate honey_stealing_date = resultSet.getDate("honey_stealing_date").toLocalDate();

                // TODO solve null pointer exception if honey_stealing_date is null
                System.out.printf("%d, %s, %.2f, %tF %n\n", beehive_id, line, honey_weight, honey_stealing_date);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(preparedStatement, resultSet);
        }

    }

    private static void updateDateTime(Connection connection, int beehive) throws SQLException {
        PreparedStatement preparedStatement = null;
        java.util.Date date=new java.util.Date();
        Date sqlDate=new Date(date.getTime());
        String query = "UPDATE beehives SET honey_stealing_date=? WHERE beehive_id=?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setDate(1, sqlDate);
            preparedStatement.setInt(2, beehive);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(preparedStatement, null);
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
