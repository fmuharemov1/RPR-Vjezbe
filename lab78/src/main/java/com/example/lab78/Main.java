package com.example.lab78;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        UserForm userForm = new UserForm();
        Scene scene = new Scene(userForm, 600, 400);

        primaryStage.setTitle("Forma za unos korisnika");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}