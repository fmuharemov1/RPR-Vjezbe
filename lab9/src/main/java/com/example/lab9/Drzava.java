package com.example.lab9;

public class Drzava {
    private String naziv;
    private  String glavniGrad;
    public String getNaziv() {
        return naziv;
    }

    public String getGlavniGrad() {
        return glavniGrad;
    }

    @Override
    public String toString() {
        return "Drzava{" +
                "naziv='" + naziv + '\'' +
                '}';
    }
}
