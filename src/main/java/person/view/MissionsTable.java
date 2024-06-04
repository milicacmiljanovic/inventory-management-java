package person.view;

import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import person.model.Misija;
import person.model.Objekat;

import java.util.List;

public class MissionsTable extends TableView<Misija> {

    public MissionsTable(List<Misija> values) {
        super(FXCollections.observableArrayList(values));

        TableColumn<Misija, Integer> tcObjectId = new TableColumn<>("ID");
        TableColumn<Misija, String> tcFirstName = new TableColumn<>("Planet Name");
        TableColumn<Misija, String> tcPlanetType = new TableColumn<>("Planet Type");
        TableColumn<Misija, Integer> tcNumOfMissions = new TableColumn<>("Number of Missions");


        tcObjectId.setCellValueFactory(new PropertyValueFactory<>("objekat_id"));
        tcFirstName.setCellValueFactory(new PropertyValueFactory<>("naziv"));
        tcPlanetType.setCellValueFactory(new PropertyValueFactory<>("vrsta"));
        tcNumOfMissions.setCellValueFactory(new PropertyValueFactory<>("broj_misija"));


        super.getColumns().add(tcObjectId);
        super.getColumns().add(tcFirstName);
        super.getColumns().add(tcPlanetType);
        super.getColumns().add(tcNumOfMissions);

    }

}
