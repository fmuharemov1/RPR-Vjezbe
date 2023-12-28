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
    public Grad glavniGrad(String drzava) {
        String query = "SELECT naziv, broj_stanovnika FROM gradovi WHERE drzava = ? ORDER BY broj_stanovnika DESC LIMIT 1";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, drzava);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    String naziv = resultSet.getString("naziv");
                    int brojStanovnika = resultSet.getInt("broj_stanovnika");
                    return new Grad(naziv, brojStanovnika, drzava);
                } else {
                    return null;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public void dodajGrad(Grad grad) {
        String query = "INSERT INTO gradovi (naziv, broj_stanovnika, drzava) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, grad.getNaziv());
            preparedStatement.setInt(2, grad.getBrojStanovnika());
            preparedStatement.setString(3, grad.getDrzava());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void dodajDrzavu(Drzava drzava) {
        String query = "INSERT INTO drzave (naziv, glavni_grad) VALUES (?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, drzava.getNaziv());
            preparedStatement.setString(2, drzava.getGlavniGrad());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void izmijeniGrad(Grad grad) {
        String query = "UPDATE gradovi SET broj_stanovnika = ? WHERE naziv = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, grad.getBrojStanovnika());
            preparedStatement.setString(2, grad.getNaziv());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Drzava nadjiDrzavu(String drzava) {
        String query = "SELECT naziv, glavni_grad FROM drzave WHERE naziv = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, drzava);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    String naziv = resultSet.getString("naziv");
                    String glavniGrad = resultSet.getString("glavni_grad");
                    return new Drzava(naziv, glavniGrad);
                } else {
                    return null;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public void obrisiDrzavu(String drzava) {
        try {
            connection.setAutoCommit(false);

            String deleteGradoviQuery = "DELETE FROM gradovi WHERE drzava = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(deleteGradoviQuery)) {
                preparedStatement.setString(1, drzava);
                preparedStatement.executeUpdate();
            }

            String deleteDrzavaQuery = "DELETE FROM drzave WHERE naziv = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(deleteDrzavaQuery)) {
                preparedStatement.setString(1, drzava);
                preparedStatement.executeUpdate();
            }

            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException rollbackException) {
                rollbackException.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
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

    public ArrayList<Grad> gradovi() {
        ArrayList<Grad> gradovi = new ArrayList<>();
        String query = "SELECT naziv, broj_stanovnika, drzava FROM gradovi ORDER BY broj_stanovnika DESC";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                String naziv = resultSet.getString("naziv");
                int brojStanovnika = resultSet.getInt("broj_stanovnika");
                String drzava = resultSet.getString("drzava");
                gradovi.add(new Grad(naziv, brojStanovnika, drzava));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return gradovi;
    }
}

