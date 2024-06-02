package person.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import person.model.base.Korisnici;
import person.model.utility.JDBCUtils;

import java.util.List;

public class FilterControl implements EventHandler<ActionEvent> {

    private final TextField firstNameTextField;
    private final TextField lastNameTextField;
    private final TextField yearTextField;

    private final TableView<Korisnici> personTableView;

    public FilterControl(TextField firstNameTextField, TextField lastNameTextField, TextField yearTextField, TableView<Korisnici> personTableView) {
        this.firstNameTextField = firstNameTextField;
        this.lastNameTextField = lastNameTextField;
        this.yearTextField = yearTextField;
        this.personTableView = personTableView;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        String firstName = this.firstNameTextField.getText().trim();
        String lastName = this.lastNameTextField.getText().trim();
        String year = this.yearTextField.getText().trim();
        List<Korisnici> people = JDBCUtils.selectFromPerson(firstName, lastName, year);
        this.personTableView.setItems(FXCollections.observableArrayList(people));
        this.firstNameTextField.clear();
        this.lastNameTextField.clear();
        this.yearTextField.clear();
    }
}
