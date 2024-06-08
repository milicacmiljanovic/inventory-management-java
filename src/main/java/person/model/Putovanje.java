package person.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Putovanje {
    private final int putovanje_id;
    private LocalDate datum_kretanja;
    private LocalTime vreme_kretanja;
    private boolean dostupnost;
    private int objekatt_id;
    private int voziilo_id;
    private int korisnik_id;


    public Putovanje(int putovanje_id, LocalDate datum_kretanja, LocalTime vreme_kretanja, boolean dostupnost, int objekatt_id, int voziilo_id, int korisnik_id) {
        this.putovanje_id = putovanje_id;
        this.datum_kretanja = datum_kretanja;
        this.vreme_kretanja = vreme_kretanja;
        this.dostupnost = dostupnost;
        this.objekatt_id = objekatt_id;
        this.voziilo_id = voziilo_id;
        this.korisnik_id = korisnik_id;
    }

    public Putovanje(int putovanje_id, LocalDate datum_kretanja, LocalTime vreme_kretanja, int objekatt_id, int voziilo_id) {
        this.putovanje_id = putovanje_id;
        this.datum_kretanja = datum_kretanja;
        this.vreme_kretanja = vreme_kretanja;
        this.objekatt_id = objekatt_id;
        this.voziilo_id = voziilo_id;
    }

    public Putovanje(int putovanje_id, LocalDate datum_kretanja, int objekatt_id) {
        this.putovanje_id = putovanje_id;
        this.datum_kretanja = datum_kretanja;
        this.objekatt_id = objekatt_id;
    }

    public int getPutovanje_id() {
        return putovanje_id;
    }

    public LocalDate getDatum_kretanja() {
        return datum_kretanja;
    }

    public void setDatum_kretanja(LocalDate datum_kretanja) {
        this.datum_kretanja = datum_kretanja;
    }

    public LocalTime getVreme_kretanja() {
        return vreme_kretanja;
    }

    public void setVreme_kretanja(LocalTime vreme_kretanja) {
        this.vreme_kretanja = vreme_kretanja;
    }

    public int getObjekatt_id() {
        return objekatt_id;
    }

    public void setObjekatt_id(int objekatt_id) {
        this.objekatt_id = objekatt_id;
    }

    public int getVoziilo_id() {
        return voziilo_id;
    }

    public void setVoziilo_id(int voziilo_id) {
        this.voziilo_id = voziilo_id;
    }

    public int getKorisnik_id() {
        return korisnik_id;
    }

    public void setKorisnik_id(int korisnik_id) {
        this.korisnik_id = korisnik_id;
    }

    public boolean isDostupnost() {
        return dostupnost;
    }

    public void setDostupnost(boolean dostupnost) {
        this.dostupnost = dostupnost;
    }
}
