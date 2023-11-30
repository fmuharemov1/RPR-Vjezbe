package ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.util.List;

public class KolekcijaPoruka {
    private List<String> poruke;

    public KolekcijaPoruka(List<Predstavljivo> listaObjekata) {
        this.poruke = new ArrayList<>();
        for (Predstavljivo obj : listaObjekata) {
            this.poruke.add(obj.predstavi());
        }
    }

    public List<String> getPoruke() {
        return poruke;
    }
}
