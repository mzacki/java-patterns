package edu.ant.persistency.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Matt on 13.11.2018 at 19:00.
 */

// this class is unnecessary
public class DBConnection {

    public static void main(String[] args) {

        try {
            String url = "jdbc:mysql://localhost/testbase?verifyServerCertificate=false&useSSL=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            String user = "root";
            String password = "root";
            Connection connection = DriverManager.getConnection(url, user, password);

            Statement st = connection.createStatement();
            st.executeUpdate("INSERT INTO users " +
                    "VALUES (1001, 'John', 'none')");
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
