package ba.unsa.etf.rpr;
import java.io.*;
import java.util.ArrayList;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
public class LaptopDaoSerializableFile implements LaptopDao {
    private File file;
    private ArrayList<Laptop> laptopi;
    private ObjectOutputStream objectOutputStream;
    private ObjectInputStream objectInputStream;
    public LaptopDaoSerializableFile(ObjectOutputStream objectOutputStream) {
        this.objectOutputStream = objectOutputStream;
    }
    public LaptopDaoSerializableFile(String fileName) throws IOException {
        this.objectInputStream = new ObjectInputStream(new FileInputStream(fileName));
    }
    public void postaviObjectOutputStream(ObjectOutputStream objectOutputStream) {
        this.objectOutputStream = objectOutputStream;
    }
    public LaptopDaoSerializableFile(ObjectInputStream objectInputStream) {
        this.objectInputStream = objectInputStream;
    }
    public LaptopDaoSerializableFile(File file) {
        this.file = file;
        this.laptopi = new ArrayList<>();
    }

    @Override
    public void dodajLaptopUFile(Laptop laptop) {
        try {
            objectOutputStream.writeObject(laptop);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void dodajLaptopUListu(Laptop laptop) {
        laptopi.add(laptop);
        // Ovdje možete implementirati logiku za serijalizaciju liste laptopa u datoteku
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file))) {
            outputStream.writeObject(laptopi);
        } catch (IOException e) {
            e.printStackTrace();
            // Obrada izuzetka...
        }
    }
    @Override
    public Laptop getLaptop(String procesor) throws NeodgovarajuciProcesorException {
        for (Laptop laptop : laptopi) {
            if (laptop.getProcesor().equals(procesor)) {
                return laptop;
            }
        }
        throw new NeodgovarajuciProcesorException("Nema laptopa s procesorom: " + procesor);
    }

    @Override
    public void napuniListu(ArrayList<Laptop> laptopi) {
        this.laptopi = laptopi;
    }
    public void setObjectInputStream(ObjectInputStream objectInputStream) {
        this.objectInputStream = objectInputStream;
    }
    @Override
    public ArrayList<Laptop> vratiPodatkeIzDatoteke() {
        ArrayList<Laptop> laptopi = new ArrayList<>();

        try {
            while (true) {
                Laptop laptop = (Laptop) objectInputStream.readObject();
                laptopi.add(laptop);
            }
        } catch (EOFException e) {// Završetak datoteke, ne treba raditi ništa
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();

        }

        return laptopi;
    }
}