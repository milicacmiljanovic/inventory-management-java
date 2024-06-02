package person.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.sql.*;
import java.time.LocalDate;


public class LogInControl implements EventHandler<ActionEvent> {

    private final TextField usernameTextField;
    private final PasswordField passwordField;

    public LogInControl(TextField usernameTextField, PasswordField passwordField) {
        this.usernameTextField = usernameTextField;
        this.passwordField = passwordField;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        String username = this.usernameTextField.getText().trim();
        String password = this.passwordField.getText().trim();

        // Placeholder for the actual login logic
        if (authenticate(username, password)) {
            System.out.println("Login successful for user: " + username);
        } else {
            System.out.println("Login failed for user: " + username);
        }

        // Clear fields after attempt
        this.usernameTextField.clear();
        this.passwordField.clear();
    }

    private boolean authenticate(String username, String password) {
        // Implement your actual authentication logic here
        // This is just a dummy implementation
        return "user".equals(username) && "password".equals(password);
    }
}