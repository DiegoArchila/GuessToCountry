package com.diarchila.guessthecountry.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.scene.Node;

public class GameController {

    @FXML
    private Label lblPregunta;

    @FXML
    private ImageView imagenBandera;

    @FXML
    private Button btnOpcion1, btnOpcion2, btnOpcion3, btnOpcion4;
    @FXML
    private Button btnSiguiente, btnSalirJuego;

    private String respuestaCorrecta = "Francia";  // Ejemplo fijo

    @FXML
    private void initialize() {
        lblPregunta.setText("¿A qué país pertenece esta bandera?");
        imagenBandera.setImage(new Image(getClass().getResource("/images/banderas/francia.png").toExternalForm()));

        btnOpcion1.setText("Francia");
        btnOpcion2.setText("Italia");
        btnOpcion3.setText("España");
        btnOpcion4.setText("Alemania");

        btnOpcion1.setOnAction(this::verificarRespuesta);
        btnOpcion2.setOnAction(this::verificarRespuesta);
        btnOpcion3.setOnAction(this::verificarRespuesta);
        btnOpcion4.setOnAction(this::verificarRespuesta);

        btnSiguiente.setOnAction(e -> cargarNuevaPregunta());
        btnSalirJuego.setOnAction(this::salirDelJuego);
    }

    private void verificarRespuesta(ActionEvent event) {
        Button boton = (Button) event.getSource();
        String seleccion = boton.getText();

        if (seleccion.equals(respuestaCorrecta)) {
            lblPregunta.setText("¡Correcto! 🎉");
        } else {
            lblPregunta.setText("Incorrecto 😞. Era: " + respuestaCorrecta);
        }
    }

    private void cargarNuevaPregunta() {
        lblPregunta.setText("¿A qué país pertenece esta bandera?");
        imagenBandera.setImage(new Image(getClass().getResource("/images/banderas/brasil.png").toExternalForm()));

        btnOpcion1.setText("Brasil");
        btnOpcion2.setText("México");
        btnOpcion3.setText("Argentina");
        btnOpcion4.setText("Chile");

        respuestaCorrecta = "Brasil";
    }

    private void salirDelJuego(ActionEvent event) {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }
}

