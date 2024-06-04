package person.view;

import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import person.model.Korisnici;
import person.model.Objekat;

import java.time.LocalDate;
import java.util.List;

public class ObjectTable extends TableView<Objekat> {

    public ObjectTable(List<Objekat> values) {
        super(FXCollections.observableArrayList(values));

        TableColumn<Objekat, Integer> tcObjectId = new TableColumn<>("ID");
        TableColumn<Objekat, String> tcFirstName = new TableColumn<>("Planet Name");
        TableColumn<Objekat, String> tcPlanetType = new TableColumn<>("Planet Type");
        TableColumn<Objekat, Integer> tcStarDistance = new TableColumn<>("Star Distance");
        TableColumn<Objekat, Integer> tcLowestTemp = new TableColumn<>("Lowest Temperature");
        TableColumn<Objekat, Integer> tcHighestTemp = new TableColumn<>("Highest Temperature");
        TableColumn<Objekat, Integer> tcOxygen = new TableColumn<>("Oxygen Percentage");
        TableColumn<Objekat, String> tcOtherGas = new TableColumn<>("Other Gas");
        TableColumn<Objekat, Integer> tcPercentageOfOtherGas = new TableColumn<>("Percentage Of Other Gas");
        TableColumn<Objekat, Integer> tcHeight = new TableColumn<>("Height");
        TableColumn<Objekat, Integer> tcOrbitalVelocity = new TableColumn<>("Orbital Velocity");
        TableColumn<Objekat, Integer> tcNumberOfDeaths = new TableColumn<>("Number Of Deaths");

        tcObjectId.setCellValueFactory(new PropertyValueFactory<>("objekat_id"));
        tcFirstName.setCellValueFactory(new PropertyValueFactory<>("naziv"));
        tcPlanetType.setCellValueFactory(new PropertyValueFactory<>("vrsta"));
        tcStarDistance.setCellValueFactory(new PropertyValueFactory<>("udaljenost_od_zvezde"));
        tcLowestTemp.setCellValueFactory(new PropertyValueFactory<>("najniza_temperatura"));
        tcHighestTemp.setCellValueFactory(new PropertyValueFactory<>("najvisa_temperatura"));
        tcOxygen.setCellValueFactory(new PropertyValueFactory<>("kiseonik"));
        tcOtherGas.setCellValueFactory(new PropertyValueFactory<>("drugi_gas"));
        tcPercentageOfOtherGas.setCellValueFactory(new PropertyValueFactory<>("kolicina_drugog_gasa"));
        tcHeight.setCellValueFactory(new PropertyValueFactory<>("visina"));
        tcOrbitalVelocity.setCellValueFactory(new PropertyValueFactory<>("brzina_orbitiranja"));
        tcNumberOfDeaths.setCellValueFactory(new PropertyValueFactory<>("broj_umrlih"));

        super.getColumns().add(tcObjectId);
        super.getColumns().add(tcFirstName);
        super.getColumns().add(tcPlanetType);
        super.getColumns().add(tcStarDistance);
        super.getColumns().add(tcLowestTemp);
        super.getColumns().add(tcHighestTemp);
        super.getColumns().add(tcOxygen);
        super.getColumns().add(tcOtherGas );
        super.getColumns().add(tcPercentageOfOtherGas);
        super.getColumns().add(tcHeight);
        super.getColumns().add(tcOrbitalVelocity);
        super.getColumns().add(tcNumberOfDeaths);

    }

}
