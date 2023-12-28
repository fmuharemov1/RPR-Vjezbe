package com.example.lab9;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GeografijaDAO {
    private static GeografijaDAO instance;
    private Connection connection;

    private GeografijaDAO() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/baza";
            connection = DriverManager.getConnection(url);
            if (!provjeriPostojanjeBaze()) {

                inicijalizujBazu();
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();

        }
    }
    private boolean provjeriPostojanjeBaze() {
        try {
            String query = "SELECT 1 FROM gradovi LIMIT 1";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.executeQuery();
            }
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
    private void dodajGrad(String naziv, int brojStanovnika) throws SQLException {
        String query = "INSERT INTO gradovi (naziv, broj_stanovnika) VALUES (?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, naziv);
            preparedStatement.setInt(2, brojStanovnika);
            preparedStatement.executeUpdate();
        }
    }
    private void inicijalizujBazu() {
        try {
            String createTableQuery = "CREATE TABLE gradovi (naziv VARCHAR(255), broj_stanovnika INT)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(createTableQuery)) {
                preparedStatement.executeUpdate();
            }

            dodajGrad("Pariz", 2200000);
            dodajGrad("London", 8900000);
            dodajGrad("Beč", 1890000);
            dodajGrad("Manchester", 545000);
            dodajGrad("Graz", 280000);

        } catch (SQLException e) {
            e.printStackTrace();

        }
    }
    public static synchronized GeografijaDAO getInstance() {
        if (instance == null) {
            instance = new GeografijaDAO();
        }
        return instance;
    }

    public List<Grad> gradovi() {
        List<Grad> gradovi = new ArrayList<>();
        String query = "SELECT * FROM gradovi ORDER BY broj_stanovnika DESC";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Grad grad = new Grad();
                grad.setNaziv(resultSet.getString("naziv"));
                grad.setBrojStanovnika(resultSet.getInt("broj_stanovnika"));
                gradovi.add(grad);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return gradovi;
    }
}

