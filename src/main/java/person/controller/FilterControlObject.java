package person.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import person.model.Objekat;
import person.model.utility.JDBCUtils;

import java.util.List;

public class FilterControlObject implements EventHandler<ActionEvent> {

    private final TextField planetNameField;

    private final TableView<Objekat> objekatTableView;

    public FilterControlObject(TextField planetNameField, TableView<Objekat> objekti) {
        this.planetNameField = planetNameField;
        this.objekatTableView = objekti;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        String firstName = this.planetNameField.getText().trim();

        List<Objekat> people = JDBCUtils.selectFromPlanet(firstName);
        this.objekatTableView.setItems(FXCollections.observableArrayList(people));
        this.planetNameField.clear();
    }

}
