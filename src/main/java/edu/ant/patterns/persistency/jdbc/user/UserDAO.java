package edu.ant.patterns.persistency.jdbc.user;

import java.util.List;

/**
 * Created by Matt on 13.11.2018 at 17:50.
 */

// One DAO class per data table or view
// CRUD - create, retrieve, update, delete

public class UserDAO {
/*
    public int addUser(User user) throws SQLException {
        Connection connection = Database.getInstance().getConnection;
       PreparedStatement ps = connection.prepareStatement("Insert into users (name, password) values (?, ?)");
        ps.setString(1, user.getName());
        ps.setString(2, user.getPassword());

        int updated = ps.executeUpdate();
        ps.close();
        return updated;
    }*/

    public User getUser(int id) {
        return null;
    }

    public List<User> getUsers() {
        return null;
    }

    public void updateUser(User user) {

    }

    public void deleteUser(int id) {

    }
}
