package com.NDSU.finalproject.dao;

import com.NDSU.finalproject.DatabaseConnection;
import com.NDSU.finalproject.model.Test;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Noah Schamp
 */
public class TestDAO {

    public void addTest(Test test) throws SQLException {
        String sql = "INSERT INTO test (title, created_by, date_created)" + 
                     "VALUES (?, ?, ?)";

        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement prepStat = conn.prepareStatement(sql);

        prepStat.setString(1, test.getTitle());
        prepStat.setInt(2, test.getCreatedBy());
        prepStat.setDate(3, Date.valueOf(test.getDateCreated()));

        prepStat.executeUpdate();
    }

    public Test getTestById(int id) throws SQLException {
        String sql = "SELECT * FROM test WHERE test_id = ?";

        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement prepStat = conn.prepareStatement(sql);
        prepStat.setInt(1, id);

        ResultSet resSet = prepStat.executeQuery();

        if (resSet.next()) {
            return new Test(
                resSet.getInt("test_id"),
                resSet.getString("title"),
                resSet.getInt("created_by"),
                resSet.getDate("date_created").toLocalDate()
            );
        }

        return null;
    }

    public List<Test> getAllTests() throws SQLException {
        String sql = "SELECT * FROM test ORDER BY test_id";

        Connection conn = DatabaseConnection.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet resSet = stmt.executeQuery(sql);

        List<Test> testList = new ArrayList<>();

        while (resSet.next()) {
            Test test = new Test(
                resSet.getInt("test_id"),
                resSet.getString("title"),
                resSet.getInt("created_by"),
                resSet.getDate("date_created").toLocalDate()
            );
            testList.add(test);
        }

        return testList;
    }

    public List<Test> getTestsByCreator(int userId) throws SQLException {
        String sql = "SELECT * FROM test WHERE created_by = ? ORDER BY test_id";

        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement prepStat = conn.prepareStatement(sql);
        prepStat.setInt(1, userId);

        ResultSet resSet = prepStat.executeQuery();

        List<Test> testList = new ArrayList<>();

        while (resSet.next()) {
            Test test = new Test(
                resSet.getInt("test_id"),
                resSet.getString("title"),
                resSet.getInt("created_by"),
                resSet.getDate("date_created").toLocalDate()
            );
            testList.add(test);
        }

        return testList;
    }

    public void updateTest(Test test) throws SQLException {
        String sql = "UPDATE test SET title = ?, created_by = ?, date_created = ? WHERE test_id = ?";

        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement prepStat = conn.prepareStatement(sql);

        prepStat.setString(1, test.getTitle());
        prepStat.setInt(2, test.getCreatedBy());
        prepStat.setDate(3, Date.valueOf(test.getDateCreated()));
        prepStat.setInt(4, test.getTestId());

        prepStat.executeUpdate();
    }

    public void deleteTest(int id) throws SQLException {
        String sql = "DELETE FROM test WHERE test_id = ?";

        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement prepStat = conn.prepareStatement(sql);
        prepStat.setInt(1, id);

        prepStat.executeUpdate();
    }

    public boolean testExists(int id) throws SQLException {
        String sql = "SELECT test_id FROM test WHERE test_id = ?";

        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement prepStat = conn.prepareStatement(sql);
        prepStat.setInt(1, id);

        ResultSet resSet = prepStat.executeQuery();

        return resSet.next();
    }
}
