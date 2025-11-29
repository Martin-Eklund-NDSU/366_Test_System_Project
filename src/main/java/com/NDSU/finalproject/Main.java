package com.NDSU.finalproject;

import com.NDSU.finalproject.model.*;
import com.NDSU.finalproject.dao.*;

import java.time.LocalDate;

/**
 *
 * @author Noah Schamp
 */
public class Main {

    public static void main(String[] args) {
        try {
            var conn = DatabaseConnection.getConnection();
            System.out.println("Connected successfully!");
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        
        User testUser = new User(1, "Username", "Password", "FirstName", "LastName", "Email", true);
        System.out.println(testUser.toString());
        
        Test testTest = new Test(1, "TestName", 1, LocalDate.now());
        System.out.println(testTest.toString());
        
        Question testQuestion = new Question(1, "1.) Is this a test question?", "Written response");
        System.out.println(testQuestion.toString());
        
        TestAssignment testTestAssignment = new TestAssignment(1, 1, LocalDate.now(), LocalDate.now());
        System.out.println(testTestAssignment.toString());
    }   
}
