package person.view;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import person.model.Misija;
import person.model.MissionPlanetCombo;
import person.model.Objekat;

import java.util.List;

public class MissionsTable extends TableView<MissionPlanetCombo> {

    public MissionsTable(List<MissionPlanetCombo> values) {
        super(FXCollections.observableArrayList(values));

        TableColumn<MissionPlanetCombo, String> tcMissionName = new TableColumn<>("Mission Name");
        TableColumn<MissionPlanetCombo, Integer> tcMissionId = new TableColumn<>("Mission ID");
        TableColumn<MissionPlanetCombo, Integer> tcObjectId = new TableColumn<>("Object ID");
        TableColumn<MissionPlanetCombo, String> tcFirstName = new TableColumn<>("Planet Name");
        TableColumn<MissionPlanetCombo, String> tcPlanetType = new TableColumn<>("Planet Type");
        TableColumn<MissionPlanetCombo, Integer> tcStarDistance = new TableColumn<>("Star Distance");
        TableColumn<MissionPlanetCombo, Integer> tcLowestTemp = new TableColumn<>("Lowest Temperature");
        TableColumn<MissionPlanetCombo, Integer> tcHighestTemp = new TableColumn<>("Highest Temperature");
        TableColumn<MissionPlanetCombo, Integer> tcOxygen = new TableColumn<>("Oxygen Percentage");
        TableColumn<MissionPlanetCombo, String> tcOtherGas = new TableColumn<>("Other Gas");
        TableColumn<MissionPlanetCombo, Integer> tcPercentageOfOtherGas = new TableColumn<>("Percentage Of Other Gas");
        TableColumn<MissionPlanetCombo, Integer> tcHeight = new TableColumn<>("Height");
        TableColumn<MissionPlanetCombo, Integer> tcOrbitalVelocity = new TableColumn<>("Orbital Velocity");
        TableColumn<MissionPlanetCombo, Integer> tcNumberOfDeaths = new TableColumn<>("Number Of Deaths");
/*
        tcMissionId.setCellValueFactory(new PropertyValueFactory<>("misije.misija_id"));
        tcObjectId.setCellValueFactory(new PropertyValueFactory<>("objekti.objekat_id"));
        tcFirstName.setCellValueFactory(new PropertyValueFactory<>("objekti.naziv"));
        tcPlanetType.setCellValueFactory(new PropertyValueFactory<>("objekti.vrsta"));
        tcStarDistance.setCellValueFactory(new PropertyValueFactory<>("objekti.udaljenost_od_zvezde"));
        tcLowestTemp.setCellValueFactory(new PropertyValueFactory<>("objekti.najniza_temperatura"));
        tcHighestTemp.setCellValueFactory(new PropertyValueFactory<>("objekti.najvisa_temperatura"));
        tcOxygen.setCellValueFactory(new PropertyValueFactory<>("objekti.kiseonik"));
        tcOtherGas.setCellValueFactory(new PropertyValueFactory<>("objekti.drugi_gas"));
        tcPercentageOfOtherGas.setCellValueFactory(new PropertyValueFactory<>("objekti.kolicina_drugog_gasa"));
        tcHeight.setCellValueFactory(new PropertyValueFactory<>("objekti.visina"));
        tcOrbitalVelocity.setCellValueFactory(new PropertyValueFactory<>("objekti.brzina_orbitiranja"));
        tcNumberOfDeaths.setCellValueFactory(new PropertyValueFactory<>("objekti.broj_umrlih"));
*/
        tcMissionName.setCellValueFactory(cellData -> {
            MissionPlanetCombo combo = cellData.getValue();
            return new SimpleStringProperty(combo != null ? combo.getMissionName() : null);
        });

        tcMissionId.setCellValueFactory(cellData -> {
            MissionPlanetCombo combo = cellData.getValue();
            Misija misija = combo != null ? combo.getMisija() : null;
            return new SimpleIntegerProperty(misija != null ? misija.getMisija_id() : 0).asObject();
        });

// For Objekat ID
        tcObjectId.setCellValueFactory(cellData -> {
            Objekat objekat = cellData.getValue().getObjekat();
            return new SimpleIntegerProperty(objekat != null ? objekat.getObjekat_id() : 0).asObject();
        });

// For Naziv
        tcFirstName.setCellValueFactory(cellData -> {
            Objekat objekat = cellData.getValue().getObjekat();
            return new SimpleStringProperty(objekat != null ? objekat.getNaziv() : "");
        });

// For Vrsta
        tcPlanetType.setCellValueFactory(cellData -> {
            Objekat objekat = cellData.getValue().getObjekat();
            return new SimpleStringProperty(objekat != null ? objekat.getVrsta() : "");
        });
        tcStarDistance.setCellValueFactory(cellData -> {
            Objekat objekat = cellData.getValue().getObjekat();
            if (objekat != null) {
                return new SimpleIntegerProperty(objekat.getUdaljenost_od_zvezde()).asObject();
            } else {
                return new SimpleIntegerProperty().asObject();
            }
        });

        tcLowestTemp.setCellValueFactory(cellData -> {
            Objekat objekat = cellData.getValue().getObjekat();
            if (objekat != null) {
                return new SimpleIntegerProperty(objekat.getNajniza_temperatura()).asObject();
            } else {
                return new SimpleIntegerProperty().asObject();
            }
        });

        tcHighestTemp.setCellValueFactory(cellData -> {
            Objekat objekat = cellData.getValue().getObjekat();
            if (objekat != null) {
                return new SimpleIntegerProperty(objekat.getNajvisa_temperatura()).asObject();
            } else {
                return new SimpleIntegerProperty().asObject();
            }
        });

        tcOxygen.setCellValueFactory(cellData -> {
            Objekat objekat = cellData.getValue().getObjekat();
            if (objekat != null) {
                return new SimpleIntegerProperty(objekat.getKiseonik()).asObject();
            } else {
                return new SimpleIntegerProperty().asObject();
            }
        });
        tcOtherGas.setCellValueFactory(cellData -> {
            Objekat objekat = cellData.getValue().getObjekat();
            if (objekat != null) {
                return new SimpleStringProperty(objekat.getDrugi_gas());
            } else {
                return new SimpleStringProperty();
            }
        });
        tcPercentageOfOtherGas.setCellValueFactory(cellData -> {
            Objekat objekat = cellData.getValue().getObjekat();
            if (objekat != null) {
                return new SimpleIntegerProperty(objekat.getKolicina_drugog_gasa()).asObject();
            } else {
                return new SimpleIntegerProperty().asObject();
            }
        });
        tcHeight.setCellValueFactory(cellData -> {
            Objekat objekat = cellData.getValue().getObjekat();
            if (objekat != null) {
                return new SimpleIntegerProperty(objekat.getVisina()).asObject();
            } else {
                return new SimpleIntegerProperty().asObject();
            }
        });
        tcOrbitalVelocity.setCellValueFactory(cellData -> {
            Objekat objekat = cellData.getValue().getObjekat();
            if (objekat != null) {
                return new SimpleIntegerProperty(objekat.getBrzina_orbitiranja()).asObject();
            } else {
                return new SimpleIntegerProperty().asObject();
            }
        });
        tcNumberOfDeaths.setCellValueFactory(cellData -> {
            Objekat objekat = cellData.getValue().getObjekat();
            if (objekat != null) {
                return new SimpleIntegerProperty(objekat.getBroj_umrlih()).asObject();
            } else {
                return new SimpleIntegerProperty().asObject();
            }
        });

        super.getColumns().addAll(tcMissionName, tcMissionId, tcObjectId, tcFirstName, tcPlanetType, tcStarDistance, tcLowestTemp,
                tcHighestTemp, tcOxygen, tcOtherGas, tcPercentageOfOtherGas, tcHeight, tcOrbitalVelocity, tcNumberOfDeaths);
    }
}
