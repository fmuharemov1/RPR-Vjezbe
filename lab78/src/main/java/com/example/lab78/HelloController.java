package com.example.lab78;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private ListView<Korisnik> listKorisnici;
    @FXML
    private TextField fldIme;
    @FXML
    private TextField fldPrezime;
    @FXML
    private TextField fldEmail;
    @FXML
    private TextField fldKorisnickoIme;
    @FXML
    private TextField fldLozinka;

    private KorisniciModel model;

    public void setModel(KorisniciModel model) {
        this.model = model;
        listKorisnici.setItems(model.getKorisnici());
        listKorisnici.getSelectionModel().selectedItemProperty().addListener((obs, oldKorisnik, newKorisnik) -> {
            model.setTrenutniKorisnik(newKorisnik);
            listKorisnici.refresh();
        });
    }

    @FXML
    public void initialize() {
        fldIme.textProperty().bindBidirectional(model.trenutniKorisnikProperty().get().imeProperty());
        fldPrezime.textProperty().bindBidirectional(model.trenutniKorisnikProperty().get().prezimeProperty());
        fldEmail.textProperty().bindBidirectional(model.trenutniKorisnikProperty().get().emailProperty());
        fldKorisnickoIme.textProperty().bindBidirectional(model.trenutniKorisnikProperty().get().korisnickoImeProperty());
        fldLozinka.textProperty().bindBidirectional(model.trenutniKorisnikProperty().get().lozinkaProperty());
    }

    @FXML
    public void dodajKorisnika() {
        Korisnik noviKorisnik = new Korisnik("", "", "", "", "");
        model.getKorisnici().add(noviKorisnik);
        model.setTrenutniKorisnik(noviKorisnik);
        listKorisnici.refresh();
    }
}