package com.NDSU.finalproject.dao;

import com.NDSU.finalproject.DatabaseConnection;
import com.NDSU.finalproject.model.Question;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Noah Schamp
 */
public class QuestionDAO {

    public void addQuestion(Question question) throws SQLException {
        String sql = "INSERT INTO question (question_text, answer_type)" + 
                     " VALUES (?, ?)";

        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement prepStat = conn.prepareStatement(sql);

        prepStat.setString(1, question.getQuestionText());
        prepStat.setString(2, question.getAnswerType());

        prepStat.executeUpdate();
    }

    public Question getQuestionById(int id) throws SQLException {
        String sql = "SELECT * FROM question WHERE question_id = ?";

        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement prepStat = conn.prepareStatement(sql);
        prepStat.setInt(1, id);

        ResultSet resSet = prepStat.executeQuery();

        if (resSet.next()) {
            return new Question(
                    resSet.getInt("question_id"),
                    resSet.getString("question_text"),
                    resSet.getString("answer_type")
            );
        }

        return null;
    }

    public List<Question> getAllQuestions() throws SQLException {
        String sql = "SELECT * FROM question ORDER BY question_id";

        Connection conn = DatabaseConnection.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet resSet = stmt.executeQuery(sql);

        List<Question> questionList = new ArrayList<>();

        while (resSet.next()) {
            Question question = new Question(
                    resSet.getInt("question_id"),
                    resSet.getString("question_text"),
                    resSet.getString("answer_type")
            );
            questionList.add(question);
        }

        return questionList;
    }

    public void updateQuestion(Question question) throws SQLException {
        String sql = "UPDATE question SET question_text=?, answer_type=? WHERE question_id=?";

        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement prepStat = conn.prepareStatement(sql);

        prepStat.setString(1, question.getQuestionText());
        prepStat.setString(2, question.getAnswerType());
        prepStat.setInt(3, question.getQuestionId());

        prepStat.executeUpdate();
    }

    public void deleteQuestion(int id) throws SQLException {
        String sql = "DELETE FROM question WHERE question_id = ?";

        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement prepStat = conn.prepareStatement(sql);
        prepStat.setInt(1, id);

        prepStat.executeUpdate();
    }

    public boolean questionExists(int id) throws SQLException {
        String sql = "SELECT question_id FROM question WHERE question_id = ?";

        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement prepStat = conn.prepareStatement(sql);
        prepStat.setInt(1, id);

        ResultSet resSet = prepStat.executeQuery();

        return resSet.next();
    }
}
