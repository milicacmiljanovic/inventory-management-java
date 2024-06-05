package person.model.utility;

import person.model.*;

import java.sql.*;
import java.time.LocalDate;
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

    public static List<StambeniObjekat> selectStambeniObjekatFromZus() {
        List<StambeniObjekat> stambeniObjekti = new ArrayList<>();
        String query = "select * from zus.stambeni_objekti";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int stambeniObjekatId = resultSet.getInt(1);
                String vrstaStambenogObjekta = resultSet.getString(2);
                int kvadratura = resultSet.getInt(3);
                int brojStanara = resultSet.getInt(4);
                boolean dostuonost = resultSet.getBoolean(5);
                StambeniObjekat stambeni = new StambeniObjekat(stambeniObjekatId, vrstaStambenogObjekta, kvadratura, brojStanara, dostuonost);
                stambeniObjekti.add(stambeni);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return stambeniObjekti;
    }


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
                "AND o.visina >= 1 " +
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


    private JDBCUtils() {

    }

}
