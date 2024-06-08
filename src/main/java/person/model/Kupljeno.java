package person.model;

import java.time.LocalDate;

public class Kupljeno {
    private  int stambeni_objekat_id;
    private  String vrsta_stambenog_objekta;
    private  LocalDate datum_kretanja;

    public Kupljeno(int stambeni_objekat_id, String vrsta_stambenog_objekta, LocalDate datum_kretanja) {
        this.stambeni_objekat_id = stambeni_objekat_id;
        this.vrsta_stambenog_objekta = vrsta_stambenog_objekta;
        this.datum_kretanja = datum_kretanja;
    }

    public int getStambeni_objekat_id() {
        return stambeni_objekat_id;
    }

    public void setStambeni_objekat_id(int stambeni_objekat_id) {
        this.stambeni_objekat_id = stambeni_objekat_id;
    }

    public String getVrsta_stambenog_objekta() {
        return vrsta_stambenog_objekta;
    }

    public void setVrsta_stambenog_objekta(String vrsta_stambenog_objekta) {
        this.vrsta_stambenog_objekta = vrsta_stambenog_objekta;
    }

    public LocalDate getDatum_kretanja() {
        return datum_kretanja;
    }

    public void setDatum_kretanja(LocalDate datum_kretanja) {
        this.datum_kretanja = datum_kretanja;
    }
}
