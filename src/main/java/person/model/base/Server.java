package person.model.base;

import person.model.*;
import person.model.utility.JDBCUtils;
import person.model.Osobe;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Server {

    private int korisnik_id;
    public static final Server SERVER = new Server();

    private final List<Korisnici> korisnici = new ArrayList<>();

    private final List<Objekat> objekti = new ArrayList<>();

    private final List<MissionPlanetCombo> misijeIPlanete = new ArrayList<>();
    private final List<MissionPlanetCombo> misijeIPlaneteInh = new ArrayList<>();
    private final List<StambeniObjekat> stambeniObjekti = new ArrayList<>();
    private final List<FlightPlaneCombo> flightPlaneCombos = new ArrayList<>();
    private final List<Kupovina> kupovinas = new ArrayList<>();
    private final List<PlanetObjectFlightCombo> planetObjectFlightCombos = new ArrayList<>();
    private final List<Osobe> osobe = new ArrayList<>();
    //private final List<Kupljeno> kupljeno = new ArrayList<>();

    private Server() {
        this.setKorisnici(JDBCUtils.selectAllFromZus());
        this.setObjekti(JDBCUtils.selectObjekatFromZus());
        this.setMisijeIPlanete(JDBCUtils.selectAllMissionsAndObjects());
        this.setMisijeIPlaneteInh(JDBCUtils.selectHabitableMissionsAndObjects());
        this.setStambeniObjekti(JDBCUtils.selectAvailableStambeniObjekatFromZus());
        this.setFlightPlaneCombos(JDBCUtils.selectSelectFlightPlane());
        this.setOsobe(JDBCUtils.selectOsobeFromZus());
        this.setKupovinas(JDBCUtils.selectKupovineFromZus());
        //this.setPlanetObjectFlightCombos(JDBCUtils.selectPlanetObjectFlight());

        //OVDE IDE PRVO U JDBC UPIT selectMisijeFromZus !!!!!!!!!!!!!!!!
        //this.setMisije(JDBCUtils.);
    }

    public List<Korisnici> getKorisnici() {
        return korisnici;
    }

    public void setKorisnici(Collection<Korisnici> korisnici) {
        this.korisnici.clear();
        this.korisnici.addAll(korisnici);
    }

    public List<Objekat> getObjekti() {
        return objekti;
    }

    public void setObjekti(Collection<Objekat> objekti) {
        this.objekti.clear();
        this.objekti.addAll(objekti);
    }

    public List<MissionPlanetCombo> getMisijeIPlanete() {
        return misijeIPlanete;
    }

    private void setMisijeIPlanete(Collection<MissionPlanetCombo> misijeIPlanete){
        this.misijeIPlanete.clear();
        this.misijeIPlanete.addAll(misijeIPlanete);
    }

    public List<MissionPlanetCombo> getMisijeIPlaneteInh() {
        return misijeIPlaneteInh;
    }

    private void setMisijeIPlaneteInh(Collection<MissionPlanetCombo> misijeIPlaneteInh){
        this.misijeIPlaneteInh.clear();
        this.misijeIPlaneteInh.addAll(misijeIPlaneteInh);
    }

    public List<StambeniObjekat> getStambeniObjekti() {
        return stambeniObjekti;
    }

    public void setStambeniObjekti(Collection<StambeniObjekat> stambeniObjekti){
        this.stambeniObjekti.clear();
        this.stambeniObjekti.addAll(stambeniObjekti);
    }

    public List<FlightPlaneCombo> getFlightPlaneCombos() {
        return flightPlaneCombos;
    }

    public void setFlightPlaneCombos(Collection<FlightPlaneCombo> flightPlaneCombos){
        this.flightPlaneCombos.clear();
        this.flightPlaneCombos.addAll(flightPlaneCombos);
    }

    public List<Osobe> getOsobe() {
        return osobe;
    }

    public void setOsobe(Collection<Osobe> osobe){
        this.osobe.clear();
        this.osobe.addAll(osobe);
    }

    public List<Kupovina> getKupovinas() {
        return kupovinas;
    }

    public void setKupovinas(Collection<Kupovina> kupovinas){
        this.kupovinas.clear();
        this.kupovinas.addAll(kupovinas);
    }

    public List<PlanetObjectFlightCombo> getPlanetObjectFlightCombos() {
        return planetObjectFlightCombos;
    }

    public void setPlanetObjectFlightCombos(Collection<PlanetObjectFlightCombo> planetObjectFlightCombos){
        this.planetObjectFlightCombos.clear();
        this.planetObjectFlightCombos.addAll(planetObjectFlightCombos);
    }

    public int getKorisnik_id() {
        return korisnik_id;
    }

    public void setKorisnik_id(int korisnik_id) {
        this.korisnik_id = korisnik_id;
    }
}