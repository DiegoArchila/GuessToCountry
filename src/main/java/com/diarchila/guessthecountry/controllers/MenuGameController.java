package com.diarchila.guessthecountry.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

public class MenuGameController {

    @FXML
    private ImageView iconoJuego;

    @FXML
    private Label lblWelcome;

    @FXML
    private Label lblTitlegame;

    @FXML
    private Button btnIniciar;

    @FXML
    private Button btnMarcador;

    @FXML
    private Button btnInstrucciones;

    @FXML
    private Button btnSalir;

    @FXML
    private void initialize() {
        // Inicializaciones si son necesarias
        System.out.println("Pantalla de menú inicializada");
    }

    @FXML
    private void handleBtnIniciar(ActionEvent event) throws IOException {

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/Game.fxml"));

        Parent root = loader.load();
        Scene scene = new Scene(root, 600, 600);

        stage.setScene(scene);

    }

    @FXML
    private void handleBtnMarcador(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/Scores.fxml"));

        Parent root = loader.load();
        Scene scene = new Scene(root, 600, 600);

        stage.setScene(scene);
    }

    @FXML
    private void handleBtnInstrucciones(ActionEvent event) {
        System.out.println("Botón instrucciones presionado");
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/Instructions.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle("Instrucciones");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    @FXML
    private void handleBtnSalir(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
}
