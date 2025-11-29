package com.NDSU.finalproject.model;

import java.time.LocalDate;

/**
 *
 * @author Noah Schamp
 */
public class TestAssignment {
    private int userId;
    private int testId;
    private LocalDate dateAssigned;
    private LocalDate dueDate;
    
    //Constructors
    public TestAssignment() {
    }
    
    public TestAssignment(int userId, int testId, LocalDate dateAssigned, LocalDate dueDate) {
        this.userId = userId;
        this.testId = testId;
        this.dateAssigned = dateAssigned;
        this.dueDate = dueDate;
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

    public LocalDate getDateAssigned() {
        return dateAssigned;
    }

    public void setDateAssigned(LocalDate dateAssigned) {
        this.dateAssigned = dateAssigned;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
    
    //toString Override
    @Override
    public String toString() {
        return "TestAssignment{" +
               "userId = " + userId +
               ", testId = " + testId +
               ", dateAssigned = " + dateAssigned +
               ", dueDate = " + dueDate +
               '}';
    }
}
