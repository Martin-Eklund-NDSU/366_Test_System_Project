package com.NDSU.finalproject.dao;

import com.NDSU.finalproject.DatabaseConnection;
import com.NDSU.finalproject.model.TestTaken;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Noah
 */
public class TestTakenDAO {

    public void addTestTaken(TestTaken tt) throws SQLException {
        String sql = "INSERT INTO test_taken (user_id, test_id, date_taken, time_taken, overall_score) "
                   + "VALUES (?, ?, ?, ?, ?)";

        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement prepStat = conn.prepareStatement(sql);

        prepStat.setInt(1, tt.getUserId());
        prepStat.setInt(2, tt.getTestId());
        prepStat.setDate(3, Date.valueOf(tt.getDateTaken()));

        if (tt.getTimeTaken() != 0) {
            prepStat.setInt(4, tt.getTimeTaken());
        } else {
            prepStat.setNull(4, Types.INTEGER);
        }

        if (tt.getOverallScore() != 0.0) {
            prepStat.setDouble(5, tt.getOverallScore());
        } else {
            prepStat.setNull(5, Types.NUMERIC);
        }

        prepStat.executeUpdate();
    }

    public TestTaken getTestTaken(int userId, int testId) throws SQLException {
        String sql = "SELECT * FROM test_taken WHERE user_id = ? AND test_id = ?";

        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement prepStat = conn.prepareStatement(sql);

        prepStat.setInt(1, userId);
        prepStat.setInt(2, testId);

        ResultSet resSet = prepStat.executeQuery();

        if (resSet.next()) {
            return new TestTaken(
                resSet.getInt("user_id"),
                resSet.getInt("test_id"),
                resSet.getDate("date_taken").toLocalDate(),
                resSet.getObject("time_taken") != null ? resSet.getInt("time_taken") : 0,
                resSet.getObject("overall_score") != null ? resSet.getDouble("overall_score") : 0.0
            );
        }

        return null;
    }

    public List<TestTaken> getTestsTakenByUserId(int userId) throws SQLException {
        String sql = "SELECT * FROM test_taken WHERE user_id = ? ORDER BY test_id";

        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement prepStat = conn.prepareStatement(sql);

        prepStat.setInt(1, userId);
        ResultSet resSet = prepStat.executeQuery();

        List<TestTaken> list = new ArrayList<>();

        while (resSet.next()) {
            TestTaken tt = new TestTaken(
                resSet.getInt("user_id"),
                resSet.getInt("test_id"),
                resSet.getDate("date_taken").toLocalDate(),
                resSet.getObject("time_taken") != null ? resSet.getInt("time_taken") : 0,
                resSet.getObject("overall_score") != null ? resSet.getDouble("overall_score") : 0.0
            );
            list.add(tt);
        }

        return list;
    }

    public List<TestTaken> getTestsTakenByTestId(int testId) throws SQLException {
        String sql = "SELECT * FROM test_taken WHERE test_id = ? ORDER BY user_id";

        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement prepStat = conn.prepareStatement(sql);

        prepStat.setInt(1, testId);
        ResultSet resSet = prepStat.executeQuery();

        List<TestTaken> list = new ArrayList<>();

        while (resSet.next()) {
            TestTaken tt = new TestTaken(
                resSet.getInt("user_id"),
                resSet.getInt("test_id"),
                resSet.getDate("date_taken").toLocalDate(),
                resSet.getObject("time_taken") != null ? resSet.getInt("time_taken") : 0,
                resSet.getObject("overall_score") != null ? resSet.getDouble("overall_score") : 0.0
            );
            list.add(tt);
        }

        return list;
    }

    public List<TestTaken> getAllTestsTaken() throws SQLException {
        String sql = "SELECT * FROM test_taken ORDER BY user_id, test_id";

        Connection conn = DatabaseConnection.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet resSet = stmt.executeQuery(sql);

        List<TestTaken> list = new ArrayList<>();

        while (resSet.next()) {
            TestTaken tt = new TestTaken(
                resSet.getInt("user_id"),
                resSet.getInt("test_id"),
                resSet.getDate("date_taken").toLocalDate(),
                resSet.getObject("time_taken") != null ? resSet.getInt("time_taken") : 0,
                resSet.getObject("overall_score") != null ? resSet.getDouble("overall_score") : 0.0
            );
            list.add(tt);
        }

        return list;
    }

    public void updateTestTaken(TestTaken tt) throws SQLException {
        String sql = "UPDATE test_taken SET date_taken = ?, time_taken = ?, overall_score = ? "
                   + "WHERE user_id = ? AND test_id = ?";

        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement prepStat = conn.prepareStatement(sql);

        prepStat.setDate(1, Date.valueOf(tt.getDateTaken()));

        if (tt.getTimeTaken() != 0) {
            prepStat.setInt(2, tt.getTimeTaken());
        } else {
            prepStat.setNull(2, Types.INTEGER);
        }

        if (tt.getOverallScore() != 0.0) {
            prepStat.setDouble(3, tt.getOverallScore());
        } else {
            prepStat.setNull(3, Types.NUMERIC);
        }

        prepStat.setInt(4, tt.getUserId());
        prepStat.setInt(5, tt.getTestId());

        prepStat.executeUpdate();
    }

    public void deleteTestTaken(int userId, int testId) throws SQLException {
        String sql = "DELETE FROM test_taken WHERE user_id = ? AND test_id = ?";

        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement prepStat = conn.prepareStatement(sql);

        prepStat.setInt(1, userId);
        prepStat.setInt(2, testId);

        prepStat.executeUpdate();
    }
}
