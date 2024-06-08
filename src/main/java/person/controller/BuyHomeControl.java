package person.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TableView;
import person.model.FlightPlaneCombo;
import person.model.MissionPlanetCombo;
import person.model.Objekat;
import person.model.StambeniObjekat;
import person.model.base.Server;
import person.model.utility.JDBCUtils;
import person.view.BuildingTable;
import person.view.BuildingView;
import person.view.FlighTable;

public class BuyHomeControl implements EventHandler<ActionEvent> {

    private StambeniObjekat selectedItem;
    private StambeniObjekat dobijeni_objekat;
    private javafx.scene.control.TableView<StambeniObjekat> st;
    public BuyHomeControl(javafx.scene.control.TableView<StambeniObjekat> st) {
        this.st = st;
    }

    public void handle(ActionEvent actionEvent) {
        int korisnikId = Server.SERVER.getKorisnik_id();// Get the currently logged-in user's ID
        System.out.println(korisnikId);

        StambeniObjekat selectedObjekat = st.getSelectionModel().getSelectedItem();
        if (selectedObjekat != null) {
            // Update dostupnost in the database
            boolean dostupnostUpdated = JDBCUtils.updateStambeniObjekatDostupnost(selectedObjekat.getStambeni_objekat_id(), false);
            if (dostupnostUpdated) {
                selectedObjekat.setDostupnost(false); // Update locally in TableView if needed
                System.out.println("Home bought successfully.");
            } else {
                System.err.println("Failed to buy.");
            }
        } else {
            System.err.println("No item selected.");
        }
    }
/*
    public void handle(ActionEvent actionEvent) {
        Server.SERVER.getKorisnik_id();
        /*

        selectedItem = st.getSelectionModel().getSelectedItem();
        dobijeni_objekat = new StambeniObjekat(
                selectedItem.getStambeni_objekat_id(),
                selectedItem.getVrsta_stambenog_objekta(),
                selectedItem.getKvadratura(),
                selectedItem.getBroj_stanara(),
                selectedItem.isDostupnost(),
                selectedItem.getObjekkat_id());

        selectedItem.setDostupnost(false);

        Server.SERVER.setStambeniObjekti(JDBCUtils.prikazStambeniObjekat(dobijeni_objekat.getObjekkat_id()));







        System.out.println("Rade domovi");

        StambeniObjekat selectedObjekat = st.getSelectionModel().getSelectedItem();
        if (selectedObjekat != null) {
            boolean updated = JDBCUtils.updateStambeniObjekatAvailability(selectedObjekat.getStambeni_objekat_id(), false);
            if (updated) {
                selectedObjekat.setDostupnost(false); // Update locally in TableView if needed
                // Optionally, update UI or show success message
                System.out.println("Availability updated successfully.");
            } else {
                // Handle update failure, show error message
                System.err.println("Failed to update availability.");
            }
        } else {
            // Handle case where no item is selected from TableView
            System.err.println("No item selected.");
        }


// Update vlasnik_id in the database
                boolean vlasnikIdUpdated = JDBCUtils.updateStambeniObjekatVlasnikId(selectedObjekat.getStambeni_objekat_id(), korisnikId);
                if (vlasnikIdUpdated) {
                    selectedObjekat.setVlasnik_id(korisnikId); // Update locally in TableView if needed
                    System.out.println("Vlasnik_id updated successfully.");
                } else {
                    System.err.println("Failed to update vlasnik_id.");
                }




    }
    */

}
