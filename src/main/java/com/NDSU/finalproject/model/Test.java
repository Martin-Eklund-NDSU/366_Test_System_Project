package com.NDSU.finalproject.model;

import java.time.LocalDate;

/**
 *
 * @author Noah Schamp
 */
public class Test {
    private int testId;
    private String title;
    private int createdBy;
    private LocalDate dateCreated;
    
    //Constructors
    public Test() {
    }
    
    public Test(int testId, String title, int createdBy, LocalDate dateCreated) {
        this.testId = testId;
        this.title = title;
        this.createdBy = createdBy;
        this.dateCreated = dateCreated;
    }
    
    //Getters & Setters
    public int getTestId() {
        return testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    //toString Override
    @Override
    public String toString() {
        return "Test {" +
               "testId = " + testId +
               ", title = " + title +
               ", createdBy = " + createdBy +
               ", dateCreated = " + dateCreated +
               '}';
    }
}
