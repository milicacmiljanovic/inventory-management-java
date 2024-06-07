package person.model.base;

import person.model.*;
import person.model.utility.JDBCUtils;
import person.model.Osobe;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Server {

    public static final Server SERVER = new Server();

    private final List<Korisnici> korisnici = new ArrayList<>();

    private final List<Objekat> objekti = new ArrayList<>();

    private final List<MissionPlanetCombo> misijeIPlanete = new ArrayList<>();
    private final List<MissionPlanetCombo> misijeIPlaneteInh = new ArrayList<>();
    private final List<StambeniObjekat> stambeniObjekti = new ArrayList<>();
    private final List<FlightPlaneCombo> flightPlaneCombos = new ArrayList<>();
    private final List<Osobe> osobe = new ArrayList<>();
    private final List<Kupljeno> kupljeno = new ArrayList<>();

    private Server() {
        this.setKorisnici(JDBCUtils.selectAllFromZus());
        this.setObjekti(JDBCUtils.selectObjekatFromZus());
        this.setMisijeIPlanete(JDBCUtils.selectAllMissionsAndObjects());
        this.setMisijeIPlaneteInh(JDBCUtils.selectHabitableMissionsAndObjects());
        this.setStambeniObjekti(JDBCUtils.selectStambeniObjekatFromZus());
        this.setFlightPlaneCombos(JDBCUtils.selectSelectFlightPlane());
        this.setOsobe(JDBCUtils.selectOsobeFromZus());
        //this.setKupljeno(JDBCUtils.selectFromKupljeno());

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

    public List<Kupljeno> getKupljeno() {
        return kupljeno;
    }

    public void setKupljeno(Collection<Kupljeno> kupljeno){
        this.kupljeno.clear();
        this.kupljeno.addAll(kupljeno);
    }

}