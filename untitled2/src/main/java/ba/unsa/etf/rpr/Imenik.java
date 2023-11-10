package ba.unsa.etf.rpr;

import java.util.*;

public class Imenik {
    private Map<String, TelefonskiBroj> imenik=new HashMap<>();
    public void dodaj(String ime, TelefonskiBroj broj){
        imenik.put(ime, broj);
    }
    public String dajBroj(String ime){
        TelefonskiBroj broj=imenik.get(ime);
        if(broj !=null) return broj.ispisi();
        else return "Osoba "+ime+" ne postoji";
    }
    public String dajIme(TelefonskiBroj broj){
        for(Map.Entry<String, TelefonskiBroj> entry : imenik.entrySet()){
            if(entry.getValue().equals(broj)) return entry.getKey();
        }
        return "Ne postoji ime koje koristi broj "+ broj.ispisi();
    }
    public String naSlovo(char s) {
        StringBuilder rezultat = new StringBuilder();
        for (Map.Entry<String, TelefonskiBroj> entry : imenik.entrySet()) {
            String ime = entry.getKey();
            if (ime.charAt(0) == s) {
                rezultat.append(ime).append(" - ").append(entry.getValue().ispisi()).append("\n");
            }
        }
        return rezultat.toString();
    }

    public Set<String> izGrada(FiksniBroj.Grad g) {
        Set<String> imena = new TreeSet<>();
        for (Map.Entry<String, TelefonskiBroj> entry : imenik.entrySet()) {
            TelefonskiBroj broj = entry.getValue();
            if (broj instanceof FiksniBroj) {
                FiksniBroj fiksniBroj = (FiksniBroj) broj;
                if (fiksniBroj.getGrad() == g) {
                    imena.add(entry.getKey());
                }
            }
        }
        return imena;
    }
    public Set<TelefonskiBroj> izGradaBrojevi(FiksniBroj.Grad g) {
        Set<TelefonskiBroj> brojevi = new TreeSet<>(Comparator.comparing(TelefonskiBroj::ispisi));
        for (TelefonskiBroj broj : imenik.values()) {
            if (broj instanceof FiksniBroj) {
                FiksniBroj fiksniBroj = (FiksniBroj) broj;
                if (fiksniBroj.getGrad() == g) {
                    brojevi.add(broj);
                }
            }
        }
        return brojevi;
    }
}
