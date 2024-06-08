package person.view;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import person.model.Kupovina;
import person.model.PlanetObjectFlightCombo;

import java.util.List;

public class KupovinaTable extends TableView<PlanetObjectFlightCombo>{
        public KupovinaTable(List<PlanetObjectFlightCombo> values) {
            super(FXCollections.observableArrayList(values));

            TableColumn<PlanetObjectFlightCombo, String> tcDestinacija = new TableColumn<>("Destinacija");
            TableColumn<PlanetObjectFlightCombo, String> tcStObj = new TableColumn<>("Stambeni objekat");
            TableColumn<PlanetObjectFlightCombo, String> tcPrevoz = new TableColumn<>("Prevozno sredstvo");
            TableColumn<PlanetObjectFlightCombo, String> tcDatum = new TableColumn<>("Datum");
            TableColumn<PlanetObjectFlightCombo, String> tcVreme = new TableColumn<>("Vreme");


            tcDestinacija.setCellValueFactory(f ->new SimpleStringProperty(f.getValue().getPlaneta_naziv()));
            tcStObj.setCellValueFactory(f ->new SimpleStringProperty(f.getValue().getObjekat_naziv()));
            tcPrevoz.setCellValueFactory(f ->new SimpleStringProperty(f.getValue().getPrevozno_sredstvo()));
            tcDatum.setCellValueFactory(f ->new SimpleStringProperty(f.getValue().getDatum()));
            tcVreme.setCellValueFactory(f ->new SimpleStringProperty(f.getValue().getVreme()));
//        tcDestinacija.setCellValueFactory(new PropertyValueFactory<>("planeta_naziv"));
//        tcStObj.setCellValueFactory(new PropertyValueFactory<>("objekat_naziv"));
//        tcPrevoz.setCellValueFactory(new PropertyValueFactory<>("prevozno_sredstvo"));
//        tcDatum.setCellValueFactory(new PropertyValueFactory<>("datum"));
//        tcVreme.setCellValueFactory(new PropertyValueFactory<>("vreme"));

            super.getColumns().add(tcDestinacija);
            super.getColumns().add(tcStObj);
            super.getColumns().add(tcPrevoz);
            super.getColumns().add(tcDatum);
            super.getColumns().add(tcVreme);
        }
}
