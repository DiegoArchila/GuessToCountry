package com.diarchila.guessthecountry.controllers;

import javafx.animation.RotateTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.util.Duration;

public class GuessTheCountryController {
    
     @FXML
    private Label lblWelcome;

    @FXML
    private Label lblTitlegame;

    @FXML
    private Button startButton;

    @FXML
    private Button exitButton;

    @FXML
    public void initialize() {
        // Rotación animada del label
        RotateTransition rotate = new RotateTransition(Duration.seconds(2), lblWelcome);
        rotate.setByAngle(-30); // Rota 40 grados
        rotate.play();
    }

    @FXML
    private void handleStartButtonAction() {
        // Lógica para iniciar el juego
        lblWelcome.setText("¡Buena suerte!");
        lblTitlegame.setText("Empieza el desafío...");
    }

    @FXML
    private void handleExitButtonAction() {
        // Lógica para cerrar la aplicación
        System.exit(0);
    }
    
}