package person.model;

public class Kupovina {

    private final int kupovina_id;

    private int broj_karata;

    private int cena;


    public Kupovina(int kupovina_id, int broj_karata, int cena) {
        this.kupovina_id = kupovina_id;
        this.broj_karata = broj_karata;
        this.cena = cena;
    }

    public int getKupovina_id() {
        return kupovina_id;
    }

    public int getBroj_karata() {
        return broj_karata;
    }

    public void setBroj_karata(int broj_karata) {
        this.broj_karata = broj_karata;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }
}
