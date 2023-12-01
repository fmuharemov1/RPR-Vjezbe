package ba.unsa.etf.rpr;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        InformacijeOStudentu student = new InformacijeOStudentu("Majko", "Kjajević", "3. godina", "12345");
        Predmet matematika = new Predmet("Matematika", "Linearna algebra");
        InformacijeONastavniku nastavnik = new InformacijeONastavniku("Mima", "Šiš", "docent");

        Ocjena ocjenaMatematika = student.ocijeni( 8);
        System.out.println("Ocjena iz matematike: " + ocjenaMatematika.getOcjena());

        // Nastavnik ocjenjuje predmet
        Ocjena ocjenaMatematikaOdNastavnika = nastavnik.ocijeni( 9);
        System.out.println("Ocjena iz matematike od nastavnika: " + ocjenaMatematikaOdNastavnika.getOcjena());








    }
}