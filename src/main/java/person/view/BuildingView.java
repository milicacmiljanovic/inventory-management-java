package person.view;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import person.controller.FilterControlObject;
import person.model.Objekat;
import person.model.StambeniObjekat;
import person.model.base.Server;

public class BuildingView extends Stage {

    private final BorderPane root = new BorderPane();
    private final TableView<StambeniObjekat> tvBuildingObject = new BuildingTable(Server.SERVER.getStambeniObjekti());

    public BuildingView() {
        super.setTitle("BuildingView");


        //NAJBITNIJE OVDE
        this.root.setCenter(this.tvBuildingObject);
        this.root.setPadding(new Insets(10));
        this.tvBuildingObject.setMinWidth(600);
        //this.root.setRight(this.tvMissions);

        super.setScene(new Scene(this.root));
        this.setMinWidth(1000);
    }




}
