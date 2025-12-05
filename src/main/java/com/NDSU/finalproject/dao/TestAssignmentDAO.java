package com.NDSU.finalproject.dao;

import com.NDSU.finalproject.DatabaseConnection;
import com.NDSU.finalproject.model.TestAssignment;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Noah Schamp
 */
public class TestAssignmentDAO {

    public void addTestAssignment(TestAssignment ta) throws SQLException {
        String sql = "INSERT INTO test_assignment (user_id, test_id, date_assigned, due_date) "
                   + "VALUES (?, ?, ?, ?)";

        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement prepStat = conn.prepareStatement(sql);

        prepStat.setInt(1, ta.getUserId());
        prepStat.setInt(2, ta.getTestId());
        prepStat.setDate(3, Date.valueOf(ta.getDateAssigned()));

        if (ta.getDueDate() != null) {
            prepStat.setDate(4, Date.valueOf(ta.getDueDate()));
        } else {
            prepStat.setNull(4, Types.DATE);
        }

        prepStat.executeUpdate();
    }

    public TestAssignment getTestAssignment(int userId, int testId) throws SQLException {
        String sql = "SELECT * FROM test_assignment WHERE user_id = ? AND test_id = ?";

        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement prepStat = conn.prepareStatement(sql);

        prepStat.setInt(1, userId);
        prepStat.setInt(2, testId);

        ResultSet resSet = prepStat.executeQuery();

        if (resSet.next()) {
            return new TestAssignment(
                    resSet.getInt("user_id"),
                    resSet.getInt("test_id"),
                    resSet.getDate("date_assigned").toLocalDate(),
                    resSet.getDate("due_date") != null ? resSet.getDate("due_date").toLocalDate() : null
            );
        }

        return null;
    }

    public List<TestAssignment> getAssignmentsByUserId(int userId) throws SQLException {
        String sql = "SELECT * FROM test_assignment WHERE user_id = ? ORDER BY test_id";

        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement prepStat = conn.prepareStatement(sql);

        prepStat.setInt(1, userId);
        ResultSet resSet = prepStat.executeQuery();

        List<TestAssignment> list = new ArrayList<>();

        while (resSet.next()) {
            TestAssignment ta = new TestAssignment(
                    resSet.getInt("user_id"),
                    resSet.getInt("test_id"),
                    resSet.getDate("date_assigned").toLocalDate(),
                    resSet.getDate("due_date") != null ? resSet.getDate("due_date").toLocalDate() : null
            );
            list.add(ta);
        }

        return list;
    }

    public List<TestAssignment> getAssignmentsByTestId(int testId) throws SQLException {
        String sql = "SELECT * FROM test_assignment WHERE test_id = ? ORDER BY user_id";

        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement prepStat = conn.prepareStatement(sql);

        prepStat.setInt(1, testId);
        ResultSet resSet = prepStat.executeQuery();

        List<TestAssignment> list = new ArrayList<>();

        while (resSet.next()) {
            TestAssignment ta = new TestAssignment(
                    resSet.getInt("user_id"),
                    resSet.getInt("test_id"),
                    resSet.getDate("date_assigned").toLocalDate(),
                    resSet.getDate("due_date") != null ? resSet.getDate("due_date").toLocalDate() : null
            );
            list.add(ta);
        }

        return list;
    }

    public List<TestAssignment> getAllTestAssignments() throws SQLException {
        String sql = "SELECT * FROM test_assignment ORDER BY user_id, test_id";

        Connection conn = DatabaseConnection.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet resSet = stmt.executeQuery(sql);

        List<TestAssignment> list = new ArrayList<>();

        while (resSet.next()) {
            TestAssignment ta = new TestAssignment(
                    resSet.getInt("user_id"),
                    resSet.getInt("test_id"),
                    resSet.getDate("date_assigned").toLocalDate(),
                    resSet.getDate("due_date") != null ? resSet.getDate("due_date").toLocalDate() : null
            );
            list.add(ta);
        }

        return list;
    }

    public void updateTestAssignment(TestAssignment ta) throws SQLException {
        String sql = "UPDATE test_assignment SET date_assigned = ?, due_date = ? "
                   + "WHERE user_id = ? AND test_id = ?";

        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement prepStat = conn.prepareStatement(sql);

        prepStat.setDate(1, Date.valueOf(ta.getDateAssigned()));

        if (ta.getDueDate() != null) {
            prepStat.setDate(2, Date.valueOf(ta.getDueDate()));
        } else {
            prepStat.setNull(2, Types.DATE);
        }

        prepStat.setInt(3, ta.getUserId());
        prepStat.setInt(4, ta.getTestId());

        prepStat.executeUpdate();
    }

    public void deleteTestAssignment(int userId, int testId) throws SQLException {
        String sql = "DELETE FROM test_assignment WHERE user_id = ? AND test_id = ?";

        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement prepStat = conn.prepareStatement(sql);

        prepStat.setInt(1, userId);
        prepStat.setInt(2, testId);

        prepStat.executeUpdate();
    }

    public boolean testAssignmentExists(int userId, int testId) throws SQLException {
        String sql = "SELECT * FROM test_assignment WHERE user_id = ? AND test_id = ?";

        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement prepStat = conn.prepareStatement(sql);

        prepStat.setInt(1, userId);
        prepStat.setInt(2, testId);

        ResultSet resSet = prepStat.executeQuery();

        return resSet.next();
    }
}
