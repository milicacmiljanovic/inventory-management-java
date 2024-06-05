package person.model;


import java.util.Objects;

public class MissionPlanetCombo {

    private Misija misija;
    private Objekat objekat;

    public MissionPlanetCombo(Misija misija, Objekat objekat) {
        this.misija = misija;
        this.objekat = objekat;
    }

    public Misija getMisija() {
        return misija;
    }

    public void setMisija(Misija misija) {
        this.misija = misija;
    }

    public String getMissionName() {
        return misija != null ? misija.getNaziv_misije() : null;
    }

    public Objekat getObjekat() {
        return objekat;
    }

    public void setObjekat(Objekat objekat) {
        this.objekat = objekat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MissionPlanetCombo that = (MissionPlanetCombo) o;
        return Objects.equals(misija, that.misija) && Objects.equals(objekat, that.objekat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(misija, objekat);
    }

    @Override
    public String toString() {
        return "MissionPlanetWrapper{" +
                "misija=" + misija +
                ", objekat=" + objekat +
                '}';
    }

}
