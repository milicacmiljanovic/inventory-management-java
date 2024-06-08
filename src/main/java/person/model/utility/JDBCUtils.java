package person.model.utility;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import person.model.*;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class JDBCUtils {

    public static Connection connection = null;

    public static void connect() {
        Properties properties = new Properties();
        properties.put("user", "root");
        properties.put("password", "");
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/zus", properties);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }




    public static List<Korisnici> selectAllFromZus() {
        List<Korisnici> korisnici = new ArrayList<>();
        String query = "select * from zus.korisnici"; //ovde ne treba *
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int korisnikId = resultSet.getInt(1);
                String ime = resultSet.getString(2);
                String prezime = resultSet.getString(3);;
                LocalDate datumRodjenja = resultSet.getDate(6).toLocalDate();
                Korisnici korisnik = new Korisnici(korisnikId, ime, prezime, datumRodjenja);
                korisnici.add(korisnik);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return korisnici;
    }
    public static List<Objekat> selectObjekatFromZus() {
        List<Objekat> objekti = new ArrayList<>();
        String query = "select o.objekat_id, o.naziv, o.vrsta, count(m.misija_id) as broj_misija " +
                "from zus.objekti o " +
                "left join zus.misije m on o.objekat_id = m.objekaat_id " +
                "group by o.objekat_id, o.naziv, o.vrsta";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int objekat_id = resultSet.getInt("objekat_id");
                String naziv = resultSet.getString("naziv");
                String vrsta = resultSet.getString("vrsta");
                int broj_misija = resultSet.getInt("broj_misija");
                Objekat objekat = new Objekat(objekat_id, naziv, vrsta, broj_misija); // Assuming Objekat has a constructor that includes broj_misija
                objekti.add(objekat);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return objekti;
    }

    public static List<Objekat> selectDetaljanObjekatFromZus(){
        List<Objekat> objekti = new ArrayList<>();
        String query = "select * from zus.objekti o join zus.misije m on(o.objekat_id = m.objekaat_id) ";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int objekat_id = resultSet.getInt(1);
                String naziv = resultSet.getString(2);
                String vrsta = resultSet.getString(3);
                int udaljenost_od_planete = resultSet.getInt(4);
                int najniza_temperatura = resultSet.getInt(5);
                int najvisa_temperatura = resultSet.getInt(6);
                int kiseonik = resultSet.getInt(7);
                String drugi_gas = resultSet.getString(8);
                int kolicina_drugog_gasa = resultSet.getInt(9);
                int visina = resultSet.getInt(10);
                int brzina_orbitiranja = resultSet.getInt(11);
                int broj_umrlih = resultSet.getInt(12);
                Objekat objekat = new Objekat(objekat_id,naziv, vrsta, udaljenost_od_planete, najniza_temperatura, najvisa_temperatura, kiseonik, drugi_gas, kolicina_drugog_gasa,visina, brzina_orbitiranja, broj_umrlih);
                objekti.add(objekat);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return objekti;
    }

    public static List<StambeniObjekat> selectAvailableStambeniObjekatFromZus() {
        List<StambeniObjekat> stambeniObjekti = new ArrayList<>();
        String query = "SELECT * FROM zus.stambeni_objekti WHERE dostupnost = 1";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int stambeni_objekat_id = resultSet.getInt("stambeni_objekat_id");
                String vrsta_stambenog_objekta = resultSet.getString("vrsta_stambenog_objekta");
                int kvadratura = resultSet.getInt("kvadratura");
                int broj_stanara = resultSet.getInt("broj_stanara");
                boolean dostupnost = resultSet.getBoolean("dostupnost");
                StambeniObjekat stambeni = new StambeniObjekat(stambeni_objekat_id, vrsta_stambenog_objekta, kvadratura, broj_stanara, dostupnost);
                stambeniObjekti.add(stambeni);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return stambeniObjekti;
    }

    public static boolean updateStambeniObjekatAvailability(int stambeniObjekatId, boolean newAvailability) {
        String query = "UPDATE stambeni_objekti SET dostupnost = ? WHERE stambeni_objekat_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setBoolean(1, newAvailability);
            statement.setInt(2, stambeniObjekatId);
            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean updateDostupnost(int putovanje_id, boolean dostupnost) {
        String query = "UPDATE putovanja SET dostupnost = ? WHERE putovanje_id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setBoolean(1, dostupnost);
            preparedStatement.setInt(2, putovanje_id);
            int affectedRows = preparedStatement.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static List<FlightPlaneCombo> selectSelectFlightPlane() {

        String query = "SELECT " +
                "p.putovanje_id, p.datum_kretanja, p.vreme_kretanja, p.dostupnost, p.objekatt_id, p.voziilo_id, p.korisnik_id, " +
                "v.vozilo_id, v.sifra_vozila, v.vrsta_vozila, v.broj_dozvoljenih_putnika " +
                "FROM putovanja p " +
                "JOIN vozilo v ON p.voziilo_id = v.vozilo_id ";
        List<FlightPlaneCombo> flightPlaneCombos = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int putovanjeId = resultSet.getInt(1);
                LocalDate datum = resultSet.getDate(2).toLocalDate();
                String vreme = resultSet.getString(3);
                LocalTime localTime = LocalTime.of(Integer.parseInt(vreme.split(":")[0]),
                        Integer.parseInt(vreme.split(":")[1]));
                boolean dostupnost = resultSet.getBoolean(4);
                int objekatId = resultSet.getInt(5);
                int prevoznoSredstvo = resultSet.getInt(6);
                int korisnikId = resultSet.getInt(7);

                int voziloId = resultSet.getInt(8);
                int sifra = resultSet.getInt(9);
                String tip = resultSet.getString(10);
                int kapacitet = resultSet.getInt(11);

                Putovanje putovanje = new Putovanje(putovanjeId, datum, localTime, dostupnost, objekatId, prevoznoSredstvo, korisnikId);
                Vozilo vozilo = new Vozilo(voziloId, sifra, tip, kapacitet);

                FlightPlaneCombo flightPlaneCombo = new FlightPlaneCombo(putovanje, vozilo);
                flightPlaneCombos.add(flightPlaneCombo);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return flightPlaneCombos;
    }

/*
    public static List<StambeniObjekat> selectStambeniObjekatByObjekatId(int objekatId) {
        List<StambeniObjekat> stambeniObjekti = new ArrayList<>();
        String query = "SELECT * FROM zus.stambeni_objekti WHERE objekat_id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, objekatId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int stambeniObjekatId = resultSet.getInt("stambeni_objekat_id");
                    String vrstaStambenogObjekta = resultSet.getString("vrsta_stambenog_objekta");
                    int kvadratura = resultSet.getInt("kvadratura");
                    int brojStanara = resultSet.getInt("broj_stanara");
                    boolean dostupnost = resultSet.getBoolean("dostupnost");
                    StambeniObjekat stambeni = new StambeniObjekat(stambeniObjekatId, vrstaStambenogObjekta, kvadratura, brojStanara, dostupnost, objekatId);
                    stambeniObjekti.add(stambeni);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return stambeniObjekti;
    }

 */
    public static List<Korisnici> selectFromPerson(String firstName, String lastName, String yearOfBirth) {
        List<Korisnici> korisnici = new ArrayList<>();
        StringBuilder query = new StringBuilder("SELECT * FROM zus.korisnici WHERE 1=1");

        if (firstName != null && !firstName.isEmpty()) {
            query.append(" AND ime LIKE ?");
        }
        if (lastName != null && !lastName.isEmpty()) {
            query.append(" AND prezime LIKE ?");
        }
        if (yearOfBirth != null && yearOfBirth.length() == 4) {
            query.append(" AND YEAR(datum_rodjenja) = ?");
        }

        try (PreparedStatement preparedStatement = connection.prepareStatement(query.toString())) {
            int index = 1;

            if (firstName != null && !firstName.isEmpty()) {
                preparedStatement.setString(index++, "%" + firstName + "%");
            }
            if (lastName != null && !lastName.isEmpty()) {
                preparedStatement.setString(index++, "%" + lastName + "%");
            }
            if (yearOfBirth != null && yearOfBirth.length() == 4) {
                preparedStatement.setInt(index, Integer.parseInt(yearOfBirth));
            }

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int korisnikId = resultSet.getInt(1);
                String ime = resultSet.getString(2);
                String prezime = resultSet.getString(3);
                LocalDate datumRodjenja = resultSet.getDate(6).toLocalDate();
                Korisnici korisnik = new Korisnici(korisnikId, ime, prezime, datumRodjenja);
                korisnici.add(korisnik);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return korisnici;
    }


    public static List<Objekat> selectFromPlanet(String nameFilter) {
        List<Objekat> objekti = new ArrayList<>();
        String query = "SELECT o.objekat_id, o.naziv, o.vrsta, COUNT(m.misija_id) AS broj_misija " +
                "FROM zus.objekti o " +
                "LEFT JOIN zus.misije m ON o.objekat_id = m.objekaat_id " +
                "WHERE o.naziv LIKE ? " +
                "GROUP BY o.objekat_id, o.naziv, o.vrsta";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, "%" + nameFilter + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int objekat_id = resultSet.getInt("objekat_id");
                String naziv = resultSet.getString("naziv");
                String vrsta = resultSet.getString("vrsta");
                int broj_misija = resultSet.getInt("broj_misija");
                Objekat objekat = new Objekat(objekat_id, naziv, vrsta, broj_misija);
                objekti.add(objekat);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return objekti;
    }


    public static List<MissionPlanetCombo> selectAllMissionsAndObjects() {
        List<MissionPlanetCombo> combinedList = new ArrayList<>();
        String query = "SELECT " +
                "o.objekat_id, o.naziv, o.vrsta, o.udaljenost_od_zvezde, o.najniza_temperatura, " +
                "o.najvisa_temperatura, o.kiseonik, o.drugi_gas, o.kolicina_drugog_gasa, o.visina, " +
                "o.brzina_orbitiranja, o.broj_umrlih, " +
                "m.misija_id, m.naziv_misije, m.datum_polaska, m.datum_povratka " +
                "FROM zus.objekti o " +
                "JOIN zus.misije m ON o.objekat_id = m.objekaat_id";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                int objekat_id = resultSet.getInt("objekat_id");
                String naziv = resultSet.getString("naziv");
                String vrsta = resultSet.getString("vrsta");
                int udaljenost_od_zvezde = resultSet.getInt("udaljenost_od_zvezde");
                int najniza_temperatura = resultSet.getInt("najniza_temperatura");
                int najvisa_temperatura = resultSet.getInt("najvisa_temperatura");
                int kiseonik = resultSet.getInt("kiseonik");
                String drugi_gas = resultSet.getString("drugi_gas");
                int kolicina_drugog_gasa = resultSet.getInt("kolicina_drugog_gasa");
                int visina = resultSet.getInt("visina");
                int brzina_orbitiranja = resultSet.getInt("brzina_orbitiranja");
                int broj_umrlih = resultSet.getInt("broj_umrlih");

                Objekat objekat = new Objekat(objekat_id, naziv, vrsta, udaljenost_od_zvezde, najniza_temperatura, najvisa_temperatura, kiseonik, drugi_gas, kolicina_drugog_gasa, visina, brzina_orbitiranja, broj_umrlih);

                int misija_id = resultSet.getInt("misija_id");
                String naziv_misije = resultSet.getString("naziv_misije");
                LocalDate datum_polaska = resultSet.getDate("datum_polaska").toLocalDate();
                LocalDate datum_povratka = resultSet.getDate("datum_povratka").toLocalDate();
                Misija misija = new Misija(misija_id, naziv_misije, datum_polaska, datum_povratka);
                combinedList.add(new MissionPlanetCombo(misija, objekat));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return combinedList;
    }

    public static List<MissionPlanetCombo> selectHabitableMissionsAndObjects() {
        List<MissionPlanetCombo> combinedList = new ArrayList<>();
        String query = "SELECT " +
                "o.objekat_id, o.naziv, o.vrsta, o.udaljenost_od_zvezde, o.najniza_temperatura, " +
                "o.najvisa_temperatura, o.kiseonik, o.drugi_gas, o.kolicina_drugog_gasa, o.visina, " +
                "o.brzina_orbitiranja, o.broj_umrlih, " +
                "m.misija_id, m.naziv_misije, m.datum_polaska, m.datum_povratka " +
                "FROM zus.objekti o " +
                "JOIN zus.misije m ON o.objekat_id = m.objekaat_id " +
                "WHERE " +
                "o.udaljenost_od_zvezde BETWEEN 100000000 AND 200000000 " +
                "AND o.najniza_temperatura BETWEEN 150 AND 250 " +
                "AND o.najvisa_temperatura BETWEEN 250 AND 350 " +
                "AND (o.najvisa_temperatura - o.najniza_temperatura) <= 120 " +
                "AND o.kiseonik BETWEEN 15 AND 25 " +
                "AND (o.kiseonik + o.kolicina_drugog_gasa) BETWEEN 90 AND 99.99 " +
                "AND o.visina >= 1000 " +
                "AND o.brzina_orbitiranja BETWEEN 25 AND 35 " +
                "AND o.broj_umrlih <= 20";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                int objekat_id = resultSet.getInt("objekat_id");
                String naziv = resultSet.getString("naziv");
                String vrsta = resultSet.getString("vrsta");
                int udaljenost_od_zvezde = resultSet.getInt("udaljenost_od_zvezde");
                int najniza_temperatura = resultSet.getInt("najniza_temperatura");
                int najvisa_temperatura = resultSet.getInt("najvisa_temperatura");
                double kiseonik = resultSet.getDouble("kiseonik"); // Changed to double
                String drugi_gas = resultSet.getString("drugi_gas");
                double kolicina_drugog_gasa = resultSet.getDouble("kolicina_drugog_gasa");
                int visina = resultSet.getInt("visina");
                int brzina_orbitiranja = resultSet.getInt("brzina_orbitiranja");
                int broj_umrlih = resultSet.getInt("broj_umrlih");

                Objekat objekat = new Objekat(objekat_id, naziv, vrsta, udaljenost_od_zvezde, najniza_temperatura, najvisa_temperatura, (int) kiseonik, drugi_gas, (int) kolicina_drugog_gasa, visina, brzina_orbitiranja, broj_umrlih);

                int misija_id = resultSet.getInt("misija_id");
                String naziv_misije = resultSet.getString("naziv_misije");
                LocalDate datum_polaska = resultSet.getDate("datum_polaska").toLocalDate();
                LocalDate datum_povratka = resultSet.getDate("datum_povratka").toLocalDate();
                Misija misija = new Misija(misija_id, naziv_misije, datum_polaska, datum_povratka);
                combinedList.add(new MissionPlanetCombo(misija, objekat));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return combinedList;
    }

    public static ObservableList<StambeniObjekat> prikazStambeniObjekat(int objekat_id) {
        String query = "SELECT * FROM stambeni_objekti s WHERE s.objekkat_id = " + objekat_id + " AND s.dostupnost = 1";
        ObservableList<StambeniObjekat> stambeniObjekti = FXCollections.observableArrayList();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int stambeni_objekat_id = resultSet.getInt("stambeni_objekat_id");
                String vrsta_stambenog_objekta = resultSet.getString("vrsta_stambenog_objekta");
                int kvadratura = resultSet.getInt("kvadratura");
                int broj_stanara = resultSet.getInt("broj_stanara");
                boolean dostupnost = resultSet.getBoolean("dostupnost");
                int objekkat_id = resultSet.getInt("objekkat_id");
                StambeniObjekat s = new StambeniObjekat(stambeni_objekat_id, vrsta_stambenog_objekta, kvadratura, broj_stanara, dostupnost, objekkat_id);
                stambeniObjekti.add(s);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return stambeniObjekti;
    }

    public static ObservableList<FlightPlaneCombo> selectFromVoziloAndPutanja(int objekat_id) {
        String query = "SELECT " +
                "p.putovanje_id, p.datum_kretanja, p.vreme_kretanja, p.dostupnost, p.objekatt_id, p.voziilo_id, p.korisnik_id, " +
                "v.vozilo_id, v.sifra_vozila, v.vrsta_vozila, v.broj_dozvoljenih_putnika " +
                "FROM putovanja p " +
                "JOIN vozilo v ON p.voziilo_id = v.vozilo_id " +
                "WHERE p.objekatt_id = " + objekat_id + " AND p.dostupnost = 1";
        ObservableList<FlightPlaneCombo> flightPlaneCombos = FXCollections.observableArrayList();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int putovanje_id = resultSet.getInt("putovanje_id");
                LocalDate datum_kretanja = resultSet.getDate("datum_kretanja").toLocalDate();
                String vreme_kretanja = resultSet.getString("vreme_kretanja");
                LocalTime localTime = LocalTime.of(
                        Integer.parseInt(vreme_kretanja.split(":")[0]),
                        Integer.parseInt(vreme_kretanja.split(":")[1])
                );
                boolean dostupnost = resultSet.getBoolean("dostupnost");
                int objekatt_id = resultSet.getInt("objekatt_id");
                int prevoznoSredstvo = resultSet.getInt("voziilo_id");
                int korisnikID = resultSet.getInt("korisnik_id");

                int voziloId = resultSet.getInt("vozilo_id");
                int sifra = resultSet.getInt("sifra_vozila");
                String tip = resultSet.getString("vrsta_vozila");
                int kapacitet = resultSet.getInt("broj_dozvoljenih_putnika");

                Putovanje putovanje = new Putovanje(putovanje_id, datum_kretanja, localTime, dostupnost, objekatt_id, prevoznoSredstvo, korisnikID);
                Vozilo vozilo = new Vozilo(voziloId, sifra, tip, kapacitet);

                FlightPlaneCombo fp = new FlightPlaneCombo(putovanje, vozilo);
                flightPlaneCombos.add(fp);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return flightPlaneCombos;
    }

/*
    public static ObservableList<FlightPlaneCombo> selectFromVoziloAndPutanja(int objekat_id) {
        String query = "SELECT " +
                "p.putovanje_id, p.datum_kretanja, p.vreme_kretanja, p.objekatt_id, p.voziilo_id, p.korisnik_id" +
                "v.vozilo_id, v.sifra_vozila, v.vrsta_vozila, v.broj_dozvoljenih_putnika" +
                "FROM putovanja p " +
                "JOIN vozilo v ON p.voziilo_id = v.vozilo_id"+
                "where p.objekatt_id" + objekat_id;
        ObservableList<FlightPlaneCombo> flightPlaneCombos = FXCollections.observableArrayList();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int putovanjeId = resultSet.getInt("putovanje_id");
                LocalDate datum = resultSet.getDate("datum_kretanja").toLocalDate();
                LocalTime vreme = resultSet.getTime("vreme_kretanja").toLocalTime();
                int objekatId = resultSet.getInt("objekatt_id");
                int prevoznoSredstvo = resultSet.getInt("voziilo_id");
                int korisnikID = resultSet.getInt("korisnik_id");

                int voziloId = resultSet.getInt("vozilo_id");
                int sifra = resultSet.getInt("sifra_vozila");
                String tip = resultSet.getString("vrsta_vozila");
                int kapacitet = resultSet.getInt("broj_dozvoljenih_putnika");

                Putovanje putovanje = new Putovanje(putovanjeId, datum, vreme, objekatId, prevoznoSredstvo, korisnikID);
                Vozilo vozilo = new Vozilo(voziloId, sifra, tip, kapacitet);

                FlightPlaneCombo flightPlaneCombo = new FlightPlaneCombo(putovanje, vozilo);
                flightPlaneCombos.add(flightPlaneCombo);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return flightPlaneCombos;
    }

 */

    public static List<Osobe> selectOsobeFromZus() {
        List<Osobe> osobe = new ArrayList<>();
        String query = "select * from zus.osobe"; //ovde ne treba *
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String ime = resultSet.getString(1);
                String prezime = resultSet.getString(2);;
                LocalDate godine = resultSet.getDate(3).toLocalDate();
                Osobe osobee = new Osobe(ime, prezime, godine);
                osobe.add(osobee);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return osobe;
    }

    public static List<Kupljeno> selectFromKupljeno() {
        List<Kupljeno> kupljeno = new ArrayList<>();
        String query = "select * from zus.kupljeno"; //ovde ne treba *
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int stambeni_objekat_id = resultSet.getInt(1);
                String vrsta_stambenog_objekta = resultSet.getString(2);
                LocalDate datum_kretanja = resultSet.getDate(3).toLocalDate();
                Kupljeno kupljenoo = new Kupljeno(stambeni_objekat_id, vrsta_stambenog_objekta, datum_kretanja);
                kupljeno.add(kupljenoo);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return kupljeno;
    }



    public static void insertIntoZus(Korisnici korisnik) {
        String query = "insert into zus.korisnici (ime, prezime, username, password, datum_rodjenja) " +
                "select ?, ?, ?, ?, STR_TO_DATE(?, '%m/%d/%Y') " +
                "from dual " +
                "where not exists ( " +
                "select 1 from zus.korisnici WHERE username = ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            connection.setAutoCommit(false);
            statement.setString(1, korisnik.getIme());
            statement.setString(2, korisnik.getPrezime());
            statement.setString(3, korisnik.getUsername());
            statement.setString(4, korisnik.getPassword());
            statement.setString(5, korisnik.getDatum_rodjenja().getMonthValue() + "/" +
                    korisnik.getDatum_rodjenja().getDayOfMonth() + "/" +
                    korisnik.getDatum_rodjenja().getYear());
            statement.setString(6, korisnik.getUsername());

            int rowsAffected = statement.executeUpdate();
            connection.commit();

            if (rowsAffected > 0) {
                System.out.println("User inserted successfully.");
            } else {
                System.out.println("User with this username already exists.");
            }
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            throw new RuntimeException(e);
        }
    }

    public static void insertIntoZusOsobe(Osobe osobe) {
        String query = "insert into zus.osobe (Ime, Prezime, Godine) " +
                "values (?, ?, STR_TO_DATE(?, '%m/%d/%Y'))";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            connection.setAutoCommit(false);
            statement.setString(1, osobe.getIme());
            statement.setString(2, osobe.getPrezime());
            statement.setString(3, osobe.getGodine().getMonthValue() + "/" +
                    osobe.getGodine().getDayOfMonth() + "/" +
                    osobe.getGodine().getYear());

            int rowsAffected = statement.executeUpdate();
            connection.commit();

            if (rowsAffected > 0) {
                System.out.println("User inserted successfully.");
            } else {
                System.out.println("User with this username already exists.");
            }
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            throw new RuntimeException(e);
        }
    }


    public static int getNextKorisnikId() {
        String query = "SELECT MAX(korisnik_id) FROM zus.korisnici";
        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            if (resultSet.next()) {
                return resultSet.getInt(1) + 1;
            } else {
                return 1;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving next korisnik_id", e);
        }
    }

    public static List<Kupovina> selectKupovineFromZus() {
        List<Kupovina> kupovina = new ArrayList<>();
        String query = "select * from zus.kupovine"; //ovde ne treba *
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int kupovina_id = resultSet.getInt(1);
                int stambeni_objekat_id = resultSet.getInt(2);;
                int putovanje_id = resultSet.getInt(3);
                int koorisnik_id = resultSet.getInt(4);
                Kupovina kupovine = new Kupovina(kupovina_id, stambeni_objekat_id, putovanje_id, koorisnik_id);
                kupovina.add(kupovine);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return kupovina;
    }

    public static void insertIntoKupovina(int korisnik_id, int objekat_id, int putovanje_id) {
        String query = "insert into kupovine (korisnik_id, objekat_id,putovanje_id) " +
                "values (?, ?, ?)";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            connection.setAutoCommit(false);
            statement.setInt(1,korisnik_id);
            statement.setInt(2,objekat_id);
            statement.setInt(3,putovanje_id);
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<PlanetObjectFlightCombo> selectFromIntoPlanetObjectFlightCombo(){
        ObservableList<PlanetObjectFlightCombo> planeteObjekatiPutovanja = FXCollections.observableArrayList();
        String query = "insert into kupovine (korisnik_id, objekat_id,putovanje_id) " +
                "values (?, ?, ?)";
        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()){
                String naziv_planete = resultSet.getString(1);
                String naziv_objekta = resultSet.getString(2);
                String prevoz = resultSet.getString(3);
                LocalDate datum = resultSet.getDate(4).toLocalDate();
                LocalTime vreme = resultSet.getTime(5).toLocalTime();

                PlanetObjectFlightCombo pop = new PlanetObjectFlightCombo(naziv_planete,naziv_objekta,prevoz,datum,vreme);
                planeteObjekatiPutovanja.add(pop);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return planeteObjekatiPutovanja;
    }


    public static ObservableList<PlanetObjectFlightCombo> insertIntoPlanetObjectFlightCombo(int korisnik_id){
        ObservableList<PlanetObjectFlightCombo> planeteObjekatiPutovanja = FXCollections.observableArrayList();
        String query = "SELECT ps.ime,s.naziv,p.prevozno_sredstvo,p.datum_polaska,p.vreme " +
                "FROM kupovine k join putovanja p on k.putovanje_id = p.putovanje_id " +
                "join stambeni_objekti s on s.objekat_id = p.stambeni_objekat_idd " +
                "join planete_sateliti ps on ps.planeta_satelit_id = p.destinacija WHERE " +
                "k.korisnik_id = " + korisnik_id;
        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()){
                String naziv_planete = resultSet.getString(1);
                String naziv_objekta = resultSet.getString(2);
                String prevoz = resultSet.getString(3);
                LocalDate datum = resultSet.getDate(4).toLocalDate();
                LocalTime vreme = resultSet.getTime(5).toLocalTime();

                PlanetObjectFlightCombo pop = new PlanetObjectFlightCombo(naziv_planete,naziv_objekta,prevoz,datum,vreme);
                planeteObjekatiPutovanja.add(pop);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return planeteObjekatiPutovanja;
    }

    public static void insertIntoPutovanje(int korisnik_idd, int destinacija, int stambeni_objekat_idd, String prevozno_sredstvo,
                                           LocalDate datum_polaska,LocalTime vreme) {
        String query = "insert into putovanja (korisnik_idd, destinacija, stambeni_objekat_idd, prevozno_sredstvo, datum_polaska, vreme) " +
                "values (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            connection.setAutoCommit(false);
            statement.setInt(1,korisnik_idd);
            statement.setInt(2, destinacija);
            statement.setInt(3, stambeni_objekat_idd);
            statement.setString(4,prevozno_sredstvo);
            statement.setDate(5, Date.valueOf(datum_polaska));
            statement.setTime(6, Time.valueOf(vreme));
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static List<PlanetObjectFlightCombo> selectPlanetObjectFlight() {

        String query = "SELECT " +
                " p.putovanje_id, p.datum_kretanja, p.vreme_kretanja, p.dostupnost, p.objekatt_id, p.voziilo_id, p.korisnik_id, " +
                " v.vozilo_id, v.sifra_vozila, v.vrsta_vozila, v.broj_dozvoljenih_putnika, " +
                " o.objekat_id, o.naziv, o.vrsta, o.udaljenost_od_zvezde, o.najniza_temperatura, o.najvisa_temperatura, o.kiseonik, o.drugi_gas, o.kolicina_drugog_gasa, o.visina, o.brzina_orbitiranja, o.broj_umrlih, o.broj_misija, " +
                " s.stambeni_objekat_id, s.vrsta_stambenog_objekta, s.kvadratura, s.broj_stanara, s.dostupnost, s.objekkat_id " +
                " FROM putovanja p " +
                " JOIN vozilo v ON p.voziilo_id = v.vozilo_id " +
                " JOIN objekti o ON p.objekatt_id = o.objekat_id " +
                " JOIN stambeni_objekti s ON o.objekat_id = s.objekkat_id ";
        List<PlanetObjectFlightCombo> flightPlaneCombos = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int putovanjeId = resultSet.getInt(1);
                LocalDate datum = resultSet.getDate(2).toLocalDate();
                String vreme = resultSet.getString(3);
                LocalTime localTime = LocalTime.of(Integer.parseInt(vreme.split(":")[0]),
                        Integer.parseInt(vreme.split(":")[1]));
                boolean dostupnost1 = resultSet.getBoolean(4);
                int objekatId = resultSet.getInt(5);
                int prevoznoSredstvo = resultSet.getInt(6);
                int korisnikId = resultSet.getInt(7);

                int voziloId = resultSet.getInt(8);
                int sifra = resultSet.getInt(9);
                String tip = resultSet.getString(10);
                int kapacitet = resultSet.getInt(11);

                int objekat_id = resultSet.getInt(12);
                String naziv = resultSet.getString(13);
                String vrsta = resultSet.getString(14);
                int udaljenost_od_zvezde = resultSet.getInt(15);
                int najniza_temperatura = resultSet.getInt(16);
                int najvisa_temperatura = resultSet.getInt(17);
                double kiseonik = resultSet.getDouble(18); // Changed to double
                String drugi_gas = resultSet.getString(19);
                double kolicina_drugog_gasa = resultSet.getDouble(20);
                int visina = resultSet.getInt(21);
                int brzina_orbitiranja = resultSet.getInt(22);
                int broj_umrlih = resultSet.getInt(23);

                int stambeni_objekat_id = resultSet.getInt(24);
                String vrsta_stambenog_objekta = resultSet.getString(25);
                int kvadratura = resultSet.getInt(26);
                int broj_stanara = resultSet.getInt(27);
                boolean dostupnost = resultSet.getBoolean(28);
                int objekkat_id = resultSet.getInt(29);


                Putovanje putovanje = new Putovanje(putovanjeId, datum, localTime, dostupnost1, objekatId, prevoznoSredstvo, korisnikId);
                Vozilo vozilo = new Vozilo(voziloId, sifra, tip, kapacitet);
                Objekat objekat = new Objekat(objekatId, naziv, vrsta, udaljenost_od_zvezde, najniza_temperatura, najvisa_temperatura, (int) kiseonik, drugi_gas, (int) kolicina_drugog_gasa, visina, brzina_orbitiranja, broj_umrlih);
                StambeniObjekat stambeni_objekat = new StambeniObjekat(stambeni_objekat_id, vrsta_stambenog_objekta, kvadratura, broj_stanara, dostupnost, objekkat_id);

                PlanetObjectFlightCombo planetObjectFlightCombo = new PlanetObjectFlightCombo(putovanje, vozilo, objekat, stambeni_objekat);
                flightPlaneCombos.add(planetObjectFlightCombo);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return flightPlaneCombos;
    }





    private JDBCUtils() {

    }

}
