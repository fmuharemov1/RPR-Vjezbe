package ba.unsa.etf.rpr;
import java.util.ArrayList;
import java.util.List;

public class InformacijeOStudentu extends LicneInformacije implements MozeOcijeniti {
    private String godinaStudija;
    private String brojIndexa;
    private List<Ocjena> ocjene;

    public InformacijeOStudentu(String ime, String prezime, String godinaStudija, String brojIndexa) {
        super(ime, prezime);
        this.godinaStudija = godinaStudija;
        this.brojIndexa = brojIndexa;
        this.ocjene = new ArrayList<>();
    }


   @Override
   public Ocjena ocijeni(int x) {
       LicneInformacije studentInfo = new LicneInformacije(getIme(), getPrezime());
       Ocjena novaOcjena = new Ocjena(studentInfo, x);
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
