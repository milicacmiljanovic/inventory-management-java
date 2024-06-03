package person.model.utility;

import person.model.Korisnici;
import person.model.Objekat;
import person.model.StambeniObjekat;
import person.model.base.*;

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
    public static List<Objekat> selectObjekatFromZus(){
        List<Objekat> objekti = new ArrayList<>();
        String query = "select objekat_id,naziv, vrsta from zus.objekti";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int objekat_id = resultSet.getInt(1);
                String naziv = resultSet.getString(2);
                String vrsta = resultSet.getString(3);
                Objekat objekat = new Objekat(objekat_id,naziv, vrsta);
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
                Objekat objekat = new Objekat(objekat_id,naziv, vrsta);
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
        List<Korisnici> oldPeople = selectAllFromZus();
        Server.SERVER.setKorisnici(oldPeople);
        List<Korisnici> people = new ArrayList<>();
        for (Korisnici oldPerson : oldPeople) {
            if (yearOfBirth == null || yearOfBirth.length() != 4) {
                if (oldPerson.getIme().toLowerCase().contains(firstName.toLowerCase())
                        && oldPerson.getPrezime().toLowerCase().contains(lastName.toLowerCase()))
                    people.add(oldPerson);
                continue;
            }
            if (oldPerson.getIme().toLowerCase().contains(firstName.toLowerCase())
                    && oldPerson.getPrezime().toLowerCase().contains(lastName.toLowerCase())
                    && oldPerson.getDatum_rodjenja().getYear() == Integer.parseInt(yearOfBirth))
                people.add(oldPerson);
        }
        return people;
    }


    /*
    * public static void insertIntoZus(Korisnici korisnik) {
        //String query = "insert into zus.korisnici (ime, prezime, username, password, datum_rodjenja)" +
        //        "values (?, ?, str_to_date(?, '%m/%d/%Y'))";
        String query =  "insert into zus.korisnici (ime, prezime, username, password, datum_rodjenja) " +
                "values (?, ?, ?, ?, STR_TO_DATE(?, '%m/%d/%Y'))" +
                "from dual" +
                "where not exists (" +
                "select 1 from zus.korisnici where username = ?" +
                ")";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            connection.setAutoCommit(false);
            statement.setString(1, korisnik.getIme());
            statement.setString(2, korisnik.getPrezime());
            statement.setString(3, korisnik.getUsername());
            statement.setString(4, korisnik.getPassword());
            statement.setString(5,
                    korisnik.getDatum_rodjenja().getMonthValue() + "/" +
                            korisnik.getDatum_rodjenja().getDayOfMonth() + "/" +
                            korisnik.getDatum_rodjenja().getYear());
            // obrisi posle
            statement.setString(6, korisnik.getUsername());
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    * */

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
            statement.setString(6, korisnik.getUsername()); // For the NOT EXISTS clause

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
                return 1; // If the table is empty, start with 1
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving next korisnik_id", e);
        }
    }


    private JDBCUtils() {

    }

}
