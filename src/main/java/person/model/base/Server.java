package person.model.base;

import person.model.utility.JDBCUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Server {

    public static final Server SERVER = new Server();

    private final List<Korisnici> korisnici = new ArrayList<>();

    private Server() {
        this.setKorisnici(JDBCUtils.selectAllFromZus());
         }

    public List<Korisnici> getKorisnici() {
        return korisnici;
    }

    public void setKorisnici(Collection<Korisnici> people) {
        this.korisnici.clear();
        this.korisnici.addAll(korisnici);
    }

}
