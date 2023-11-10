package ba.unsa.etf.rpr;

import java.util.Collections;
import java.util.Set;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Program {
    public static void main(String[] args) {
        Imenik imenik = new Imenik();

        FiksniBroj sarajevoBroj = new FiksniBroj(FiksniBroj.Grad.SARAJEVO, "123-456");
        MobilniBroj mobilniBroj = new MobilniBroj(61, "987-654");
        MedunarodniBroj medunarodniBroj = new MedunarodniBroj("+387", "987654321");

        imenik.dodaj("Benjamina Karić", sarajevoBroj);
        imenik.dodaj("Abdulah Skaka", mobilniBroj);
        imenik.dodaj("Ivo Komšić", medunarodniBroj);

        System.out.println(imenik.dajBroj("Benjamina Karić"));
        System.out.println(imenik.dajBroj("Abdulah Skaka"));
        System.out.println(imenik.dajBroj("Ivo Komšić"));

        System.out.println(imenik.dajIme(sarajevoBroj));
        System.out.println(imenik.dajIme(mobilniBroj));
        System.out.println(imenik.dajIme(medunarodniBroj));

        char slovo = 'O';
        Set<String> osobeNaSlovo = Collections.singleton(imenik.naSlovo(slovo));
        for (String osoba : osobeNaSlovo) {
            System.out.println(osoba);
        }

        FiksniBroj.Grad grad = FiksniBroj.Grad.SARAJEVO;
        Set<String> imenaIprezimena = imenik.izGrada(grad);
        for (String ime : imenaIprezimena) {
            System.out.println(ime);
        }

        Set<TelefonskiBroj> brojeviIzGrada = imenik.izGradaBrojevi(grad);
        for (TelefonskiBroj broj : brojeviIzGrada) {
            System.out.println(broj.ispisi());
        }

    }public static boolean provjeriIspravnostBroja(String broj) {
        for (char c : broj.toCharArray()) {
            if (!Character.isDigit(c) && c != '-') {
                return false;  // Broj sadrži karaktere koji nisu znamenke ili '-'
            }
        }
        return true;  // Svi karakteri su znamenke ili '-'
    }
}