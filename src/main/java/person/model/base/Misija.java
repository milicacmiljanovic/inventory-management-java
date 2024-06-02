package person.model.base;

import java.time.LocalDate;

public class Misija {

    private final int misija_id;

    private String naziv_misije;

    private LocalDate datum_polaska;

    private LocalDate datum_povratka;

    public Misija(int misija_id, String naziv_misije, LocalDate datum_polaska, LocalDate datum_povratka) {
        this.misija_id = misija_id;
        this.naziv_misije = naziv_misije;
        this.datum_polaska = datum_polaska;
        this.datum_povratka = datum_povratka;
    }

    public int getMisija_id() {
        return misija_id;
    }

    public String getNaziv_misije() {
        return naziv_misije;
    }

    public void setNaziv_misije(String naziv_misije) {
        this.naziv_misije = naziv_misije;
    }

    public LocalDate getDatum_polaska() {
        return datum_polaska;
    }

    public void setDatum_polaska(LocalDate datum_polaska) {
        this.datum_polaska = datum_polaska;
    }

    public LocalDate getDatum_povratka() {
        return datum_povratka;
    }

    public void setDatum_povratka(LocalDate datum_povratka) {
        this.datum_povratka = datum_povratka;
    }
}
