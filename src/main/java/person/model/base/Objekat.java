package person.model.base;

public class Objekat {

    private final int objekat_id;
    private String naziv;
    private String vrsta;
    private int udaljenost_od_zvezde;
    private int najniza_temperatura;
    private int najvisa_temperatura;
    private int kiseonik;  //proveriti da li treba neka vrednost za decimal
    private String drugi_gas;
    private int kolicina_drugog_gasa; //isto
    private int visina;
    private int brzina_orbitiranja;
    private int broj_umrlih;

    public Objekat(int objekat_id, String naziv, String vrsta, int udaljenost_od_zvezde, int najniza_temperatura, int najvisa_temperatura, int kiseonik, String drugi_gas, int kolicina_drugog_gasa, int visina, int brzina_orbitiranja, int broj_umrlih) {
        this.objekat_id = objekat_id;
        this.naziv = naziv;
        this.vrsta = vrsta;
        this.udaljenost_od_zvezde = udaljenost_od_zvezde;
        this.najniza_temperatura = najniza_temperatura;
        this.najvisa_temperatura = najvisa_temperatura;
        this.kiseonik = kiseonik;
        this.drugi_gas = drugi_gas;
        this.kolicina_drugog_gasa = kolicina_drugog_gasa;
        this.visina = visina;
        this.brzina_orbitiranja = brzina_orbitiranja;
        this.broj_umrlih = broj_umrlih;
    }

    public int getObjekat_id() {
        return objekat_id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getVrsta() {
        return vrsta;
    }

    public void setVrsta(String vrsta) {
        this.vrsta = vrsta;
    }

    public int getUdaljenost_od_zvezde() {
        return udaljenost_od_zvezde;
    }

    public void setUdaljenost_od_zvezde(int udaljenost_od_zvezde) {
        this.udaljenost_od_zvezde = udaljenost_od_zvezde;
    }

    public int getNajniza_temperatura() {
        return najniza_temperatura;
    }

    public void setNajniza_temperatura(int najniza_temperatura) {
        this.najniza_temperatura = najniza_temperatura;
    }

    public int getNajvisa_temperatura() {
        return najvisa_temperatura;
    }

    public void setNajvisa_temperatura(int najvisa_temperatura) {
        this.najvisa_temperatura = najvisa_temperatura;
    }

    public int getKiseonik() {
        return kiseonik;
    }

    public void setKiseonik(int kiseonik) {
        this.kiseonik = kiseonik;
    }

    public String getDrugi_gas() {
        return drugi_gas;
    }

    public void setDrugi_gas(String drugi_gas) {
        this.drugi_gas = drugi_gas;
    }

    public int getKolicina_drugog_gasa() {
        return kolicina_drugog_gasa;
    }

    public void setKolicina_drugog_gasa(int kolicina_drugog_gasa) {
        this.kolicina_drugog_gasa = kolicina_drugog_gasa;
    }

    public int getVisina() {
        return visina;
    }

    public void setVisina(int visina) {
        this.visina = visina;
    }

    public int getBrzina_orbitiranja() {
        return brzina_orbitiranja;
    }

    public void setBrzina_orbitiranja(int brzina_orbitiranja) {
        this.brzina_orbitiranja = brzina_orbitiranja;
    }

    public int getBroj_umrlih() {
        return broj_umrlih;
    }

    public void setBroj_umrlih(int broj_umrlih) {
        this.broj_umrlih = broj_umrlih;
    }
}
