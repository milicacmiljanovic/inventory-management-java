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
import person.controller.FilterControlObject;
import person.controller.ShowAction;
import person.model.MissionPlanetCombo;
import person.model.Objekat;
import person.model.base.Server;
import person.model.utility.JDBCUtils;

import java.util.List;

public class ObjectsView extends Stage {

    private final BorderPane root = new BorderPane();

    private final TableView<Objekat> tvObjects = new ObjectsTable(Server.SERVER.getObjekti());

    private final TableView<MissionPlanetCombo> tvMissionsAndPlanets = new MissionsTable(Server.SERVER.getMisijeIPlanete());

    private final TableView<MissionPlanetCombo> tvMissionsAndPlanetsInh = new MissionsTable(Server.SERVER.getMisijeIPlaneteInh());

    private final TextField tfPlanetNameFilter = new TextField();
    private final Button btFilterObj = new Button("Filter");


    private final Button btFilterInh = new Button("Inhabitable Objects");
    private final Button btBuy1 = new Button("Buy");

    public ObjectsView() {
        super.setTitle("PlanetView");

        this.btFilterObj.setOnAction(new FilterControlObject(this.tfPlanetNameFilter, this.tvObjects));
        this.btFilterInh.setOnAction(event -> filterHabitableObjects());

        this.btBuy1.setOnAction(new ShowAction(tvMissionsAndPlanetsInh));

        this.btFilterInh.setOnAction(event -> {
            filterHabitableObjects();
            resetBuyButton(); // Reset btBuy1 button
        });

        // Add selection listener to enable/disable btBuy1 based on the selected table
        this.tvMissionsAndPlanets.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                // Disable btBuy1 if tvMissionsAndPlanets is selected
                btBuy1.setDisable(true);
            } else {
                // Enable btBuy1 if tvMissionsAndPlanetsInh is selected
                btBuy1.setDisable(false);
            }
        });


        //NAJBITNIJE OVDE
        this.root.setLeft(this.vBox());
        //this.tvObjects.setMinWidth(350);
        //this.root.setTop(this.filterBox());
        this.root.setCenter(this.vBox2());
        this.root.setPadding(new Insets(10));
        this.root.setRight(this.tvMissionsAndPlanets);
        this.tvObjects.setMinWidth(600);
        //this.root.setRight(this.tvMissions);

        super.setScene(new Scene(this.root));
        this.setMinWidth(1000);
    }

    private VBox vBox(){
        VBox vBox = new VBox(10,this.hBox() ,tvObjects);
        vBox.setPadding(new Insets(10));
        vBox.setAlignment(Pos.CENTER);
        return vBox;
    }

    private HBox hBox(){
        HBox hBox = new HBox(10,new Label("PlanetName:"), this.tfPlanetNameFilter,this.btFilterObj);
        hBox.setPadding(new Insets(10));
        hBox.setAlignment(Pos.CENTER);
        return hBox;
    }

    private VBox vBox2(){
        VBox vBox = new VBox(10, this.btFilterInh, btBuy1);
        vBox.setPadding(new Insets(10));
        vBox.setAlignment(Pos.CENTER);
        return vBox;
    }

    private HBox filterBox() {
        HBox hbox = new HBox(10, new Label("PlanetName:"), this.tfPlanetNameFilter,
                this.btFilterObj, this.btFilterInh, this.btBuy1);
        hbox.setPadding(new Insets(10));
        hbox.setAlignment(Pos.CENTER);
        return hbox;
    }

    private void filterHabitableObjects() {
        List<MissionPlanetCombo> habitablePlanets = JDBCUtils.selectHabitableMissionsAndObjects();
        this.tvMissionsAndPlanetsInh.setItems(FXCollections.observableArrayList(habitablePlanets));
        this.root.setRight(this.tvMissionsAndPlanetsInh);
    }

    private void resetBuyButton() {
        // Enable btBuy1 when btFilterInh is clicked
        btBuy1.setDisable(false);
    }

}