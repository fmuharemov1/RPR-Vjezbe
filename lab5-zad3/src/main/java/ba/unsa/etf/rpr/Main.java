package ba.unsa.etf.rpr;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> imenaIPrezimena = new ArrayList<>();
        imenaIPrezimena.add("John Doe");
        imenaIPrezimena.add("Jane Smith");
        imenaIPrezimena.add("Mark Johnson");

        KolekcijaImena kolekcija1 = new KolekcijaImena(imenaIPrezimena);
        Pobjednik pobjednik1 = new Pobjednik(kolekcija1);
        System.out.println("Pobjednik 1: " + pobjednik1.getIme() + " " + pobjednik1.getPrezime());

        // Primjer s KolekcijaImenaIPrezimena
        List<String> imena = new ArrayList<>();
        List<String> prezimena = new ArrayList<>();
        imena.add("Alice");
        imena.add("Bob");
        prezimena.add("Johnson");
        prezimena.add("Smith");

        KolekcijaImenaIPrezimena kolekcija2 = new KolekcijaImenaIPrezimena(imena, prezimena);
        Pobjednik pobjednik2 = new Pobjednik(kolekcija2);
        System.out.println("Pobjednik 2: " + pobjednik2.getIme() + " " + pobjednik2.getPrezime());
    }
}