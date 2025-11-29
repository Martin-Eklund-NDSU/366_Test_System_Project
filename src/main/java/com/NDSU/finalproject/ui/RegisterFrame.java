package com.NDSU.finalproject.ui;

import com.NDSU.finalproject.dao.UserDAO;
import com.NDSU.finalproject.model.User;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Noah Schamp
 */
public class RegisterFrame extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JTextField emailField;
    private JTextField firstField;
    private JTextField lastField;

    public RegisterFrame() {
        setTitle("Create Account");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(6, 2, 8, 8));

        panel.add(new JLabel("Username:"));
        usernameField = new JTextField();
        panel.add(usernameField);

        panel.add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        panel.add(passwordField);

        panel.add(new JLabel("Email:"));
        emailField = new JTextField();
        panel.add(emailField);

        panel.add(new JLabel("First Name:"));
        firstField = new JTextField();
        panel.add(firstField);

        panel.add(new JLabel("Last Name:"));
        lastField = new JTextField();
        panel.add(lastField);

        JButton registerBtn = new JButton("Register");
        panel.add(registerBtn);

        JButton backBtn = new JButton("Back to Login");
        panel.add(backBtn);

        add(panel);

        registerBtn.addActionListener(e -> handleRegister());
        backBtn.addActionListener(e -> {
            new LoginFrame();
            dispose();
        });

        setVisible(true);
    }

    private void handleRegister() {
        UserDAO dao = new UserDAO();

        try {
            User user = new User();
            user.setUsername(usernameField.getText());
            user.setPassword(new String(passwordField.getPassword()));
            user.setEmail(emailField.getText());
            user.setFirstName(firstField.getText());
            user.setLastName(lastField.getText());
            user.setAdmin(false);

            dao.addUser(user);

            if (dao.userExist(dao.getUserIdByUsername(usernameField.getText()))) {
                JOptionPane.showMessageDialog(this, "Account created!");
                new LoginFrame();
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Failed to create account.");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error occurred.");
        }
    }
}
