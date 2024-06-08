package person.view;

import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import person.model.StambeniObjekat;
import person.model.StambeniObjekatH;
import person.model.base.Server;

public class MyPurchaseView extends Stage {

    private final BorderPane root = new BorderPane();
    private final TableView<StambeniObjekatH> tvHomePurchase;

    public MyPurchaseView() {
        super.setTitle("My Home Purchase");

        // Initialize the TableView with filtered data
        tvHomePurchase = new MyHomePurchaseTable(Server.SERVER.getStambeniObjekatHS());

        // Set the TableView as the center of the BorderPane
        root.setCenter(tvHomePurchase);

        // Set the scene of the stage with the root BorderPane
        super.setScene(new Scene(root, 800, 600));
    }
}
