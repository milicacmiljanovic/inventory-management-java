package person.view;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import person.controller.AddOsobaControl;
import person.controller.BuyHomeControl;
import person.controller.BuyTicketControl;
import person.model.FlightPlaneCombo;
import person.model.StambeniObjekat;
import person.model.base.Server;

public class BuildingView extends Stage {

    private final BorderPane root = new BorderPane();
    private final TableView<StambeniObjekat> tvBuildingObject1 = new BuildingTable(Server.SERVER.getStambeniObjekti());
    private final TableView<FlightPlaneCombo> tvFlightPlaneCombo1 = new FlighTable(Server.SERVER.getFlightPlaneCombos());
    //private final TableView<Osobe> tvOsobe = new Osobe(Server.SERVER.getOsobe());
    private final TextField tfime = new TextField();
    private final TextField tflastName = new TextField();
    private final DatePicker tfgodine = new DatePicker();
    private final Button btnAddOsobe = new Button("Add Companion");
    private final Button btnBuyHome = new Button("Buy Residential Unit");
    private final Button btnBuyTicket = new Button("Buy Ticket");


    public BuildingView(TableView<StambeniObjekat> tvBuildingObject, TableView<FlightPlaneCombo> tvFlightPlaneCombo) {
        super.setTitle("BuildingView");

        this.btnAddOsobe.setOnAction(new AddOsobaControl(this.tfime, this.tflastName, this.tfgodine));
        this.btnBuyHome.setOnAction(new BuyHomeControl(tvBuildingObject1));
        this.btnBuyTicket.setOnAction(new BuyTicketControl(tvFlightPlaneCombo1));

        // Setup TableView selection listener to refresh btnBuyHome state
        tvBuildingObject1.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                btnBuyHome.setDisable(false); // Enable Buy Residential Unit button when an item is selected
            } else {
                btnBuyHome.setDisable(true); // Disable Buy Residential Unit button when no item is selected
            }
        });



        //NAJBITNIJE OVDE
        this.root.setLeft(this.home());
        this.root.setCenter(this.saputnici());
        this.root.setRight(this.ticket());
        this.root.setPadding(new Insets(10));
        this.tvBuildingObject1.setMinWidth(400);
        this.tvFlightPlaneCombo1.setMinWidth(600);
        //this.root.setRight(this.tvMissions);

        super.setScene(new Scene(this.root));
        this.setMinWidth(1000);
    }

    private VBox home (){
        VBox vBox = new VBox(10, this.tvBuildingObject1, this.btnBuyHome);
        vBox.setPadding(new Insets(10));
        vBox.setAlignment(Pos.CENTER);
        return vBox;
    }

    private VBox ticket (){
        VBox vBox = new VBox(10, this.tvFlightPlaneCombo1, this.btnBuyTicket);
        vBox.setPadding(new Insets(10));
        vBox.setAlignment(Pos.CENTER);
        return vBox;
    }


    private VBox saputnici(){
        VBox vBox = new VBox(new Label("Please input your companion!"), this.ime(), this.prezime(), this.godina(), this.btnAddOsobe);
        vBox.setPadding(new Insets(10));
        vBox.setAlignment(Pos.CENTER);
        return vBox;
    }

    private HBox ime(){
        HBox hBox = new HBox(10, new Label("First name:"), this.tfime);
        hBox.setPadding(new Insets(10));
        hBox.setAlignment(Pos.CENTER);
        return hBox;
    }
    private HBox prezime(){
        HBox hBox = new HBox(10, new Label("Last name:"), this.tflastName);
        hBox.setPadding(new Insets(10));
        hBox.setAlignment(Pos.CENTER);
        return hBox;
    }
    private HBox godina(){
        HBox hBox = new HBox(10, new Label("Year:"), this.tfgodine);
        hBox.setPadding(new Insets(10));
        hBox.setAlignment(Pos.CENTER);
        return hBox;
    }

    // Method to refresh TableView if needed
    public void refreshBuildingObjectTableView() {
        tvBuildingObject1.setItems(FXCollections.observableArrayList(Server.SERVER.getStambeniObjekti()));
    }



}


