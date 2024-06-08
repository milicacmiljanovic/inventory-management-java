package person.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import person.view.MyPurchaseView;
import person.view.MyTaxiPurchaseView;

public class MyTaxiPurchasesControl implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent event) {
        MyTaxiPurchaseView mHPW = new MyTaxiPurchaseView();
        mHPW.show();
    }
}
