package com.NDSU.finalproject.ui;

import com.NDSU.finalproject.dao.UserDAO;
import com.NDSU.finalproject.model.User;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Noah Schamp
 */
public class LoginFrame extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;

    public LoginFrame() {
        setTitle("Login");
        setSize(350, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panels
        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));

        panel.add(new JLabel("Username:"));
        usernameField = new JTextField();
        panel.add(usernameField);

        panel.add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        panel.add(passwordField);

        JButton loginBtn = new JButton("Login");
        JButton registerBtn = new JButton("Create Account");

        panel.add(loginBtn);
        panel.add(registerBtn);

        add(panel);

        // Button events
        loginBtn.addActionListener(e -> handleLogin());
        registerBtn.addActionListener(e -> {
            new RegisterFrame();
            dispose();
        });

        setVisible(true);
    }

    private void handleLogin() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        UserDAO dao = new UserDAO();

        try {
            User user = dao.getUserByUsername(username);

            if (user == null) {
                JOptionPane.showMessageDialog(this, "User not found.");
                return;
            }

            if (!user.getPassword().equals(password)) {
                JOptionPane.showMessageDialog(this, "Incorrect password.");
                return;
            }

            JOptionPane.showMessageDialog(this, "Welcome, " + user.getFirstName() + "!");

            // Move to main menu (later)
            // new MainMenuFrame(user);
            // dispose();

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Login error occurred.");
        }
    }
}
