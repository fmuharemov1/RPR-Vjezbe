package com.example.lab9;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class GlavnaController {

    @FXML
    private TableView<Grad> tableViewGradovi;

    @FXML
    private TableColumn<Grad, Integer> colGradId;

    @FXML
    private TableColumn<Grad, String> colGradNaziv;

    @FXML
    private TableColumn<Grad, Integer> colGradStanovnika;

    @FXML
    private TableColumn<Grad, Drzava> colGradDrzava;

    @FXML
    private Button btnDodajGrad;

    @FXML
    private Button btnDodajDrzavu;

    @FXML
    private Button btnIzmijeniGrad;

    @FXML
    private Button btnObrisiGrad;


}