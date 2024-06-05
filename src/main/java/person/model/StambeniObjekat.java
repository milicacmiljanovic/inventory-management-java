package person.model;

public class StambeniObjekat {
    private final int stambeniObjekatId;
    private String vrstaStambenogObjekta;
    private int kvadratura;
    private int brojStanara;
    private boolean dostupnost = true;
    private int objekat_id;

    public StambeniObjekat(int stambeniObjekatId, String vrstaStambenogObjekta, int kvadratura, int brojStanara, boolean dostupnost) {
        this.stambeniObjekatId = stambeniObjekatId;
        this.vrstaStambenogObjekta = vrstaStambenogObjekta;
        this.kvadratura = kvadratura;
        this.brojStanara = brojStanara;
        this.dostupnost = dostupnost;
    }

    public StambeniObjekat(int stambeniObjekatId, String vrstaStambenogObjekta, int kvadratura, int brojStanara, boolean dostupnost, int objekat_id) {
        this.stambeniObjekatId = stambeniObjekatId;
        this.vrstaStambenogObjekta = vrstaStambenogObjekta;
        this.kvadratura = kvadratura;
        this.brojStanara = brojStanara;
        this.dostupnost = dostupnost;
        this.objekat_id = objekat_id;
    }

    public int getStambeniObjekatId() {
        return stambeniObjekatId;
    }

    public String getVrsta_stambenog_objekta() {
        return vrstaStambenogObjekta;
    }

    public void setVrstaStambenogObjekta(String vrstaStambenogObjekta) {
        this.vrstaStambenogObjekta = vrstaStambenogObjekta;
    }

    public int getKvadratura() {
        return kvadratura;
    }

    public void setKvadratura(int kvadratura) {
        this.kvadratura = kvadratura;
    }

    public int getBrojStanara() {
        return brojStanara;
    }

    public void setBrojStanara(int broj_stanara) {
        this.brojStanara = brojStanara;
    }

    public boolean isDostupnost() {
        return dostupnost;
    }

    public void setDostupnost(boolean dostupnost) {
        this.dostupnost = dostupnost;
    }

    public String getVrstaStambenogObjekta() {
        return vrstaStambenogObjekta;
    }

    public int getObjekat_id() {
        return objekat_id;
    }

    public void setObjekat_id(int objekat_id) {
        this.objekat_id = objekat_id;
    }
}
