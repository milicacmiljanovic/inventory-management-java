package person.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import person.view.BuildingView;
import person.view.MyPurchaseView;

public class MyHomePurchasesControl implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent event) {
        MyPurchaseView mHPW = new MyPurchaseView();
        mHPW.show();
    }
}
