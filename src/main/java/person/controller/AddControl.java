package person.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import person.model.Korisnici;
import person.model.base.Server;
import person.model.utility.JDBCUtils;

import java.time.LocalDate;
import java.util.List;

public class AddControl implements EventHandler<ActionEvent> {

    private final TextField firstNameTextField;
    private final TextField lastNameTextField;
    private final TextField usernameTextField;
    private final TextField passwordTextField;
    private final DatePicker dateOfBirthPicker;

    private final TableView<Korisnici> personTableView;

    public AddControl(TextField firstNameTextField, TextField lastNameTextField, TextField usernameTextField, TextField passwordTextField, DatePicker dateOfBirthPicker, TableView<Korisnici> personTableView) {
        this.firstNameTextField = firstNameTextField;
        this.lastNameTextField = lastNameTextField;
        this.usernameTextField = usernameTextField;
        this.passwordTextField = passwordTextField;
        this.dateOfBirthPicker = dateOfBirthPicker;
        this.personTableView = personTableView;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        String firstName = this.firstNameTextField.getText().trim();
        String lastName = this.lastNameTextField.getText().trim();
        String username = this.usernameTextField.getText().trim();
        String password = this.passwordTextField.getText().trim();
        LocalDate dateOfBirth = this.dateOfBirthPicker.getValue();

        int nextId = JDBCUtils.getNextKorisnikId();

        Korisnici korisnici = new Korisnici(nextId, firstName, lastName, username, password, dateOfBirth);

        // Promeni konstruktor za insertIntoZus odnosno upit napravi i onaj filter da ne moze da se doda nesto sa istim username-om
        JDBCUtils.insertIntoZus(korisnici);

        List<Korisnici> korisnici2 = JDBCUtils.selectAllFromZus();
        Server.SERVER.setKorisnici(korisnici2);
        this.personTableView.setItems(FXCollections.observableArrayList(korisnici2));
        this.firstNameTextField.clear();
        this.lastNameTextField.clear();
        this.usernameTextField.clear();
        this.passwordTextField.clear();
        this.dateOfBirthPicker.setValue(LocalDate.now().minusYears(20));
    }
}
