package ba.unsa.etf.rpr;
import java.io.Serializable;
public class Laptop implements Serializable{
    public String brend, model, procesor, grafickaKartica;
    public int ram, hdd, ssd;
    public double cijena, velicinaEkrana;
    public String getProcesor() {
        return procesor;
    }
    public String getBrand() {
        return brend;
    }
    public int getRam(){
        return ram;
    }
    public Laptop(String brand, String procesor, int ram) {
        this.brend = brand;
        this.procesor = procesor;
        this.ram = ram;
    }
}
