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
            String username = "korisnik";
            String password = "lozinka";
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
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

