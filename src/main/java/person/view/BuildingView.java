package person.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import person.controller.AddOsobaControl;
import person.controller.BuyControl;
import person.model.FlightPlaneCombo;
import person.model.StambeniObjekat;
import person.model.base.Server;

public class BuildingView extends Stage {

    private final BorderPane root = new BorderPane();
    private final TableView<StambeniObjekat> tvBuildingObject = new BuildingTable(Server.SERVER.getStambeniObjekti());
    private final TableView<FlightPlaneCombo> tvFlightPlaneCombo = new FlighTable(Server.SERVER.getFlightPlaneCombos());
    //private final TableView<Osobe> tvOsobe = new Osobe(Server.SERVER.getOsobe());
    private final TextField tfime = new TextField();
    private final TextField tflastName = new TextField();
    private final DatePicker tfgodine = new DatePicker();
    private final Button btnAddOsobe = new Button("Add Companion");
    private final Button btnBuy = new Button("Buy");


    public BuildingView(TableView<StambeniObjekat> tvBuildingObject, TableView<FlightPlaneCombo> tvFlightPlaneCombo) {
        super.setTitle("BuildingView");

        this.btnAddOsobe.setOnAction(new AddOsobaControl(this.tfime, this.tflastName, this.tfgodine));
        this.btnBuy.setOnAction(new BuyControl(tvBuildingObject,tvFlightPlaneCombo));


        //NAJBITNIJE OVDE
        this.root.setLeft(this.tvBuildingObject);
        this.root.setCenter(this.saputnici());
        this.root.setRight(this.tvFlightPlaneCombo);
        this.root.setPadding(new Insets(10));
        this.tvBuildingObject.setMinWidth(600);
        //this.root.setRight(this.tvMissions);

        super.setScene(new Scene(this.root));
        this.setMinWidth(1000);
    }


    private VBox saputnici(){
        VBox vBox = new VBox(10,new Label("Please input your companion!"), this.ime(), this.prezime(), this.godina(), this.btnAddOsobe,
                this.btnBuy);
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


    private TableView<String[]> tableView;
    private TextField textField1;
    private TextField textField2;
    private TextField textField3;


}


