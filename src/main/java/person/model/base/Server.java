package person.model.base;

import person.model.Korisnici;
import person.model.Misija;
import person.model.Objekat;
import person.model.utility.JDBCUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.ToDoubleBiFunction;

public class Server {

    public static final Server SERVER = new Server();

    private final List<Korisnici> korisnici = new ArrayList<>();

    private final List<Objekat> objekti = new ArrayList<>();

    private final List<Misija> misije = new ArrayList<>();

    private Server() {
        this.setKorisnici(JDBCUtils.selectAllFromZus());
        this.setObjekti(JDBCUtils.selectObjekatFromZus());

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

    private void setMisije(Collection<Misija> misije){
        this.misije.clear();
        this.misije.addAll(misije);
    }

    public List<Misija> getMisije() {
        return misije;
    }


}
