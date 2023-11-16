package ba.unsa.etf.rpr;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.*;
import java.util.ArrayList;

public class LaptopDaoXMLFile implements LaptopDao {
    private File file;
    private ArrayList<Laptop> laptopi;

    public LaptopDaoXMLFile(File file) {
        this.file = file;
        this.laptopi = new ArrayList<>();
    }

    @Override
    public void dodajLaptopUFile(Laptop laptop) {
        try (FileWriter fileWriter = new FileWriter(file, true);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            XmlMapper xmlMapper = new XmlMapper();
            String xmlString = xmlMapper.writeValueAsString(laptop);
            bufferedWriter.write(xmlString);
            bufferedWriter.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void dodajLaptopUListu(Laptop laptop) {
        laptopi.add(laptop);
        // Ovdje možete implementirati logiku za pisanje XML-a u datoteku
        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write("<laptopi>\n");
            for (Laptop l : laptopi) {
                fileWriter.write("    <laptop>\n");
                fileWriter.write("        <brand>" + l.getBrand() + "</brand>\n");
                fileWriter.write("        <procesor>" + l.getProcesor() + "</procesor>\n");
                fileWriter.write("        <ram>" + l.getRam() + "</ram>\n");
                // Dodajte ostale atribute prema potrebi
                fileWriter.write("    </laptop>\n");
            }
            fileWriter.write("</laptopi>\n");
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

    @Override
    public ArrayList<Laptop> vratiPodatkeIzDatoteke() {
        ArrayList<Laptop> listaIzDatoteke = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            XmlMapper xmlMapper = new XmlMapper();
            while ((line = bufferedReader.readLine()) != null) {
                Laptop laptop = xmlMapper.readValue(line, Laptop.class);
                listaIzDatoteke.add(laptop);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listaIzDatoteke;
    }
}
