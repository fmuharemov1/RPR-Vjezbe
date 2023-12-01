package ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.util.List;

public class InformacijeONastavniku extends LicneInformacije implements MozeOcijeniti {
    private String titula;
    private List<Ocjena> ocjene;

    public InformacijeONastavniku(String ime, String prezime, String titula) {
        super(ime, prezime);
        this.titula = titula;
        this.ocjene = new ArrayList<>();
    }

    @Override
    public Ocjena ocijeni(int x) {
        LicneInformacije nastavnikInfo = new LicneInformacije(getIme(), getPrezime());
        Ocjena novaOcjena = new Ocjena(nastavnikInfo, x);
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
