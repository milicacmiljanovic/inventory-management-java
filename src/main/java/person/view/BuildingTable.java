package person.view;

import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import person.model.Korisnici;
import person.model.StambeniObjekat;

import java.time.LocalDate;
import java.util.List;

public class BuildingTable extends TableView<StambeniObjekat> {

    public BuildingTable(List<StambeniObjekat> values) {
        super(FXCollections.observableArrayList(values));

        //TableColumn<StambeniObjekat, Integer> tcBuildingId = new TableColumn<>("ID");
        TableColumn<StambeniObjekat, String> tcType = new TableColumn<>("Type");
        TableColumn<StambeniObjekat, Integer> tcSize = new TableColumn<>("Size");
        //TableColumn<StambeniObjekat, Integer> tcNumOfPeople = new TableColumn<>("Num Of People");
        //TableColumn<StambeniObjekat, Boolean> tcAvailability = new TableColumn<>("Availability");

        //tcBuildingId.setCellValueFactory(new PropertyValueFactory<>("stambeni_objekat_id"));
        tcType.setCellValueFactory(new PropertyValueFactory<>("vrsta_stambenog_objekta"));
        tcSize.setCellValueFactory(new PropertyValueFactory<>("kvadratura"));
        //tcNumOfPeople.setCellValueFactory(new PropertyValueFactory<>("broj_stanara"));
        //tcAvailability.setCellValueFactory(new PropertyValueFactory<>("dostupnost"));

        super.getColumns().addAll(tcType,tcSize);
        /*
        super.getColumns().add(tcBuildingId);
        super.getColumns().add(tcType);
        super.getColumns().add(tcSize);
        super.getColumns().add(tcNumOfPeople);
        super.getColumns().add(tcAvailability);
        */

    }

}
