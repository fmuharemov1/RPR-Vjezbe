package ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.util.List;

class KolekcijaImena implements KolekcijaImenaBase{
    private List<String> imenaIPrezimena;

    public KolekcijaImena(List<String> imenaIPrezimena) {
        this.imenaIPrezimena = imenaIPrezimena;
    }

    public String getNajduzeIme() {
        String najduzeIme = "";
        for (String imePrezime : imenaIPrezimena) {
            if (imePrezime.length() > najduzeIme.length()) {
                najduzeIme = imePrezime;
            }
        }
        return najduzeIme;
    }
}