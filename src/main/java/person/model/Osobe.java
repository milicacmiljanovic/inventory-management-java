package person.model;

import java.time.LocalDate;

public class Osobe {
    String ime;
    String prezime;
    LocalDate godine;

    public Osobe(String ime, String prezime, LocalDate godine) {
        this.ime = ime;
        this.prezime = prezime;
        this.godine = godine;
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

    public LocalDate getGodine() {
        return godine;
    }

    public void setGodine(LocalDate godine) {
        this.godine = godine;
    }
}
