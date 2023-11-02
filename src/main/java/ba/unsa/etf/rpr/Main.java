package ba.unsa.etf.rpr;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public class Osoba {
        Osoba(String ime, String prezime){
            this.ime=ime;
            this.prezime=prezime;
        }
        public String toString(){return new String();}
        protected String ime;
        protected String prezime;
    }

    public class Korisnik extends Osoba{
        public Korisnik(String ime, String prezime){
            super(ime, prezime);
        }
        public void dodajRacun(Racun r){}
        private Racun racun;
    }
    public class Racun {
        private Long brojRacuna;
        private Osoba korisnikRacuna;
        private boolean odobrenjePrekoracenja;
        private Double stanjeRacuna;
        public Racun(Long brRacuna, Osoba o){
            this.brojRacuna=brRacuna;
            this.korisnikRacuna=o;
            this.stanjeRacuna=0.0;
            this.odobrenjePrekoracenja=false;
        }
        public boolean provjeriOdobrenjePrekoracenja(double prekoracenje){
            return (stanjeRacuna-prekoracenje >=0) && odobrenjePrekoracenja;
        }
        public boolean izvrsiUplatu(double iznos){
            if(iznos>=0){
                stanjeRacuna+=iznos;
                return true;
            }else return false;
        }
        public boolean izvrsiIsplatu(double iznos){
            if(stanjeRacuna-iznos >=0){
                stanjeRacuna-=iznos;
                return true;
            }
            else return false;
        }
        public void odobriPrekoracenje(double prekoracenje){
            if(prekoracenje>=0)
                odobrenjePrekoracenja=true;
        }

    }
    public class Uposlenik extends Osoba{
        Uposlenik(String ime, String prezime){
            super(ime, prezime);
        }
    }

    public class Banka {
        public Banka(){}
        public Korisnik kreirajNovogKorisnika(String ime, String prezime){
            return new Korisnik(ime, prezime);
        }
        public Uposlenik kreirajNovogUposlenika(String ime, String prezime){
            return new Uposlenik(ime, prezime);
        }
        public Racun kreirajRacunZaKorisika(Korisnik k){
            Random r = new Random();
            Long br=r.nextLong();
            return new Racun(br,k);}
        private List<Korisnik> korisnici;
        private List<Uposlenik> uposlenici;

    }

    public static void main(String[] args) {
        // write your code here
    }
}
