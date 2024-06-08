package person.view;

import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import person.model.FlighPlaneComboH;
import person.model.FlightPlaneCombo;
import person.model.base.Server;

public class MyTaxiPurchaseView extends Stage {
    private final BorderPane root = new BorderPane();
    private final TableView<FlighPlaneComboH> tvTaxiPurchase = new MyTaxiPurchaseTable(Server.SERVER.getFlightPlaneCombosH());

    public MyTaxiPurchaseView() {
        super.setTitle("My Taxi Purchase");
        this.root.setCenter(tvTaxiPurchase);
        super.setScene(new Scene(root, 800, 600));
    }

}
