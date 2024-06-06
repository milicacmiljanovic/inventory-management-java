package person.model;

import java.util.Objects;

public class FlightPlaneCombo {

    private Putovanje putovanje;
    private Vozilo vozilo;

    public FlightPlaneCombo(Putovanje putovanje, Vozilo vozilo) {
        this.putovanje = putovanje;
        this.vozilo = vozilo;
    }

    public Putovanje getPutovanje() {
        return putovanje;
    }

    public void setPutovanje(Putovanje putovanje) {
        this.putovanje = putovanje;
    }

    public Vozilo getVozilo() {
        return vozilo;
    }

    public void setVozilo(Vozilo vozilo) {
        this.vozilo = vozilo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlightPlaneCombo that = (FlightPlaneCombo) o;
        return Objects.equals(putovanje, that.putovanje) && Objects.equals(vozilo, that.vozilo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(putovanje, vozilo);
    }

    @Override
    public String toString() {
        return "FlightPlaneCombo{" +
                "putovanje=" + putovanje +
                ", vozilo=" + vozilo +
                '}';
    }
}
