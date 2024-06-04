package person.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import person.controller.FilterControlObject;
import person.model.Objekat;
import person.model.base.Server;

public class ObjectView extends Stage {

    private final BorderPane root = new BorderPane();

    private final TableView<Objekat> tvObjects = new ObjectTable(Server.SERVER.getObjekti());

    private final TextField tfPlanetNameFilter = new TextField();
    private final Button btFilterObj = new Button("Filter");

    private final TextField tfPlanetName = new TextField();
    //private final TextField tfPlanetType = new TextField();
    //private final DatePicker dpDateOfBirth = new DatePicker(
      //      LocalDate.now().minusYears(20));
    private final Button btAdd = new Button("Add new person");

    public ObjectView() {
        super.setTitle("PlanetView");

        this.btFilterObj.setOnAction(new FilterControlObject(this.tfPlanetNameFilter, this.tvObjects));

        //NAJBITNIJE OVDE
        this.root.setCenter(this.tvObjects);
        this.root.setTop(this.filterBox());
        this.root.setRight(this.addBox());

        super.setScene(new Scene(this.root));
    }

    private HBox filterBox() {
        HBox hbox = new HBox(10, new Label("PlanetName:"), this.tfPlanetNameFilter,
                this.btFilterObj);
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

}
