package person.model.base;

import person.model.Korisnici;
import person.model.Objekat;
import person.model.utility.JDBCUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Server {

    public static final Server SERVER = new Server();

    private final List<Korisnici> korisnici = new ArrayList<>();

    private final List<Objekat> objekti = new ArrayList<>();

    private Server() {
        this.setKorisnici(JDBCUtils.selectAllFromZus());
        this.setObjekti(JDBCUtils.selectDetaljanObjekatFromZus());
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



}
