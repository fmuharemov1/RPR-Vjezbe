package com.example.lab9;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class DrzavaController {

    @FXML
    private TableView<Drzava> tableViewDrzave;

    @FXML
    private TableColumn<Drzava, Integer> colDrzavaId;

    @FXML
    private TableColumn<Drzava, String> colDrzavaNaziv;

    @FXML
    private Button btnDodajDrzavu;

    @FXML
    private Button btnIzmijeniDrzavu;

    @FXML
    private Button btnObrisiDrzavu;

}