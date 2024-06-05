package person.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import person.model.MissionPlanetCombo;
import person.model.Objekat;
import person.model.utility.JDBCUtils;

import java.util.List;

public class FilterHabitableObjects implements EventHandler<ActionEvent> {

    private final TableView<MissionPlanetCombo> objekatTableView;

    public FilterHabitableObjects( TableView<MissionPlanetCombo> objekti) {
        this.objekatTableView = objekti;
    }


    @Override
    public void handle(ActionEvent actionEvent) {
        List<MissionPlanetCombo> habitablePlanets = JDBCUtils.selectHabitableMissionsAndObjects();
        this.objekatTableView.setItems(FXCollections.observableArrayList(habitablePlanets));
    }
}
