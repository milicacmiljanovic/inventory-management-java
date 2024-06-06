package person.view;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import person.model.FlightPlaneCombo;
import person.model.Putovanje;
import person.model.StambeniObjekat;
import person.model.Vozilo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class FlighTable extends TableView<FlightPlaneCombo> {

    public FlighTable(List<FlightPlaneCombo> values) {
        super(FXCollections.observableArrayList(values));


        TableColumn<FlightPlaneCombo, Integer> tcID = new TableColumn<>("putovanje_id");
        tcID.setCellValueFactory(cellData -> {
            Putovanje putovanje = cellData.getValue().getPutovanje();
            return new SimpleIntegerProperty(putovanje != null ? putovanje.getPutovanje_id() : 0).asObject();
        });

        TableColumn<FlightPlaneCombo, LocalDate> tcDate = new TableColumn<>("datum_kretanja");
        tcDate.setCellValueFactory(cellData -> {
            Putovanje putovanje = cellData.getValue().getPutovanje();
            return new SimpleObjectProperty<>(putovanje != null ? putovanje.getDatum_kretanja() : null);
        });

        TableColumn<FlightPlaneCombo, LocalTime> tcTime = new TableColumn<>("vreme_kretanja");
        tcTime.setCellValueFactory(cellData -> {
            Putovanje putovanje = cellData.getValue().getPutovanje();
            return new SimpleObjectProperty<>(putovanje != null ? putovanje.getVreme_kretanja() : null);
        });

        TableColumn<FlightPlaneCombo, Integer> tcVNum = new TableColumn<>("objekatt_id");
        tcVNum.setCellValueFactory(cellData -> {
            Putovanje putovanje = cellData.getValue().getPutovanje();
            return new SimpleIntegerProperty(putovanje != null ? putovanje.getObjekatt_id() : 0).asObject();
        });

        TableColumn<FlightPlaneCombo, Integer> tcType = new TableColumn<>("voziilo_id");
        tcType.setCellValueFactory(cellData -> {
            Putovanje putovanje = cellData.getValue().getPutovanje();
            return new SimpleIntegerProperty(putovanje != null ? putovanje.getVoziilo_id() : 0).asObject();
        });

        TableColumn<FlightPlaneCombo, Integer> tcPNum = new TableColumn<>("korisnik_id");
        tcPNum.setCellValueFactory(cellData -> {
            Putovanje putovanje = cellData.getValue().getPutovanje();
            return new SimpleIntegerProperty(putovanje != null ? putovanje.getKorisnik_id() : 0).asObject();
        });

        TableColumn<FlightPlaneCombo, Integer> tcVID = new TableColumn<>("vozilo_id");
        tcVID.setCellValueFactory(cellData -> {
            Vozilo vozilo = cellData.getValue().getVozilo();
            return new SimpleIntegerProperty(vozilo != null ? vozilo.getVozilo_id() : 0).asObject();
        });

        TableColumn<FlightPlaneCombo, String> tcVType = new TableColumn<>("sifra_vozila");
        tcVType.setCellValueFactory(cellData -> {
            Vozilo vozilo = cellData.getValue().getVozilo();
            return new SimpleStringProperty(vozilo != null ? String.valueOf(vozilo.getSifra_vozila()) : "");
        });

        TableColumn<FlightPlaneCombo, String> tcVTypee = new TableColumn<>("vrsta_vozila");
        tcVTypee.setCellValueFactory(cellData -> {
            Vozilo vozilo = cellData.getValue().getVozilo();
            return new SimpleStringProperty(vozilo != null ? vozilo.getVrsta_vozila() : "");
        });

        TableColumn<FlightPlaneCombo, Integer> tcNUmber = new TableColumn<>("broj_dozvoljenih_putnika");
        tcNUmber.setCellValueFactory(cellData -> {
            Vozilo vozilo = cellData.getValue().getVozilo();
            return new SimpleIntegerProperty(vozilo != null ? vozilo.getBroj_dozvoljenih_putnika() : 0).asObject();
        });

        getColumns().addAll(tcID, tcDate, tcTime, tcVNum, tcType, tcPNum, tcVID, tcVType, tcVTypee, tcNUmber);
    }

    }

