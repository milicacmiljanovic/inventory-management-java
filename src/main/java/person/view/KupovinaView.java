package person.view;

import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import person.model.Kupljeno;
import person.model.Kupovina;
import person.model.PlanetObjectFlightCombo;
import person.model.base.Server;

public class KupovinaView {

    private final BorderPane root = new BorderPane();
    private final TableView<PlanetObjectFlightCombo> tvPOFComob = new KupovinaTable(Server.SERVER.getPlanetObjectFlightCombos());

}
