package person.view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.sql.*;
import java.time.LocalDate;

public class LogInView extends Application{

    private final BorderPane root = new BorderPane();

    private final TextField tfUsername = new TextField();
    private final PasswordField pfPassword = new PasswordField();
    private final Button btLogin = new Button("Login");
    private final Button btCancel = new Button("Cancel");

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Login View");

        this.btLogin.setOnAction(event -> {
            String username = this.tfUsername.getText();
            String password = this.pfPassword.getText();
            // Handle the login logic here
            System.out.println("Username: " + username);
            System.out.println("Password: " + password);
        });

        this.btCancel.setOnAction(event -> {
            // Clear the fields
            this.tfUsername.clear();
            this.pfPassword.clear();
        });

        this.root.setCenter(this.loginForm());
        this.root.setTop(this.titleBox());

        Scene scene = new Scene(this.root, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private HBox titleBox() {
        HBox hbox = new HBox(new Label("Login"));
        hbox.setPadding(new Insets(10));
        hbox.setAlignment(Pos.CENTER);
        return hbox;
    }

    private GridPane loginForm() {
        GridPane gridPane = new GridPane();
        gridPane.addRow(0, new Label("Username:"), this.tfUsername);
        gridPane.addRow(1, new Label("Password:"), this.pfPassword);
        HBox buttonBox = new HBox(10, this.btLogin, this.btCancel);
        buttonBox.setAlignment(Pos.CENTER);
        gridPane.add(buttonBox, 1, 2);
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setPadding(new Insets(10));
        gridPane.setAlignment(Pos.CENTER);
        return gridPane;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
