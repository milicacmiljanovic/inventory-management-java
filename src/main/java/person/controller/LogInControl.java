package person.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import person.model.utility.JDBCUtils;
import person.view.ObjectsView;


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

        if (authenticate(username, password)) {
            System.out.println("Login successful for user: " + username);
            openObjectView();
        } else {
            System.out.println("Login failed for user: " + username);
        }

        this.usernameTextField.clear();
        this.passwordField.clear();
    }

    private boolean authenticate(String username, String password) {
        return "user".equals(username) && "password".equals(password);
    }

    private void openObjectView() {
        JDBCUtils.connect();
        ObjectsView objectsView = new ObjectsView();
        objectsView.show();
    }

}