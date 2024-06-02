package person.model.utility;

import person.model.base.Korisnici;
import person.model.base.Server;

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
        List<Korisnici> people = new ArrayList<>();
        String query = "select * from zus.korisnici";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int personId = resultSet.getInt(1);
                String firstName = resultSet.getString(2);
                String lastName = resultSet.getString(3);
                String username = resultSet.getString(4);
                String password = resultSet.getString(5);
                LocalDate dateOfBirth = resultSet.getDate(6).toLocalDate();
                Korisnici person = new Korisnici(personId, firstName, lastName, username, password, dateOfBirth);
                people.add(person);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return people;
    }

    public static List<Korisnici> selectFromPerson(String firstName, String lastName, String yearOfBirth) {
        List<Korisnici> oldPeople = selectAllFromZus();
        Server.SERVER.setPeople(oldPeople);
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

    public static void insertIntoZus(String firstName, String lastName, LocalDate dateOfBirth) {
        String query = "insert into zus (first_name, last_name, date_of_birth)" +
                "values (?, ?, str_to_date(?, '%m/%d/%Y'))";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            connection.setAutoCommit(false);
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setString(3,
                    dateOfBirth.getMonthValue() + "/" +
                    dateOfBirth.getDayOfMonth() + "/" + dateOfBirth.getYear());
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private JDBCUtils() {

    }

}
