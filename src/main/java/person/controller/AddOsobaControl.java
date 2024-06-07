package person.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import person.model.utility.JDBCUtils;
import person.model.Osobe;

import java.time.LocalDate;

public class AddOsobaControl implements EventHandler<ActionEvent> {

    private final TextField ime;
    private final TextField prezime;
    private final DatePicker dateOfBirthPicker;


    public AddOsobaControl(TextField ime, TextField prezime, DatePicker dateOfBirthPicker) {
        this.ime = ime;
        this.prezime = prezime;
        this.dateOfBirthPicker = dateOfBirthPicker;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        String firstName = this.ime.getText().trim();
        String lastName = this.prezime.getText().trim();
        LocalDate dateOfBirth = this.dateOfBirthPicker.getValue();


        Osobe osobe = new Osobe(firstName, lastName, dateOfBirth);

        // Promeni konstruktor za insertIntoZus odnosno upit napravi i onaj filter da ne moze da se doda nesto sa istim username-om
        JDBCUtils.insertIntoZusOsobe(osobe);
/*
        List<Osobe> osobe2 = JDBCUtils.selectAllFromZus();
        Server.SERVER.setKorisnici(osobe2);
        this.personTableView.setItems(FXCollections.observableArrayList(osobe2));
        this.ime.clear();
        this.prezime.clear();
        this.dateOfBirthPicker.setValue(LocalDate.now().minusYears(20));

 */
    }
}
