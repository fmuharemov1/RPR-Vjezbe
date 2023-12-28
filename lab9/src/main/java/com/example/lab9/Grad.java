package com.example.lab9;

public class Grad {
    private String naziv;
    private int brojStanovnika;
    void setNaziv(String naziv){
        this.naziv=naziv;
    }
    void setBrojStanovnika(int broj){
        this.brojStanovnika=broj;
    }
    @Override
    public String toString() {
        return "Grad{" +
                "naziv='" + naziv + '\'' +
                ", brojStanovnika=" + brojStanovnika +
                '}';
    }
}
