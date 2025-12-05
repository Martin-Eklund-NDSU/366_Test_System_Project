package com.NDSU.finalproject.dao;

import com.NDSU.finalproject.DatabaseConnection;
import com.NDSU.finalproject.model.AnswerOption;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Noah Schamp
 */
public class AnswerOptionDAO {

    public void addAnswerOption(AnswerOption option) throws SQLException {
        String sql = "INSERT INTO answer_option (question_id, option_label, option_text, is_correct) " +
                     "VALUES (?, ?, ?, ?)";

        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement prepStat = conn.prepareStatement(sql);

        prepStat.setInt(1, option.getQuestionId());
        prepStat.setString(2, option.getOptionLabel());
        prepStat.setString(3, option.getOptionText());
        prepStat.setBoolean(4, option.isCorrect());

        prepStat.executeUpdate();
    }

    public AnswerOption getAnswerOptionById(int id) throws SQLException {
        String sql = "SELECT * FROM answer_option WHERE option_id = ?";

        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement prepStat = conn.prepareStatement(sql);
        prepStat.setInt(1, id);

        ResultSet resSet = prepStat.executeQuery();

        if (resSet.next()) {
            return new AnswerOption(
                    resSet.getInt("option_id"),
                    resSet.getInt("question_id"),
                    resSet.getString("option_label"),
                    resSet.getString("option_text"),
                    resSet.getBoolean("is_correct")
            );
        }

        return null;
    }

    public List<AnswerOption> getOptionsByQuestionId(int questionId) throws SQLException {
        String sql = "SELECT * FROM answer_option WHERE question_id = ? ORDER BY option_id";

        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement prepStat = conn.prepareStatement(sql);
        prepStat.setInt(1, questionId);

        ResultSet resSet = prepStat.executeQuery();

        List<AnswerOption> optionList = new ArrayList<>();

        while (resSet.next()) {
            AnswerOption option = new AnswerOption(
                    resSet.getInt("option_id"),
                    resSet.getInt("question_id"),
                    resSet.getString("option_label"),
                    resSet.getString("option_text"),
                    resSet.getBoolean("is_correct")
            );
            optionList.add(option);
        }

        return optionList;
    }

    public List<AnswerOption> getAllAnswerOptions() throws SQLException {
        String sql = "SELECT * FROM answer_option ORDER BY option_id";

        Connection conn = DatabaseConnection.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet resSet = stmt.executeQuery(sql);

        List<AnswerOption> optionList = new ArrayList<>();

        while (resSet.next()) {
            AnswerOption option = new AnswerOption(
                    resSet.getInt("option_id"),
                    resSet.getInt("question_id"),
                    resSet.getString("option_label"),
                    resSet.getString("option_text"),
                    resSet.getBoolean("is_correct")
            );
            optionList.add(option);
        }

        return optionList;
    }

    public void updateAnswerOption(AnswerOption option) throws SQLException {
        String sql = "UPDATE answer_option SET question_id=?, option_label=?, option_text=?, is_correct=? " +
                     "WHERE option_id=?";

        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement prepStat = conn.prepareStatement(sql);

        prepStat.setInt(1, option.getQuestionId());
        prepStat.setString(2, option.getOptionLabel());
        prepStat.setString(3, option.getOptionText());
        prepStat.setBoolean(4, option.isCorrect());
        prepStat.setInt(5, option.getOptionId());

        prepStat.executeUpdate();
    }

    public void deleteAnswerOption(int id) throws SQLException {
        String sql = "DELETE FROM answer_option WHERE option_id = ?";

        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement prepStat = conn.prepareStatement(sql);

        prepStat.setInt(1, id);
        prepStat.executeUpdate();
    }

    public boolean answerOptionExists(int id) throws SQLException {
        String sql = "SELECT option_id FROM answer_option WHERE option_id = ?";

        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement prepStat = conn.prepareStatement(sql);
        prepStat.setInt(1, id);

        ResultSet resSet = prepStat.executeQuery();

        return resSet.next();
    }
}
