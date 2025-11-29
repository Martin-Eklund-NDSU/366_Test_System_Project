package com.NDSU.finalproject.model;

import java.time.LocalDate;

/**
 *
 * @author Noah Schamp
 */
public class TestTaken {
    private int userId;
    private int testId;
    private LocalDate dateTaken;
    private int timeTaken;
    private double overallScore;
    
    //Constructors
    public TestTaken() {
    }
    
    public TestTaken(int userId, int testId, LocalDate dateTaken, int timeTaken, double overallScore) {
        this.userId = userId;
        this.testId = testId;
        this.dateTaken = dateTaken;
        this.timeTaken = timeTaken;
        this.overallScore = overallScore;
    }
    
    //Getters & Setters
    public int getUserId() {
        return userId;
    }
    
    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    public int getTestId() {
        return testId;
    }
    
    public void setTestId(int testId) {
        this.testId = testId;
    }
    
    public LocalDate getDateTaken() {
        return dateTaken;
    }
    
    public void setDateTaken(LocalDate dateTaken) {
        this.dateTaken = dateTaken;
    }
    
    public int getTimeTaken() {
        return timeTaken;
    }
    
    public void setTimeTaken(int timeTaken) {
        this.timeTaken = timeTaken;
    }
    
    public double getOverallScore() {
        return overallScore;
    }
    
    public void setOverallScore(double overallScore) {
        this.overallScore = overallScore;
    }
}
