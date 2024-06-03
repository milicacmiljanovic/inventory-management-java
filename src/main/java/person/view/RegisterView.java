package person.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import person.controller.AddControl;
import person.controller.FilterControl;

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

    public RegisterView() {
        super.setTitle("RegisterView");

        super.setScene(new Scene(this.root));
    }

    private GridPane addBox() {
        GridPane gridPane = new GridPane();
        //gridPane.addRow(0,new Label("ID:"), this.tfID);
        gridPane.addRow(1, new Label("First name:"), this.tfFirstName);
        gridPane.addRow(2, new Label("Last name:"), this.tfLastName);
        gridPane.addRow(3,new Label("Username:"), this.tfUsername);
        gridPane.addRow(4, new Label("Password:"), this.tfPassword);
        gridPane.addRow(5, new Label("Date of birth:"), this.dpDateOfBirth);
        gridPane.add(this.btAdd, 1, 3);
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setPadding(new Insets(10));
        gridPane.setAlignment(Pos.CENTER);
        return gridPane;
    }

}
