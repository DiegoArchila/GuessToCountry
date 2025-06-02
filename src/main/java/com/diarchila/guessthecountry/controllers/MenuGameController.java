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
    private void handleBtnIniciar(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/GameS.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("Guess the Country - Game");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleBtnMarcador(ActionEvent event) {
        System.out.println("Mostrar marcador...");
        // Aquí podrías cargar una nueva escena o mostrar un modal con puntajes
    }

    @FXML
    private void handleBtnInstrucciones(ActionEvent event) {
        System.out.println("Mostrar instrucciones...");
        // Aquí podrías mostrar un diálogo con instrucciones
    }

    @FXML
    private void handleBtnSalir(ActionEvent event) {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }
}
