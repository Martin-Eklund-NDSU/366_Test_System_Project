package com.NDSU.finalproject.dao;

import com.NDSU.finalproject.DatabaseConnection;
import com.NDSU.finalproject.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Noah Schamp
 */
public class UserDAO {

    public void addUser(User user) throws SQLException {
        String sql = "INSERT INTO account (username, user_password, email, firstname, lastname, is_admin) " +
                     "VALUES (?, ?, ?, ?, ?, ?)";

        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement prepStat = conn.prepareStatement(sql);

        prepStat.setString(1, user.getUsername());
        prepStat.setString(2, user.getPassword());
        prepStat.setString(4, user.getFirstName());
        prepStat.setString(5, user.getLastName());
        prepStat.setString(3, user.getEmail());
        prepStat.setBoolean(6, user.isAdmin());

        prepStat.executeUpdate();
    }

    public User getUserById(int id) throws SQLException {
        String sql = "SELECT * FROM account WHERE user_id = ?";

        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement prepStat = conn.prepareStatement(sql);
        prepStat.setInt(1, id);

        ResultSet resSet = prepStat.executeQuery();

        if (resSet.next()) {
            return new User(
                    resSet.getInt("user_id"),
                    resSet.getString("username"),
                    resSet.getString("user_password"),
                    resSet.getString("firstname"),
                    resSet.getString("lastname"),
                    resSet.getString("email"),
                    resSet.getBoolean("is_admin")
            );
        }
        return null;
    }
    
    public User getUserByFullName(String firstName, String lastName) throws SQLException {
        String sql = "SELECT * FROM account WHERE firstname = ? AND lastname = ?";

        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement prepStat = conn.prepareStatement(sql);
        prepStat.setString(1, firstName);
        prepStat.setString(2, lastName);

        ResultSet resSet = prepStat.executeQuery();

        if (resSet.next()) {
            return new User(
                    resSet.getInt("user_id"),
                    resSet.getString("username"),
                    resSet.getString("user_password"),
                    resSet.getString("firstname"),
                    resSet.getString("lastname"),
                    resSet.getString("email"),
                    resSet.getBoolean("is_admin")
            );
        }
        return null;
    }
    
    public User getUserByUsername(String username) throws SQLException {
        String sql = "SELECT * FROM account WHERE username = ?";

        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement prepStat = conn.prepareStatement(sql);
        prepStat.setString(1, username);

        ResultSet resSet = prepStat.executeQuery();

        if (resSet.next()) {
            return new User(
                    resSet.getInt("user_id"),
                    resSet.getString("username"),
                    resSet.getString("user_password"),
                    resSet.getString("firstname"),
                    resSet.getString("lastname"),
                    resSet.getString("email"),
                    resSet.getBoolean("is_admin")
            );
        }
        return null;
    }

    public List<User> getAllUsers() throws SQLException {
        String sql = "SELECT * FROM account ORDER BY user_id";

        Connection conn = DatabaseConnection.getConnection();
        Statement prepStat = conn.createStatement();
        ResultSet resSet = prepStat.executeQuery(sql);

        List<User> userList = new ArrayList<>();

        while (resSet.next()) {
            User user = new User(
                    resSet.getInt("user_id"),
                    resSet.getString("username"),
                    resSet.getString("user_password"),
                    resSet.getString("firstname"),
                    resSet.getString("lastname"),
                    resSet.getString("email"),
                    resSet.getBoolean("is_admin")
            );
            userList.add(user);
        }

        return userList;
    }
    
    public Integer getUserIdByFullName(String firstName, String lastName) throws SQLException {
    String sql = "SELECT user_id FROM account WHERE firstname = ? AND lastname = ?";

    try (Connection conn = DatabaseConnection.getConnection();
        PreparedStatement prepStat = conn.prepareStatement(sql)) {
        
        prepStat.setString(1, firstName);
        prepStat.setString(2, lastName);
        ResultSet resSet = prepStat.executeQuery();

        if (resSet.next()) {
            return resSet.getInt("user_id");
        }
    }
    return null;
    }

    public Integer getUserIdByUsername(String username) throws SQLException {
    String sql = "SELECT user_id FROM account WHERE username = ?";

    try (Connection conn = DatabaseConnection.getConnection();
        PreparedStatement prepStat = conn.prepareStatement(sql)) {

        prepStat.setString(1, username);
        ResultSet resSet = prepStat.executeQuery();

        if (resSet.next()) {
            return resSet.getInt("user_id");
        }
    }
    return null;
    }

    public Integer getUserIdByEmail(String email) throws SQLException {
    String sql = "SELECT user_id FROM account WHERE email = ?";

    try (Connection conn = DatabaseConnection.getConnection();
        PreparedStatement prepStat = conn.prepareStatement(sql)) {

        prepStat.setString(1, email);
        ResultSet resSet = prepStat.executeQuery();

        if (resSet.next()) {
            return resSet.getInt("user_id");
        }
    }
    return null;
    }

    public boolean userExist(int id) throws SQLException {
        String sql = "SELECT * FROM account WHERE user_id = ?";

        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement prepStat = conn.prepareStatement(sql);
        prepStat.setInt(1, id);

        ResultSet resSet = prepStat.executeQuery();

        if (resSet.next()) {
            return true;
        }
        return false;
    }

    public void updateUser(User user) throws SQLException {
        String sql = "UPDATE account SET username=?, user_password=?, email=?, firstname=?, lastname=?, is_admin=? " +
                     "WHERE user_id=?";

        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement prepStat = conn.prepareStatement(sql);

        prepStat.setString(1, user.getUsername());
        prepStat.setString(2, user.getPassword());
        prepStat.setString(4, user.getFirstName());
        prepStat.setString(5, user.getLastName());
        prepStat.setString(3, user.getEmail());
        prepStat.setBoolean(6, user.isAdmin());
        prepStat.setInt(7, user.getUserId());

        prepStat.executeUpdate();
    }

    public void deleteUser(int id) throws SQLException {
        String sql = "DELETE FROM account WHERE user_id = ?";

        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement prepStat = conn.prepareStatement(sql);
        prepStat.setInt(1, id);

        prepStat.executeUpdate();
    }
}
