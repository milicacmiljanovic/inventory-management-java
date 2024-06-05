package person.view;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import person.controller.AddControl;
import person.controller.FilterControl;
import person.model.Korisnici;
import person.model.base.Server;

import java.time.LocalDate;

public class RegisterView extends Stage {

    private final BorderPane root = new BorderPane();

    private final TextField tfFirstName = new TextField();
    private final TextField tfLastName = new TextField();
    private final TextField tfUsername = new TextField();
    private final TextField tfPassword = new TextField();
    private final DatePicker dpDateOfBirth = new DatePicker(
            LocalDate.now().minusYears(20));
    private final Button btAdd = new Button("Add new person");

    private final TableView<Korisnici> tvPeople = new PersonTable(Server.SERVER.getKorisnici());

    private HBox titleBox() {
        HBox hbox = new HBox(new Label("Register"));
        hbox.setPadding(new Insets(10));
        hbox.setAlignment(Pos.CENTER);
        return hbox;
    }

    public RegisterView() {
        super.setTitle("RegisterView");
        this.btAdd.setOnAction(new AddControl(this.tfFirstName, this.tfLastName, this.tfUsername, this.tfPassword, this.dpDateOfBirth, this.tvPeople));
        this.root.setCenter(this.addBox());
        super.setScene(new Scene(this.root));
        this.setHeight(360);
    }

    private GridPane addBox() {
        GridPane gridPane = new GridPane();
        //gridPane.addRow(0,new Label("ID:"), this.tfID);
        HBox titleBox = new HBox(new Label("Register"));
        titleBox.setPadding(new Insets(10));
        titleBox.setAlignment(Pos.CENTER);

        // Add titleBox to gridPane, spanning two columns
        gridPane.add(titleBox, 0, 1, 2, 1);
        gridPane.addRow(2, new Label("First name:"), this.tfFirstName);
        gridPane.addRow(3, new Label("Last name:"), this.tfLastName);
        gridPane.addRow(4,new Label("Username:"), this.tfUsername);
        gridPane.addRow(5, new Label("Password:"), this.tfPassword);
        gridPane.addRow(6, new Label("Date of birth:"), this.dpDateOfBirth);
        this.btAdd.setPrefWidth(150);
        gridPane.add(this.btAdd, 0, 8, 2, 1);
        GridPane.setHalignment(this.btAdd, javafx.geometry.HPos.CENTER);
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setPadding(new Insets(10));
        gridPane.setAlignment(Pos.CENTER);
        return gridPane;
    }



}
