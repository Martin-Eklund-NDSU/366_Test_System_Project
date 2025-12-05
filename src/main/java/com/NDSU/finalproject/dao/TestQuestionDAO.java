package com.NDSU.finalproject.dao;

import com.NDSU.finalproject.DatabaseConnection;
import com.NDSU.finalproject.model.TestQuestion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Noah Schamp
 */
public class TestQuestionDAO {

    public void addTestQuestion(TestQuestion tq) throws SQLException {
        String sql = "INSERT INTO test_question (test_id, question_id, points) VALUES (?, ?, ?)";

        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement prepStat = conn.prepareStatement(sql);

        prepStat.setInt(1, tq.getTestId());
        prepStat.setInt(2, tq.getQuestionId());
        prepStat.setInt(3, tq.getPoints());

        prepStat.executeUpdate();
    }

    public TestQuestion getTestQuestion(int testId, int questionId) throws SQLException {
        String sql = "SELECT * FROM test_question WHERE test_id = ? AND question_id = ?";

        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement prepStat = conn.prepareStatement(sql);

        prepStat.setInt(1, testId);
        prepStat.setInt(2, questionId);

        ResultSet resSet = prepStat.executeQuery();

        if (resSet.next()) {
            return new TestQuestion(
                    resSet.getInt("test_id"),
                    resSet.getInt("question_id"),
                    resSet.getInt("points")
            );
        }

        return null;
    }

    public List<TestQuestion> getQuestionsByTestId(int testId) throws SQLException {
        String sql = "SELECT * FROM test_question WHERE test_id = ? ORDER BY question_id";

        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement prepStat = conn.prepareStatement(sql);

        prepStat.setInt(1, testId);
        ResultSet resSet = prepStat.executeQuery();

        List<TestQuestion> list = new ArrayList<>();

        while (resSet.next()) {
            TestQuestion tq = new TestQuestion(
                    resSet.getInt("test_id"),
                    resSet.getInt("question_id"),
                    resSet.getInt("points")
            );
            list.add(tq);
        }

        return list;
    }

    public List<TestQuestion> getAllTestQuestions() throws SQLException {
        String sql = "SELECT * FROM test_question ORDER BY test_id, question_id";

        Connection conn = DatabaseConnection.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet resSet = stmt.executeQuery(sql);

        List<TestQuestion> list = new ArrayList<>();

        while (resSet.next()) {
            TestQuestion tq = new TestQuestion(
                    resSet.getInt("test_id"),
                    resSet.getInt("question_id"),
                    resSet.getInt("points")
            );
            list.add(tq);
        }

        return list;
    }

    public void updateTestQuestion(TestQuestion tq) throws SQLException {
        String sql = "UPDATE test_question SET points = ? WHERE test_id = ? AND question_id = ?";

        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement prepStat = conn.prepareStatement(sql);

        prepStat.setInt(1, tq.getPoints());
        prepStat.setInt(2, tq.getTestId());
        prepStat.setInt(3, tq.getQuestionId());

        prepStat.executeUpdate();
    }

    public void deleteTestQuestion(int testId, int questionId) throws SQLException {
        String sql = "DELETE FROM test_question WHERE test_id = ? AND question_id = ?";

        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement prepStat = conn.prepareStatement(sql);

        prepStat.setInt(1, testId);
        prepStat.setInt(2, questionId);

        prepStat.executeUpdate();
    }

    public void deleteTestQuestionsByTestId(int testId) throws SQLException {
        String sql = "DELETE FROM test_question WHERE test_id = ?";

        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement prepStat = conn.prepareStatement(sql);

        prepStat.setInt(1, testId);
        prepStat.executeUpdate();
    }
}
