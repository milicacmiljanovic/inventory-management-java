package person.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import person.model.FlightPlaneCombo;
import person.model.Putovanje;
import person.model.StambeniObjekat;
import person.model.utility.JDBCUtils;

public class BuyTicketControl implements EventHandler<ActionEvent> {
    private FlightPlaneCombo selectedItem;
    private FlightPlaneCombo planeta_satelit;
    private javafx.scene.control.TableView<FlightPlaneCombo> ft;

    public BuyTicketControl(javafx.scene.control.TableView<FlightPlaneCombo> ft) {
        this.ft = ft;
    }

    public void handle(ActionEvent actionEvent) {
        System.out.println("Rade karte");

        selectedItem = ft.getSelectionModel().getSelectedItem();

        if (selectedItem != null) {
            Putovanje selectedPutovanje = selectedItem.getPutovanje();

            if (selectedPutovanje.isDostupnost()) {
                // Set dostupnost to false
                selectedPutovanje.setDostupnost(false);

                // Update the database
                boolean updated = JDBCUtils.updateDostupnost(selectedPutovanje.getPutovanje_id(), false);
                if (updated) {
                    System.out.println("Dostupnost updated to false for putovanje_id: " + selectedPutovanje.getPutovanje_id());
                } else {
                    System.out.println("Failed to update dostupnost for putovanje_id: " + selectedPutovanje.getPutovanje_id());
                }
            } else {
                System.out.println("Dostupnost is already false for putovanje_id: " + selectedPutovanje.getPutovanje_id());
            }
        } else {
            System.out.println("No item selected");
        }
    }
}
