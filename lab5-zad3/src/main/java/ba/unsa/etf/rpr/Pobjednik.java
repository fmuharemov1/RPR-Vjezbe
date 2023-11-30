package ba.unsa.etf.rpr;
class Pobjednik {
    private String ime;
    private String prezime;
    private int brojZnakova;

    public <T extends KolekcijaImenaBase> Pobjednik(T kolekcijaImena) {
        String najduzeIme = kolekcijaImena.getNajduzeIme();
        String[] dijelovi = najduzeIme.split(" ");
        this.ime = dijelovi[0];
        this.prezime = dijelovi[1];
        this.brojZnakova = najduzeIme.length();
    }
    public String getIme() {
        return ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public int getBrojZnakova() {
        return brojZnakova;
    }

}