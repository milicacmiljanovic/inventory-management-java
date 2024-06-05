package person.model.base;

import person.model.*;
import person.model.utility.JDBCUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.ToDoubleBiFunction;

public class Server {

    public static final Server SERVER = new Server();

    private final List<Korisnici> korisnici = new ArrayList<>();

    private final List<Objekat> objekti = new ArrayList<>();

    private final List<MissionPlanetCombo> misijeIPlanete = new ArrayList<>();
    private final List<MissionPlanetCombo> misijeIPlaneteInh = new ArrayList<>();
    private final List<StambeniObjekat> stambeniObjekti = new ArrayList<>();

    private Server() {
        this.setKorisnici(JDBCUtils.selectAllFromZus());
        this.setObjekti(JDBCUtils.selectObjekatFromZus());
        this.setMisijeIPlanete(JDBCUtils.selectAllMissionsAndObjects());
        this.setMisijeIPlaneteInh(JDBCUtils.selectHabitableMissionsAndObjects());
        this.setStambeniObjekti(JDBCUtils.selectStambeniObjekatFromZus());

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

    private void setStambeniObjekti(Collection<StambeniObjekat> stambeniObjekti){
        this.stambeniObjekti.clear();
        this.stambeniObjekti.addAll(stambeniObjekti);
    }

}
