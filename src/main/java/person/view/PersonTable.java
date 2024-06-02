package person.view;

import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import person.model.base.Korisnici;

import java.time.LocalDate;
import java.util.List;

public class PersonTable extends TableView<Korisnici> {
    public PersonTable(List<Korisnici> values) {
        super(FXCollections.observableArrayList(values));

        TableColumn<Korisnici, Integer> tcPersonId = new TableColumn<>("ID");
        TableColumn<Korisnici, String> tcFirstName = new TableColumn<>("First Name");
        TableColumn<Korisnici, String> tcLastName = new TableColumn<>("Last Name");
        TableColumn<Korisnici, LocalDate> tcDOB = new TableColumn<>("Date of Birth");

        tcPersonId.setCellValueFactory(new PropertyValueFactory<>("personId"));
        tcFirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        tcLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        tcDOB.setCellValueFactory(new PropertyValueFactory<>("dateOfBirth"));

        super.getColumns().add(tcPersonId);
        super.getColumns().add(tcFirstName);
        super.getColumns().add(tcLastName);
        super.getColumns().add(tcDOB);
    }
}
