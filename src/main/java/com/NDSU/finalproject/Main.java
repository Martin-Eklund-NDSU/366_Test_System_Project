package com.NDSU.finalproject;

import com.NDSU.finalproject.model.*;
import com.NDSU.finalproject.dao.*;
import com.NDSU.finalproject.ui.*;

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
        
        
        
        //Testing
        /*
        User testCreateUser = new User("NoahNSchamp", "pass123", "Noah", "Schamp", "NoahSchamp@ndsu.edu", true);
        User testReadUser = new User();
        UserDAO dao = new UserDAO();
        
        try{
            dao.addUser(testCreateUser);
            testReadUser = dao.getUserByFullName("Noah", "Schamp");
            System.out.println(testReadUser.toString());
        }
        catch (Exception e) {
            System.out.println("Error getting User!");
            e.printStackTrace();
        }
        */
        
        new LoginFrame();

    }   
}
