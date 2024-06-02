package person.model.base;

public class Vozilo {

    private final int vozilo_id;

    private int sifra_vozila;
    private String vrsta_vozila;
    private int broj_dozvoljenih_putnika;

    public Vozilo(int vozilo_id, int sifra_vozila, String vrsta_vozila, int broj_dozvoljenih_putnika) {
        this.vozilo_id = vozilo_id;
        this.sifra_vozila = sifra_vozila;
        this.vrsta_vozila = vrsta_vozila;
        this.broj_dozvoljenih_putnika = broj_dozvoljenih_putnika;
    }

    public int getVozilo_id() {
        return vozilo_id;
    }

    public int getSifra_vozila() {
        return sifra_vozila;
    }

    public void setSifra_vozila(int sifra_vozila) {
        this.sifra_vozila = sifra_vozila;
    }

    public String getVrsta_vozila() {
        return vrsta_vozila;
    }

    public void setVrsta_vozila(String vrsta_vozila) {
        this.vrsta_vozila = vrsta_vozila;
    }

    public int getBroj_dozvoljenih_putnika() {
        return broj_dozvoljenih_putnika;
    }

    public void setBroj_dozvoljenih_putnika(int broj_dozvoljenih_putnika) {
        this.broj_dozvoljenih_putnika = broj_dozvoljenih_putnika;
    }
}
