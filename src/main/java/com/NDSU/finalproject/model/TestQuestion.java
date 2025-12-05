package com.NDSU.finalproject.model;

/**
 *
 * @author Noah Schamp
 */
public class TestQuestion {
    private int testId;
    private int questionId;
    private int points;
    
    //Constructors
    public TestQuestion() {
    }
    
    public TestQuestion(int testId, int questionId, int points) {
        this.testId = testId;
        this.questionId = questionId;
        this.points = points;
    }
    
    //Getters & Setters
    public int getTestId() {
        return testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
    
    //toString Override
    @Override
    public String toString() {
        return "TestQuestion {" +
                "Test ID = " + testId +
                ", Question ID = " + questionId +
                ", Points = " + points +
                '}';
    }
}
