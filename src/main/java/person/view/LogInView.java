package person.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import person.model.Korisnici;
import person.model.base.DataBase;
import person.model.utility.JDBCUtils;

import java.time.LocalDate;


public class LogInView extends Application{

    private final BorderPane root = new BorderPane();

    private final TextField tfUsername = new TextField();
    private final PasswordField pfPassword = new PasswordField();

    private final Button btLogin = new Button("Login");
    private final Button btRegister = new Button("Register");

    private DataBase databaseService = new DataBase();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Login View");

        this.btLogin.setOnAction(event -> {
            String username = this.tfUsername.getText();
            String password = this.pfPassword.getText();
            handleLogin(username, password, primaryStage);
        });

        this.btRegister.setOnAction(event -> {

            //String username = this.tfUsername.getText();
            //String password = this.pfPassword.getText();

            handleRegister(primaryStage);
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
        HBox buttonBox = new HBox(10, this.btLogin, this.btRegister);
        buttonBox.setAlignment(Pos.CENTER);
        gridPane.add(buttonBox, 1, 2);
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setPadding(new Insets(10));
        gridPane.setAlignment(Pos.CENTER);
        return gridPane;
    }

    private void handleLogin(String username, String password, Stage primaryStage) {
        if (databaseService.validateUser(username, password)) {
            openObjectView(primaryStage);

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Login Error");
            alert.setHeaderText(null);
            alert.setContentText("Invalid username or password.");
            alert.showAndWait();
        }
    }

    private HBox titleBox1() {
        HBox hbox = new HBox(new Label("Register"));
        hbox.setPadding(new Insets(10));
        hbox.setAlignment(Pos.CENTER);
        return hbox;
    }

    /*
    private void handleRegister(String ime, String prezime, String username, String password, LocalDate datum_rodjenja, Stage primaryStage) {
        if (databaseService.addUser(ime, prezime, username, password, datum_rodjenja)) {
            openMainView(primaryStage);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Registration Successful");
            alert.setHeaderText(null);
            alert.setContentText("User registered successfully.");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Registration Error");
            alert.setHeaderText(null);
            alert.setContentText("User registration failed.");
            alert.showAndWait();
        }
    }
     */
    private void handleRegister(Stage primaryStage) {
        openRegisterView(primaryStage);
    }

    private void handleObject(Stage primaryStage){
        openObjectView(primaryStage);
    }

    // OVA METODA MOZE CELA DA SE OBRISE SAD
    private void openRegisterView(Stage primaryStage){
        JDBCUtils.connect();
        primaryStage = new RegisterView();
        primaryStage.show();
    }

    private void openObjectView(Stage primaryStage){
        JDBCUtils.connect();
        primaryStage = new ObjectsView();
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}