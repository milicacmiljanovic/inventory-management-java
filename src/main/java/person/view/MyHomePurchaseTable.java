package person.view;

import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import person.model.StambeniObjekat;
import person.model.StambeniObjekatH;

import java.util.List;

public class MyHomePurchaseTable extends TableView<StambeniObjekatH> {
    public MyHomePurchaseTable(List<StambeniObjekatH> values) {
        super(FXCollections.observableArrayList(values));

        TableColumn<StambeniObjekatH, Integer> tcBuildingId = new TableColumn<>("ID");
        TableColumn<StambeniObjekatH, String> tcType = new TableColumn<>("Type");
        TableColumn<StambeniObjekatH, Integer> tcSize = new TableColumn<>("Size");
        TableColumn<StambeniObjekatH, Integer> tcNumOfPeople = new TableColumn<>("Num Of People");
        TableColumn<StambeniObjekatH, Boolean> tcAvailability = new TableColumn<>("Availability");

        tcBuildingId.setCellValueFactory(new PropertyValueFactory<>("stambeni_objekat_id"));
        tcType.setCellValueFactory(new PropertyValueFactory<>("vrsta_stambenog_objekta"));
        tcSize.setCellValueFactory(new PropertyValueFactory<>("kvadratura"));
        tcNumOfPeople.setCellValueFactory(new PropertyValueFactory<>("broj_stanara"));
        tcAvailability.setCellValueFactory(new PropertyValueFactory<>("dostupnost"));

        super.getColumns().addAll(tcBuildingId,tcType,tcSize,tcNumOfPeople,tcAvailability);
    }
}
