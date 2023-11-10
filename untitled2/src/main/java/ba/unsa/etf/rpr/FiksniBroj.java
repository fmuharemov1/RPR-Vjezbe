package ba.unsa.etf.rpr;

public class FiksniBroj extends TelefonskiBroj{
    public enum Grad{ SARAJEVO, TUZLA, ZENICA, BRCKO, MOSTAR }
    private String broj;
    private Grad grad;
    public FiksniBroj(Grad grad, String broj){
        this.grad=grad;
        this.broj=broj;
    }
    @Override
    public int hashCode(){
        return 1;
    }
    public Grad getGrad() {
        return grad;
    }
    @Override
    public String ispisi() {
        return grad+"/"+broj;
    }
}
