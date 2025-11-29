package com.NDSU.finalproject.model;

/**
 *
 * @author Noah Schamp
 */
public class Question {
    private int questionId;
    private String questionText;
    private String answerType;
    
    //Constructors
    public Question() {
    }
    
    public Question(int questionId, String questionText, String answerType) {
        this.questionId = questionId;
        this.questionText = questionText;
        this.answerType = answerType;
    }
    
    //Getters & Setters
    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getAnswerType() {
        return answerType;
    }

    public void setAnswerType(String answerType) {
        this.answerType = answerType;
    }
    
    //toString Override
    @Override
    public String toString() {
        return "Question {" +
                "ID = " + questionId +
                ", Text = " + questionText +
                ", Type = " + answerType +
                '}';
    }
}
