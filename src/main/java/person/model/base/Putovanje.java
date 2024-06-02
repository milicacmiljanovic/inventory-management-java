package person.model.base;

import java.time.LocalDate;

public class Putovanje {
    private final int putovanje_id;
    private LocalDate datum_kretanja;

    public Putovanje(int putovanje_id, LocalDate datum_kretanja) {
        this.putovanje_id = putovanje_id;
        this.datum_kretanja = datum_kretanja;
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
}
