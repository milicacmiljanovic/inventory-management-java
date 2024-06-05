package person.model.base;

import java.sql.*;
import java.time.LocalDate;

public class DataBase {
    private final String url = "jdbc:mysql://localhost:3306/zus";
    private final String user = "root";
    private final String password = "";

    public DataBase() {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public boolean validateUser(String username, String password) {
        String query = "select * from zus.korisnici where username = ? and password = ?";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, username);
            statement.setString(2, password);
            try (ResultSet resultSet = statement.executeQuery()) {
                return resultSet.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean addUser(String ime, String prezime, String username, String password, LocalDate datum_rodjenja) {
        String query = "INSERT INTO zus.korisnici (ime, prezime, username, password, datum_rodjenja) VALUES (?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1,ime);
            statement.setString(2,prezime);
            statement.setString(3, username);
            statement.setString(4, password);
            statement.setDate(5, Date.valueOf(datum_rodjenja));
            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}