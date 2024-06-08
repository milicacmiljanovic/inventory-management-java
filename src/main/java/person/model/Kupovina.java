package person.model;

public class Kupovina {

    private final int kupovina_id;
    private int stambeni_objekat_id;
    private int putovanje_id;
    private int korisnik_id;

    public Kupovina(int kupovina_id, int stambeni_objekat_id, int putovanje_id, int korisnik_id) {
        this.kupovina_id = kupovina_id;
        this.stambeni_objekat_id = stambeni_objekat_id;
        this.putovanje_id = putovanje_id;
        this.korisnik_id = korisnik_id;
    }

    public int getKupovina_id() {
        return kupovina_id;
    }

    public int getStambeni_objekat_id() {
        return stambeni_objekat_id;
    }

    public void setStambeni_objekat_id(int stambeni_objekat_id) {
        this.stambeni_objekat_id = stambeni_objekat_id;
    }

    public int getPutovanje_id() {
        return putovanje_id;
    }

    public void setPutovanje_id(int putovanje_id) {
        this.putovanje_id = putovanje_id;
    }

    public int getKorisnik_id() {
        return korisnik_id;
    }

    public void setKorisnik_id(int korisnik_id) {
        this.korisnik_id = korisnik_id;
    }
}
