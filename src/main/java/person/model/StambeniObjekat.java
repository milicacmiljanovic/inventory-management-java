package person.model;

public class StambeniObjekat {
    private int stambeni_objekat_id;
    private String vrsta_stambenog_objekta;
    private int kvadratura;
    private int broj_stanara;
    private boolean dostupnost;
    private int objekkat_id;

    // Constructor, getters, setters
    public StambeniObjekat(int stambeni_objekat_id, String vrsta_stambenog_objekta, int kvadratura, int broj_stanara, boolean dostupnost) {
        this.stambeni_objekat_id = stambeni_objekat_id;
        this.vrsta_stambenog_objekta = vrsta_stambenog_objekta;
        this.kvadratura = kvadratura;
        this.broj_stanara = broj_stanara;
        this.dostupnost = dostupnost;
    }

    public StambeniObjekat(String vrsta_stambenog_objekta, int kvadratura, int broj_stanara, int objekkat_id) {
        this.vrsta_stambenog_objekta = vrsta_stambenog_objekta;
        this.kvadratura = kvadratura;
        this.broj_stanara = broj_stanara;
        this.objekkat_id = objekkat_id;
    }

    public StambeniObjekat(int stambeni_objekat_id, String vrsta_stambenog_objekta, int kvadratura, int broj_stanara, boolean dostupnost, int objekkat_id) {
        this.stambeni_objekat_id = stambeni_objekat_id;
        this.vrsta_stambenog_objekta = vrsta_stambenog_objekta;
        this.kvadratura = kvadratura;
        this.broj_stanara = broj_stanara;
        this.dostupnost = dostupnost;
        this.objekkat_id = objekkat_id;
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

    public int getObjekkat_id() {
        return objekkat_id;
    }

    public void setObjekkat_id(int objekkat_id) {
        this.objekkat_id = objekkat_id;
    }



}