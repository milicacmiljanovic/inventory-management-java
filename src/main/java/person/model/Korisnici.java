package person.model;



import java.time.LocalDate;

public class Korisnici {

    private final int korisnik_id;

    private String ime;

    private String prezime;

    private String username;
    private String password;
    private LocalDate datum_rodjenja;

    public Korisnici(int korisnik_id, String ime, String prezime, LocalDate datum_rodjenja) {
        this.korisnik_id = korisnik_id;
        this.ime = ime;
        this.prezime = prezime;
        this.datum_rodjenja = datum_rodjenja;
    }

    public Korisnici(int korisnikId, String ime, String prezime, String username, String password, LocalDate datumRodjenja) {
        this.korisnik_id = korisnikId;
        this.ime = ime;
        this.prezime = prezime;
        this.username = username;
        this.password = password;
        this.datum_rodjenja = datumRodjenja;
    }

    public int getKorisnik_id() {
        return korisnik_id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getDatum_rodjenja() {
        return datum_rodjenja;
    }

    public void setDatum_rodjenja(LocalDate datumRodjenja) {
        this.datum_rodjenja = datumRodjenja;
    }
}
