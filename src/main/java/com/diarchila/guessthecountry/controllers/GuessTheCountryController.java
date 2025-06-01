package com.diarchila.guessthecountry.controllers;

import javafx.animation.RotateTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.util.Duration;

import java.util.List;

import com.diarchila.guessthecountry.models.Country;
import com.diarchila.guessthecountry.services.CountryServices;

public class GuessTheCountryController {

    @FXML
    private Label lblWelcome;

    @FXML
    private Label lblTitlegame;

    @FXML
    private Button startButton;

    @FXML
    private Button exitButton;

    // Lista de países
    List<Country> countries = CountryServices.COUNTRIES;

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

        // Imprimir información de los países en la consola
        for (int i = 0; i < countries.size(); i++) {
            Country country = countries.get(i);
            System.out.println("------------------ " + i + " ---------------------");
            System.out.println("Nombre: " + country.getName());
            System.out.println("Capital: " + country.getCapital());
            System.out.println("Región: " + country.getRegion());
            System.out.println("Bandera: " + country.getFlagUrlPNG());
            System.out.println("Moneda: " + country.getCurrency());
            System.out.println("Idiomas: " + country.getLanguages());
            
        }

    }

    @FXML
    private void handleExitButtonAction() {
        // Lógica para cerrar la aplicación
        System.exit(0);
    }

}