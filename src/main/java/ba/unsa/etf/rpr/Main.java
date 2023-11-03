package ba.unsa.etf.rpr;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Double> lista = new ArrayList<>();
        Scanner ulaz = new Scanner(System.in);
        while (true) {
            System.out.println("Unesite broj: ");
            String unos = ulaz.nextLine();
            if (unos.equals("stop")) break;
            double broj = Double.parseDouble(unos);
            lista.add(broj);
        }
        double min = lista.get(0), max = lista.get(0), suma = 0;
        for (int i = 0; i < lista.size(); i++) {
            suma = suma + lista.get(i);
            if (lista.get(i) < min) min = lista.get(i);
            if (lista.get(i) > max) max = lista.get(i);
        }
        double devijacija = 0, srVrijednost = suma / lista.size();
        for (int i = 0; i < lista.size(); i++) {
            devijacija += Math.pow(lista.get(i) - srVrijednost, 2);
        }
        double standDevijacija = Math.sqrt(devijacija / lista.size());
        System.out.println("Min: " + min);
        System.out.println("Max: " + max);
        System.out.println("Sredna vrijednost: " + srVrijednost);
        System.out.println("Standardna devijacija: " + standDevijacija);
    }
}
