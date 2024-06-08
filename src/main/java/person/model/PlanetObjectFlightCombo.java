package person.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class PlanetObjectFlightCombo {
    private String planeta_naziv;
    private String objekat_naziv;
    private  String prevozno_sredstvo;
    private String datum;
    private String vreme;

    private Putovanje putovanje;
    private Vozilo vozilo;
    private Objekat objekat;
    private StambeniObjekat stambeniObjekat;

    public PlanetObjectFlightCombo(String planeta_naziv, String objekat_naziv, String prevozno_sredstvo,
                                   LocalDate datum, LocalTime vreme) {
        this.planeta_naziv = planeta_naziv;
        this.objekat_naziv = objekat_naziv;
        this.prevozno_sredstvo = prevozno_sredstvo;
        this.datum = datum.toString();
        this.vreme = vreme.toString();
    }

    public PlanetObjectFlightCombo(Putovanje putovanje, Vozilo vozilo, Objekat objekat, StambeniObjekat stambeniObjekat) {
        this.putovanje = putovanje;
        this.vozilo = vozilo;
        this.objekat = objekat;
        this.stambeniObjekat = stambeniObjekat;

    }

    public String getPlaneta_naziv() {
        return planeta_naziv;
    }

    public void setPlaneta_naziv(String planeta_naziv) {
        this.planeta_naziv = planeta_naziv;
    }

    public String getObjekat_naziv() {
        return objekat_naziv;
    }

    public void setObjekat_naziv(String objekat_naziv) {
        this.objekat_naziv = objekat_naziv;
    }

    public String getPrevozno_sredstvo() {
        return prevozno_sredstvo;
    }

    public void setPrevozno_sredstvo(String prevozno_sredstvo) {
        this.prevozno_sredstvo = prevozno_sredstvo;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public String getVreme() {
        return vreme;
    }

    public void setVreme(String vreme) {
        this.vreme = vreme;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlanetObjectFlightCombo that = (PlanetObjectFlightCombo) o;
        return Objects.equals(planeta_naziv, that.planeta_naziv) && Objects.equals(objekat_naziv, that.objekat_naziv) && Objects.equals(prevozno_sredstvo, that.prevozno_sredstvo) && Objects.equals(datum, that.datum) && Objects.equals(vreme, that.vreme) && Objects.equals(putovanje, that.putovanje) && Objects.equals(vozilo, that.vozilo) && Objects.equals(objekat, that.objekat) && Objects.equals(stambeniObjekat, that.stambeniObjekat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(planeta_naziv, objekat_naziv, prevozno_sredstvo, datum, vreme, putovanje, vozilo, objekat, stambeniObjekat);
    }

    @Override
    public String toString() {
        return "PlanetObjectFlightCombo{" +
                "planeta_naziv='" + planeta_naziv + '\'' +
                ", objekat_naziv='" + objekat_naziv + '\'' +
                ", prevozno_sredstvo='" + prevozno_sredstvo + '\'' +
                ", datum='" + datum + '\'' +
                ", vreme='" + vreme + '\'' +
                ", putovanje=" + putovanje +
                ", vozilo=" + vozilo +
                ", objekat=" + objekat +
                ", stambeniObjekat=" + stambeniObjekat +
                '}';
    }
}
