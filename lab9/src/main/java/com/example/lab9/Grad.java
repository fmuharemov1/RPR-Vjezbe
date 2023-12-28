package com.example.lab9;

public class Grad {
    private String naziv;
    private int brojStanovnika;
    Drzava drzava;
    void setNaziv(String naziv){
        this.naziv=naziv;
    }
    void setBrojStanovnika(int broj){
        this.brojStanovnika=broj;
    }
    Drzava getDrzava(){
        return drzava;
    }
    String getNaziv(){
        return naziv;
    }
    int getBrojStanovnika(){
        return brojStanovnika;
    }
    @Override
    public String toString() {
        return "Grad{" +
                "naziv='" + naziv + '\'' +
                ", brojStanovnika=" + brojStanovnika +
                '}';
    }
}
