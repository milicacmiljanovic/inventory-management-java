package person.view;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import person.controller.FilterControlObject;
import person.controller.FilterHabitableObjects;
import person.model.Misija;
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

    private final TextField tfPlanetName = new TextField();
    //private final TextField tfPlanetType = new TextField();
    //private final DatePicker dpDateOfBirth = new DatePicker(
      //      LocalDate.now().minusYears(20));
    private final Button btAdd = new Button("Add new person");
    private final Button btFilterInh = new Button("Inhabitable Objects");

    public ObjectsView() {
        super.setTitle("PlanetView");

        this.btFilterObj.setOnAction(new FilterControlObject(this.tfPlanetNameFilter, this.tvObjects));
        this.btFilterInh.setOnAction(event -> filterHabitableObjects());
        tvObjects.setOnMouseClicked(event -> handleObjectDoubleClick(event));


        //NAJBITNIJE OVDE
        this.root.setLeft(this.tvObjects);
        this.tvObjects.setMinWidth(350);
        this.root.setTop(this.filterBox());
        this.root.setCenter(this.addBox());
        this.root.setPadding(new Insets(10));
        this.root.setRight(this.tvMissionsAndPlanets);
        this.tvObjects.setMinWidth(600);
        //this.root.setRight(this.tvMissions);

        super.setScene(new Scene(this.root));
        this.setMinWidth(1000);
    }

    private HBox filterBox() {
        HBox hbox = new HBox(10, new Label("PlanetName:"), this.tfPlanetNameFilter,
                this.btFilterObj, this.btFilterInh);
        hbox.setPadding(new Insets(10));
        hbox.setAlignment(Pos.CENTER);
        return hbox;
    }

    private GridPane addBox() {
        GridPane gridPane = new GridPane();
        gridPane.addRow(0, new Label("First name:"), this.tfPlanetName);
        gridPane.add(this.btAdd, 1, 3);
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setPadding(new Insets(10));
        gridPane.setAlignment(Pos.CENTER);
        return gridPane;
    }

    private void filterHabitableObjects() {
        List<MissionPlanetCombo> habitablePlanets = JDBCUtils.selectHabitableMissionsAndObjects();
        this.tvMissionsAndPlanetsInh.setItems(FXCollections.observableArrayList(habitablePlanets));
        this.root.setRight(this.tvMissionsAndPlanetsInh);
    }

    private void handleObjectDoubleClick(MouseEvent event) {
        if (event.getClickCount() == 2) { // Check for double-click
            Objekat selectedObjekat = tvMissionsAndPlanetsInh.getSelectionModel().getSelectedItem().getObjekat();
            if (selectedObjekat != null) {
                // Extract relevant information from selected Objekat
                int objekatId = selectedObjekat.getObjekat_id();
                String objekatName = selectedObjekat.getNaziv();
                // Create and show BuildingView stage
                BuildingView buildingView = new BuildingView();
                buildingView.show();
            }
        }
    }


}
