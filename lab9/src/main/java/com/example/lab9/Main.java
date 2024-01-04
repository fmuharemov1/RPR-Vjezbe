package com.example.lab9;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.Scanner;
import java.io.IOException;

public class Main extends Application {
    private static GeografijaDAO geografijaDAO;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
        geografijaDAO = GeografijaDAO.getInstance();

        provjeriBazu();

        String gradoviInfo = ispisiGradove();
        System.out.println(gradoviInfo);

        glavniGrad();
    }

    private static void provjeriBazu() {

        if (!geografijaDAO.bazaPostoji()) {
            dodajPocetnePodatke();
        }
    }

    private static void dodajPocetnePodatke() {

        Grad pariz = new Grad("Pariz", 2206488, "Francuska");
        Grad london = new Grad("London", 8908081, "Ujedinjeno Kraljevstvo");
        Grad bec = new Grad("Beč", 1897491, "Austrija");
        Grad manchester = new Grad("Manchester", 547627, "Ujedinjeno Kraljevstvo");
        Grad graz = new Grad("Graz", 291236, "Austrija");

        Drzava francuska = new Drzava("Francuska", "Pariz");
        Drzava uk = new Drzava("Ujedinjeno Kraljevstvo", "London");
        Drzava austrija = new Drzava("Austrija", "Beč");

        geografijaDAO.dodajGrad(pariz);
        geografijaDAO.dodajGrad(london);
        geografijaDAO.dodajGrad(bec);
        geografijaDAO.dodajGrad(manchester);
        geografijaDAO.dodajGrad(graz);

        geografijaDAO.dodajDrzavu(francuska);
        geografijaDAO.dodajDrzavu(uk);
        geografijaDAO.dodajDrzavu(austrija);
    }

    private static String ispisiGradove() {
        ArrayList<Grad> gradovi = geografijaDAO.gradovi();
        StringBuilder gradoviInfo = new StringBuilder();

        for (Grad grad : gradovi) {
            gradoviInfo.append(grad.getNaziv()).append(" (").append(grad.getDrzava()).append(") - ").append(grad.getBrojStanovnika()).append("\n");
        }

        return gradoviInfo.toString();
    }

    private static void glavniGrad() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Unesite naziv države:");
        String drzava = scanner.nextLine();

        Grad glavniGrad = geografijaDAO.glavniGrad(drzava);

        if (glavniGrad != null) {
            System.out.println("Glavni grad države " + drzava + " je " + glavniGrad.getNaziv());
        } else {
            System.out.println("Nepostojeća država");
        }
    }
    }
}