package person.model.base;

public class StambeniObjekat {
    private final int stambeni_objekat_id;
    private String vrsta_stambenog_objekta;
    private int kvadratura;
    private int broj_stanara;
    private boolean dostupnost = true;

    public StambeniObjekat(int stambeni_objekat_id, String vrsta_stambenog_objekta, int kvadratura, int broj_stanara, boolean dostupnost) {
        this.stambeni_objekat_id = stambeni_objekat_id;
        this.vrsta_stambenog_objekta = vrsta_stambenog_objekta;
        this.kvadratura = kvadratura;
        this.broj_stanara = broj_stanara;
        this.dostupnost = dostupnost;
    }

    public int getStambeni_objekat_id() {
        return stambeni_objekat_id;
    }

    public String getVrsta_stambenog_objekta() {
        return vrsta_stambenog_objekta;
    }

    public void setVrsta_stambenog_objekta(String vrsta_stambenog_objekta) {
        this.vrsta_stambenog_objekta = vrsta_stambenog_objekta;
    }

    public int getKvadratura() {
        return kvadratura;
    }

    public void setKvadratura(int kvadratura) {
        this.kvadratura = kvadratura;
    }

    public int getBroj_stanara() {
        return broj_stanara;
    }

    public void setBroj_stanara(int broj_stanara) {
        this.broj_stanara = broj_stanara;
    }

    public boolean isDostupnost() {
        return dostupnost;
    }

    public void setDostupnost(boolean dostupnost) {
        this.dostupnost = dostupnost;
    }
}
