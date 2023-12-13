package com.example.lab78;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class KorisniciModel {

    private ObservableList<Korisnik> korisnici = FXCollections.observableArrayList();
    private SimpleObjectProperty<Korisnik> trenutniKorisnik = new SimpleObjectProperty<>();

    public KorisniciModel() {
        this.korisnici = FXCollections.observableArrayList();
        this.trenutniKorisnik = new SimpleObjectProperty<>();
    }
    public void dodajKorisnika(Korisnik korisnik) {
        korisnici.add(korisnik);
    }
    public ObservableList<Korisnik> getKorisnici() {
        return korisnici;
    }

    public void setKorisnici(ObservableList<Korisnik> korisnici) {
        this.korisnici = korisnici;
    }

    public Korisnik getTrenutniKorisnik() {
        return trenutniKorisnik.get();
    }

    public void setTrenutniKorisnik(Korisnik korisnik) {
        this.trenutniKorisnik.set(korisnik);
    }

    public ObjectProperty<Korisnik> trenutniKorisnikProperty() {
        return trenutniKorisnik;
    }
    public void napuni() {
        korisnici.add(new Korisnik("Ime1", "Prezime1", "ime1.prezime1@example.com", "korisnik1", "lozinka1"));
        korisnici.add(new Korisnik("Ime2", "Prezime2", "ime2.prezime2@example.com", "korisnik2", "lozinka2"));
    }
}