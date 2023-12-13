package com.example.lab78;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class UserForm extends BorderPane {

    private ListView<Korisnik> userList;
    private TextField imeField;
    private TextField prezimeField;
    private TextField emailField;
    private TextField korisnickoImeField;
    private PasswordField lozinkaField;
    private int brojac = 1;
    public UserForm() {
        initializeUI();
    }

    private void initializeUI() {
        userList = new ListView<>();
        userList.setPrefWidth(200);
        userList.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                showUserDetails(newValue);
            }
        });

        VBox formFields = createFormFields();
        ButtonBar buttonBar = createButtonBar();

        setLeft(userList);
        setCenter(formFields);
        setBottom(buttonBar);
        setPadding(new Insets(10));
    }

    private VBox createFormFields() {
        VBox formFields = new VBox(10); // Razmak između elemenata
        formFields.setPadding(new Insets(10));

        imeField = new TextField();
        prezimeField = new TextField();
        emailField = new TextField();
        korisnickoImeField = new TextField();
        lozinkaField = new PasswordField();

        formFields.getChildren().addAll(
                new Label("Ime: "), imeField,
                new Label("Prezime: "), prezimeField,
                new Label("Email: "), emailField,
                new Label("Korisničko ime: "), korisnickoImeField,
                new Label("Lozinka: "), lozinkaField
        );

        return formFields;
    }

    private ButtonBar createButtonBar() {
        ButtonBar buttonBar = new ButtonBar();
        Button dodajButton = new Button("Dodaj");
        Button krajButton = new Button("Kraj");

        dodajButton.setOnAction(event -> {
            Korisnik newUser = new Korisnik();
            newUser.setIme("Korisnik" + brojac);
            brojac++;
            userList.getItems().add(newUser);
            userList.getSelectionModel().select(newUser);
        });

        krajButton.setOnAction(event -> System.exit(0));

        buttonBar.getButtons().addAll(dodajButton, krajButton);
        return buttonBar;
    }

    private void showUserDetails(Korisnik user) {
        imeField.setText(user.getIme());
        prezimeField.setText(user.getPrezime());
        emailField.setText(user.getEmail());
        korisnickoImeField.setText(user.getKorisnickoIme());
        lozinkaField.setText(user.getLozinka());
    }
}
