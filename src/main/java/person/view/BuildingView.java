package person.view;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import person.model.FlightPlaneCombo;
import person.model.StambeniObjekat;
import person.model.base.Server;

public class BuildingView extends Stage {

    private final BorderPane root = new BorderPane();
    private final TableView<StambeniObjekat> tvBuildingObject = new BuildingTable(Server.SERVER.getStambeniObjekti());
    private final TableView<FlightPlaneCombo> tvFlightPlaneCombo = new FlighTable(Server.SERVER.getFlightPlaneCombos());
    private final TextField tfime = new TextField("Name");
    private final TextField tflastName = new TextField("Last Name");
    private final DatePicker tfgodine = new DatePicker();
    private final Button btnBuy = new Button();


    public BuildingView(TableView<StambeniObjekat> tvBuildingObject, TableView<FlightPlaneCombo> tvFlightPlaneCombo) {
        super.setTitle("BuildingView");


        //NAJBITNIJE OVDE
        this.root.setLeft(this.tvBuildingObject);
        this.root.setRight(this.tvFlightPlaneCombo);
        this.root.setPadding(new Insets(10));
        this.tvBuildingObject.setMinWidth(600);
        //this.root.setRight(this.tvMissions);

        super.setScene(new Scene(this.root));
        this.setMinWidth(1000);
    }







}