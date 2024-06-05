package person.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TableView;
import person.model.MissionPlanetCombo;
import person.model.Objekat;
import person.model.StambeniObjekat;
import person.model.base.Server;
import person.model.utility.JDBCUtils;
import person.view.BuildingTable;
import person.view.BuildingView;

public class ShowAction implements EventHandler<ActionEvent> {
    private MissionPlanetCombo selectedItem;
    private Objekat planeta_satelit;
    private javafx.scene.control.TableView<MissionPlanetCombo> pt;
    public ShowAction(javafx.scene.control.TableView<MissionPlanetCombo> pt) {
        this.pt = pt;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        final TableView<StambeniObjekat> tvBuildingObject = new BuildingTable(Server.SERVER.getStambeniObjekti());
        BuildingView bW = new BuildingView(tvBuildingObject);
        bW.show();
        selectedItem = pt.getSelectionModel().getSelectedItem();
        planeta_satelit = new Objekat(selectedItem.getObjekat().getObjekat_id(), selectedItem.getObjekat().getNaziv(),
                selectedItem.getObjekat().getVrsta(),selectedItem.getObjekat().getUdaljenost_od_zvezde(),selectedItem.getObjekat().getNajniza_temperatura(),
                selectedItem.getObjekat().getNajvisa_temperatura(), selectedItem.getObjekat().getKiseonik(), selectedItem.getObjekat().getDrugi_gas(),
                selectedItem.getObjekat().getKolicina_drugog_gasa(),selectedItem.getObjekat().getVisina(),selectedItem.getObjekat().getBrzina_orbitiranja(),
                selectedItem.getObjekat().getBroj_umrlih());

        Server.SERVER.setStambeniObjekti(JDBCUtils.prikazStambeniObjekat(planeta_satelit.getObjekat_id()));

    }
}
