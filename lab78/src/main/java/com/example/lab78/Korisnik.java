package com.example.lab78;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Korisnik {

    private final StringProperty ime = new SimpleStringProperty();
    private final StringProperty prezime = new SimpleStringProperty();
    private final StringProperty email = new SimpleStringProperty();
    private final StringProperty korisnickoIme = new SimpleStringProperty();
    private final StringProperty lozinka = new SimpleStringProperty();

    public Korisnik() {
    }
    public Korisnik(String ime, String prezime, String email, String korisnickoIme, String lozinka) {
        setIme(ime);
        setPrezime(prezime);
        setEmail(email);
        setKorisnickoIme(korisnickoIme);
        setLozinka(lozinka);
    }
    public String getIme() {
        return ime.get();
    }

    public void setIme(String ime) {
        this.ime.set(ime);
    }

    public StringProperty imeProperty() {
        return ime;
    }

    // Getteri i setteri za prezime
    public String getPrezime() {
        return prezime.get();
    }

    public void setPrezime(String prezime) {
        this.prezime.set(prezime);
    }

    public StringProperty prezimeProperty() {
        return prezime;
    }

    public String getEmail() {
        return email.get();
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public StringProperty emailProperty() {
        return email;
    }

    public String getKorisnickoIme() {
        return korisnickoIme.get();
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme.set(korisnickoIme);
    }

    public StringProperty korisnickoImeProperty() {
        return korisnickoIme;
    }
    public String getLozinka() {
        return lozinka.get();
    }
    public void setLozinka(String lozinka) {
        this.lozinka.set(lozinka);
    }
    public StringProperty lozinkaProperty() {
        return lozinka;
    }
}

