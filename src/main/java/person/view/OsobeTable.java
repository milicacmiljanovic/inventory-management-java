package person.view;

import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import person.model.Osobe;

import java.time.LocalDate;
import java.util.List;

public class OsobeTable extends TableView<Osobe> {

    public OsobeTable(List<Osobe> values) {
        super(FXCollections.observableArrayList(values));

        TableColumn<Osobe, String> tcName = new TableColumn<>("Ime");
        TableColumn<Osobe, String> tcLastName = new TableColumn<>("Prezime");
        TableColumn<Osobe, LocalDate> tcDate = new TableColumn<>("Godine");


        tcName.setCellValueFactory(new PropertyValueFactory<>("Ime"));
        tcLastName.setCellValueFactory(new PropertyValueFactory<>("Prezime"));
        tcDate.setCellValueFactory(new PropertyValueFactory<>("Godine"));


        super.getColumns().addAll(tcName, tcLastName, tcDate);
        /*
        super.getColumns().add(tcBuildingId);
        super.getColumns().add(tcType);
        super.getColumns().add(tcSize);
        super.getColumns().add(tcNumOfPeople);
        super.getColumns().add(tcAvailability);
        */

    }

}
