package edu.ant.persistency.jdbc.user;

/**
 * Created by Matt on 13.11.2018 at 22:01.
 */
public class DAOFactory {
    public static UserDAO getUserDAO() {
        return new UserDAO();
    }

    public static LogDAO getLogDAO() {
        return new LogDAO();
    }
}
