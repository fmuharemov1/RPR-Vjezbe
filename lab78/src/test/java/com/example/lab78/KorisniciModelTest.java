package com.example.lab78;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;

class KorisniciModelTest extends KorisniciModel {
    private KorisniciModel model;

    @BeforeEach
    public void setUp() {
        model = new KorisniciModel();
    }

    @Test
    public void testDodajKorisnika() {
        Korisnik korisnik = new Korisnik("Ime", "Prezime", "email@example.com", "korisnik", "lozinka");
        model.dodajKorisnika(korisnik);

        assertEquals(1, model.getKorisnici().size());
        assertEquals(korisnik, model.getKorisnici().get(0));
    }

    @Test
    public void testSetTrenutniKorisnik() {
        Korisnik korisnik1 = new Korisnik("Ime1", "Prezime1", "email1@example.com", "korisnik1", "lozinka1");
        Korisnik korisnik2 = new Korisnik("Ime2", "Prezime2", "email2@example.com", "korisnik2", "lozinka2");

        model.dodajKorisnika(korisnik1);
        model.dodajKorisnika(korisnik2);

        model.setTrenutniKorisnik(korisnik1);
        assertEquals(korisnik1, model.getTrenutniKorisnik());

        model.setTrenutniKorisnik(korisnik2);
        assertEquals(korisnik2, model.getTrenutniKorisnik());
    }
}