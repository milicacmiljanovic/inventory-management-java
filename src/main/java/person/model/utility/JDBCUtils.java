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
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/zus", properties);
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

    public static void insertIntoZus(String ime, String prezime, LocalDate datum_rodjenja) {
        String query = "insert into zus.korisnici (ime, prezime, datum_rodjenja)" +
                "values (?, ?, str_to_date(?, '%m/%d/%Y'))";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            connection.setAutoCommit(false);
            statement.setString(1, ime);
            statement.setString(2, prezime);
            statement.setString(3,
                    datum_rodjenja.getMonthValue() + "/" +
                    datum_rodjenja.getDayOfMonth() + "/" + datum_rodjenja.getYear());
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private JDBCUtils() {

    }

}
