package person.view;

import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import person.model.Korisnici;

import java.time.LocalDate;
import java.util.List;

public class PersonTable extends TableView<Korisnici> {
    public PersonTable(List<Korisnici> values) {
        super(FXCollections.observableArrayList(values));

        TableColumn<Korisnici, Integer> tcPersonId = new TableColumn<>("ID");
        TableColumn<Korisnici, String> tcFirstName = new TableColumn<>("First Name");
        TableColumn<Korisnici, String> tcLastName = new TableColumn<>("Last Name");
        TableColumn<Korisnici, String> tcUsername = new TableColumn<>("Username");
        TableColumn<Korisnici, String> tcPassword = new TableColumn<>("Password");
        TableColumn<Korisnici, LocalDate> tcDOB = new TableColumn<>("Date of Birth");

        tcPersonId.setCellValueFactory(new PropertyValueFactory<>("korisnik_id"));
        tcFirstName.setCellValueFactory(new PropertyValueFactory<>("ime"));
        tcLastName.setCellValueFactory(new PropertyValueFactory<>("prezime"));
        tcUsername.setCellValueFactory(new PropertyValueFactory<>("username"));
        tcPassword.setCellValueFactory(new PropertyValueFactory<>("password"));
        tcDOB.setCellValueFactory(new PropertyValueFactory<>("datum_rodjenja"));

        super.getColumns().add(tcPersonId);
        super.getColumns().add(tcFirstName);
        super.getColumns().add(tcLastName);
        super.getColumns().add(tcUsername);
        super.getColumns().add(tcPassword);
        super.getColumns().add(tcDOB);
    }
}
