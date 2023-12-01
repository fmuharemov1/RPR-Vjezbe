package ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.util.List;

public class Predmet implements MozeOcijeniti {
    private String naziv;
    private String opis;
    private List<Ocjena> ocjene;

    public Predmet(String naziv, String opis) {
        this.naziv = naziv;
        this.opis = opis;
        this.ocjene = new ArrayList<>();
    }
    @Override
    public Ocjena ocijeni(int x) {
        LicneInformacije dummyOsoba = new LicneInformacije("Dummy", "Osoba");
        Ocjena novaOcjena = new Ocjena(dummyOsoba, x);
        ocjene.add(novaOcjena);
        return novaOcjena;
    }
    public List<Ocjena> getOcjene() {
        return ocjene;
    }
    public void setOcjene(List<Ocjena> ocjene) {
        this.ocjene = ocjene;
    }
}